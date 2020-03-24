package com.example.logfilter;

public class SimpleLogger extends AbstractLogger {

    private final Handler handler;


    public SimpleLogger(String name, Handler handler) {
        super(name);
        this.handler = handler;
    }

    @Override
    public boolean isEnabled(Level level) {
        return handler != null && handler.isEnabled(level);
    }

    @Override
    public void print(Level level, Throwable throwable, String message) {
        if (handler != null) {
            handler.print(getName(), level, throwable, message);
        }
    }

    @Override
    public void print(Level level, Throwable throwable, String messageFormat, Object... args) {
        if (handler != null) {
            handler.print(getName(), level, throwable, messageFormat, args);
        }
    }

}
