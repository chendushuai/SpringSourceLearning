package com.sschen.nio;

public class MessageBuffer {
    public static int KB = 1024;
    public static int MB = 1024 * KB;

    private static final int CAPACITY_SMALL = 4 * KB;
    private static final int CAPACITY_MEDIUM = 128 * KB;
    private static final int CAPACITY_LARGE = 1024 * KB;

    // 包范围 (默认) - 因此可以从单元测试中访问它们。
    // 1024 x 4KB messages = 4MB.
    byte[] smallMessageBuffer = new byte[1024 * 4 * KB];
    // 128 x 128KB messages = 16MB.
    byte[] mediumMessageBuffer = new byte[128 * 128 * KB];
    // 16 * 1MB messages = 16MB.
    byte[] largeMessageBuffer = new byte[16 * 1 * MB];

    // 1024 free sections
    QueueIntFlip smallMessageBufferFreeBlocks = new QueueIntFlip(1024);
    // 128 free sections
    QueueIntFlip mediumMessageBufferFreeBlocks = new QueueIntFlip(128);
    // 16 free sections
    QueueIntFlip largeMessageBufferFreeBlocks = new QueueIntFlip(16);

    // todo 使所有消息缓冲区容量和块大小可配置
    // todo 根据缓冲区的容量和块大小计算空闲块队列大小。

    public MessageBuffer() {
        // 将所有空闲节添加到所有空闲节队列。
        for (int i = 0; i < smallMessageBuffer.length; i += CAPACITY_SMALL) {
            this.smallMessageBufferFreeBlocks.put(i);
        }
        for (int i = 0; i < mediumMessageBuffer.length; i += CAPACITY_MEDIUM) {
            this.mediumMessageBufferFreeBlocks.put(i);
        }
        for (int i = 0; i < largeMessageBuffer.length; i += CAPACITY_LARGE) {
            this.largeMessageBufferFreeBlocks.put(i);
        }
    }

    public Message getMessage() {
        int nextFreeSmallBlock = this.smallMessageBufferFreeBlocks.take();

        if (nextFreeSmallBlock == -1) return null;

        // todo 从消息池获取内存使用上限。
        Message message = new Message(this);

        message.sharedArray = this.smallMessageBuffer;
        message.capacity = CAPACITY_SMALL;
        message.offset = nextFreeSmallBlock;
        message.length = 0;

        return message;
    }

    public boolean expandMessage(Message message) {
        if (message.capacity == CAPACITY_SMALL) {
            return moveMessage(message, this.smallMessageBufferFreeBlocks, this.mediumMessageBufferFreeBlocks, this.mediumMessageBuffer, CAPACITY_MEDIUM);
        } else if (message.capacity == CAPACITY_MEDIUM) {
            return moveMessage(message, this.mediumMessageBufferFreeBlocks, this.largeMessageBufferFreeBlocks, this.largeMessageBuffer, CAPACITY_LARGE);
        } else {
            return false;
        }
    }

    private boolean moveMessage(Message message, QueueIntFlip srcBlockQueue, QueueIntFlip destBlockQueue, byte[] dest, int newCapacity) {
        int nextFreeBlock = destBlockQueue.take();
        if (nextFreeBlock == -1) return false;

        System.arraycopy(message.sharedArray, message.offset, dest, nextFreeBlock, message.length);

        // 复制后释放较小的块
        srcBlockQueue.put(message.offset);

        message.sharedArray = dest;
        message.offset = nextFreeBlock;
        message.capacity = newCapacity;
        return true;
    }
}
