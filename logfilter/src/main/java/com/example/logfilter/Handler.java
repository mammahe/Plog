package com.example.logfilter;

public interface Handler {


    public boolean isEnabled(Logger.Level level);

    public void print(String loggerName, Logger.Level level,
                      Throwable throwable, String message) throws IllegalArgumentException;

    public void print(String loggerName, Logger.Level level,
                      Throwable throwable, String messageFormat, Object... args) throws IllegalArgumentException;

}
