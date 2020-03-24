package com.example.logfilter;

import android.util.Log;

public interface Logger {

    String ROOT_LOGGER_NAME = "PLogs";

    public String getName();

    public boolean isEnabled(Level level);

    public boolean isVerboseEnabled();

    public boolean isDebugEnabled();

    public boolean isInfoEnabled();

    public boolean isWarnEnabled();

    public boolean isErrorEnabled();

    public boolean isAssertEnabled();

    public void print(Level level, Throwable throwable, String message);

    public void print(Level level, Throwable throwable, String messageFormat, Object... args);

    public void v(String message, Throwable throwable);

    public void d(String message, Throwable throwable);

    public void i(String message, Throwable throwable);

    public void w(String message, Throwable throwable);

    public void e(String message, Throwable throwable);

    public void a(String message, Throwable throwable);

    public void v(Throwable throwable);

    public void d(Throwable throwable);

    public void i(Throwable throwable);

    public void w(Throwable throwable);

    public void e(Throwable throwable);

    public void a(Throwable throwable);

    public void v(Throwable throwable, String messageFormat, Object... args);

    public void d(Throwable throwable, String messageFormat, Object... args);

    public void i(Throwable throwable, String messageFormat, Object... args);

    public void w(Throwable throwable, String messageFormat, Object... args);

    public void e(Throwable throwable, String messageFormat, Object... args);

    public void a(Throwable throwable, String messageFormat, Object... args);

    public void v(Throwable throwable, String message);

    public void d(Throwable throwable, String message);

    public void i(Throwable throwable, String message);

    public void w(Throwable throwable, String message);

    public void e(Throwable throwable, String message);

    public void a(Throwable throwable, String message);

    public void v(String messageFormat, Object... args);

    public void d(String messageFormat, Object... args);

    public void i(String messageFormat, Object... args);

    public void w(String messageFormat, Object... args);

    public void e(String messageFormat, Object... args);

    public void a(String messageFormat, Object... args);

    public void v(String message);

    public void d(String message);

    public void i(String message);

    public void w(String message);

    public void e(String message);

    public void a(String message);

    public static enum Level {

        VERBOSE(Log.VERBOSE),

        DEBUG(Log.DEBUG),

        INFO(Log.INFO),

        WARN(Log.WARN),

        ERROR(Log.ERROR),

        ASSERT(Log.ASSERT);

        private final int intValue;

        private Level(int intValue) {
            this.intValue = intValue;
        }

        public int intValue() {
            return intValue;
        }

        public boolean includes(Level level) {
            return level != null && this.intValue() <= level.intValue();
        }

    }

}
