package com.sschen;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private static Logger logger = LoggerFactory.getLogger(LogTest.class);
    public static void main(String[] args) {
        logger.info("info log");
        logger.trace("trace log");
        logger.debug("debug log");
        logger.warn("warn log");
        logger.error("error log");

        // 打印 Logback 内部状态
        LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);
    }
}
