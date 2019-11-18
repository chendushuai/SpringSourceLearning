package com.sschen;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogLevelTest {
    public static void main(String[] args) {
        // 这只执行的强制转换，是为了能够设置日志级别
        // 这里获取的Logger是LogLevelTest的父级包，设置其Level用于覆盖自己的Level
        ch.qos.logback.classic.Logger fatherLog = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.sschen");
        fatherLog.setLevel(Level.INFO);

        // 日志级别优先级为
        // trace < debug < info < warn < error

        Logger childLog = LoggerFactory.getLogger(LogLevelTest.class);
        // 这句能够打印，因为继承的父级级别配置为INFO
        childLog.info("info log");
        // 这不不能打印，因为trace级别要小于info级别
        childLog.trace("trace log");
        // 这不能打印，因为debug级别小于info级别
        childLog.debug("debug log");
        // 这句能打印，因为warn级别要大于info级别
        childLog.warn("warn log");
        // 这句能打印，因为error级别大于info级别
        childLog.error("error log");
    }
}
