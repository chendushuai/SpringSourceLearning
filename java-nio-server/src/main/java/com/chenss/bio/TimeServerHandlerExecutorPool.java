package com.chenss.bio;

import java.util.concurrent.*;

/**
 * @author User
 * @date 2019-9-28 19:16:27
 */
public class TimeServerHandlerExecutorPool implements Executor {
    ExecutorService executorService;

    public TimeServerHandlerExecutorPool(int maxPoolSize, int queueSize) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        /**
         * @param corePoolSize 核心线程数量
         * @param maximumPoolSize 线程创建最大数量
         * @param keepAliveTime 当创建到了线程池最大数量时  多长时间线程没有处理任务，则线程销毁
         * @param unit keepAliveTime时间单位
         * @param workQueue 此线程池使用什么队列
         */
        this.executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    @Override
    public void execute(Runnable command) {
        this.executorService.execute(command);
    }
}
