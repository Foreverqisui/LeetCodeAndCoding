package com.pc.controller;


import org.apache.log4j.Logger;

/**
 * @author foreverqisui
 */
public class LoggerTest {
    static Logger logger=Logger.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.info("普通信息");
        logger.error("严重警告");
        logger.debug("调试信息");
        logger.warn("一般警告");
    }
}
