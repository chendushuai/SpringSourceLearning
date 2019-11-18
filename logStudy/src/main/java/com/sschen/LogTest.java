package com.sschen;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    /**
     * 如果给定的全限定名称一样，则获取的日志对象是一个
     */
    private static Logger logger = LoggerFactory.getLogger(LogTest.class);
    public static void main(String[] args) {
        logger.info("info log");
        logger.trace("trace log");
        logger.debug("debug log");
        logger.warn("warn log");
        logger.error("error log",new Exception("测试异常内容"));

        // 打印 Logback 内部状态
        LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);
    }
}
