package com.test.base.aspect;


import com.test.base.aspect.enums.LogLevel;
import org.slf4j.Logger;

/**
 * Created by Administrator on 2017/4/25.
 */
public class LogUtils {
    public static void log(Logger LOGGER, LogLevel logLevel, String format, Object... arguments) {
        if (logLevel == LogLevel.debug) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(format, arguments);
            }
        } else if (logLevel == LogLevel.info) {
            LOGGER.info(format, arguments);
        } else if (logLevel == LogLevel.warn) {
            LOGGER.warn(format, arguments);
        } else if (logLevel == LogLevel.error) {
            LOGGER.error(format, arguments);
        } else {
            LOGGER.info(format, arguments);
        }
    }

    public static void log(Logger LOGGER, LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.debug) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(msg);
            }
        } else if (logLevel == LogLevel.info) {
            LOGGER.info(msg);
        } else if (logLevel == LogLevel.warn) {
            LOGGER.warn(msg);
        } else if (logLevel == LogLevel.error) {
            LOGGER.error(msg);
        } else {
            LOGGER.info(msg);
        }
    }
    public static void log(Logger LOGGER, String msg) {

            LOGGER.info(msg);
    }
}
