package com.sschen.nio;

import java.nio.ByteBuffer;

/**
 * @author chendushuai
 */
public class Message {
    private MessageBuffer messageBuffer = null;

    // 源套接字或目标套接字的id，取决于输入或输出。
    public long socketId = 0;

    public byte[] sharedArray = null;
    // 偏移到此消息数据开始的sharedArray中。
    public int offset = 0;
    // 分配给此消息的sharedArray中的节的大小。
    public int capacity = 0;
    // 已分配节使用的字节数。
    public int length = 0;

    public Object metaData = null;

    public Message(MessageBuffer messageBuffer) {
        this.messageBuffer = messageBuffer;
    }

    /**
     * 将字节缓冲区中的数据写入此消息—即写入支持此消息的缓冲区。
     *
     * @param byteBuffer 包含要写入的消息数据的ByteBuffer。
     * @return
     */
    public int writeToMessage(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();

        while (this.length + remaining > capacity) {
            if (!this.messageBuffer.expandMessage(this)) {
                return -1;
            }
        }

        int bytesToCopy = Math.min(remaining, this.capacity - this.length);
        byteBuffer.get(this.sharedArray, this.offset + this.length, bytesToCopy);
        this.length += bytesToCopy;

        return bytesToCopy;
    }

    /**
     * 将字节数组中的数据写入此消息—即写入支持此消息的缓冲区。
     *
     * @param byteArray 包含要写入的消息数据的字节数组。
     * @return
     */
    public int writeToMessage(byte[] byteArray) {
        return writeToMessage(byteArray, 0, byteArray.length);
    }

    /**
     * 将字节数组中的数据写入此消息—即写入支持此消息的缓冲区。
     *
     * @param byteArray 包含要写入的消息数据的字节数组。
     * @return
     */
    public int writeToMessage(byte[] byteArray, int offset, int length) {
        int remaining = length;

        while (this.length + remaining > capacity) {
            if (!this.messageBuffer.expandMessage(this)) {
                return -1;
            }
        }

        int bytesToCopy = Math.min(remaining, this.capacity - this.length);
        System.arraycopy(byteArray, offset, this.sharedArray, this.offset + this.length, bytesToCopy);
        this.length += bytesToCopy;
        return bytesToCopy;
    }


    /**
     * 如果支持nextMessage的缓冲区包含多个HTTP消息，则将第一个消息之后的所有数据移动到一个新的message对象。
     *
     * @param message  包含部分消息的消息(在第一个消息之后)。
     * @param endIndex 给定作为参数的消息的缓冲区中第一个消息的结束索引。
     */
    public void writePartialMessageToMessage(Message message, int endIndex) {
        int startIndexOfPartialMessage = message.offset + endIndex;
        int lengthOfPartialMessage = (message.offset + message.length) - endIndex;

        System.arraycopy(message.sharedArray, startIndexOfPartialMessage, this.sharedArray, this.offset, lengthOfPartialMessage);
    }

    public int writeToByteBuffer(ByteBuffer byteBuffer) {
        return 0;
    }
}
