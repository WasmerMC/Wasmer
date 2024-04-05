package me.theclashfruit.wasmer.wasm;

import com.dylibso.chicory.log.Logger;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerBridge implements Logger {
    @Override
    public void log(Level level, String msg, Throwable throwable) {
        switch (level) {
            case DEBUG -> LOGGER.debug(msg, throwable);
            case INFO -> LOGGER.info(msg, throwable);
            case WARNING -> LOGGER.warn(msg, throwable);
            case ERROR -> LOGGER.error(msg, throwable);
            case ALL, TRACE -> LOGGER.trace(msg, throwable);
            default -> throw new IllegalArgumentException("Unknown log level: " + level);
        }
    }

    @Override
    public boolean isLoggable(Level level) {
        return (
            (level == Level.DEBUG && LOGGER.isDebugEnabled()) ||
            (level == Level.INFO && LOGGER.isInfoEnabled()) ||
            (level == Level.WARNING && LOGGER.isWarnEnabled()) ||
            (level == Level.ERROR && LOGGER.isErrorEnabled()) ||
            (level == Level.ALL && LOGGER.isTraceEnabled()) ||
            (level == Level.TRACE && LOGGER.isTraceEnabled())
        );
    }
}
