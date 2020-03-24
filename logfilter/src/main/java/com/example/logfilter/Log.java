package com.example.logfilter;

public final class Log {

    private Log() {
        throw new UnsupportedOperationException();
    }

    public static boolean isEnabled(Logger.Level level) {
        return LoggerManager.getLogger().isEnabled(level);
    }

    public static boolean isVerboseEnabled() {
        return LoggerManager.getLogger().isVerboseEnabled();
    }

    public static boolean isDebugEnabled() {
        return LoggerManager.getLogger().isDebugEnabled();
    }

    public static boolean isInfoEnabled() {
        return LoggerManager.getLogger().isInfoEnabled();
    }

    public static boolean isWarnEnabled() {
        return LoggerManager.getLogger().isWarnEnabled();
    }

    public static boolean isErrorEnabled() {
        return LoggerManager.getLogger().isErrorEnabled();
    }

    public static boolean isAssertEnabled() {
        return LoggerManager.getLogger().isAssertEnabled();
    }

    public static void print(Logger.Level level, Throwable throwable, String message) {
        LoggerManager.getLogger().print(level, throwable, message);
    }

    public static void print(Logger.Level level, Throwable throwable, String messageFormat, Object... args) {
        LoggerManager.getLogger().print(level, throwable, messageFormat, args);
    }

    public static void v(String message, Throwable throwable) {
        LoggerManager.getLogger().v(message, throwable);
    }

    public static void d(String message, Throwable throwable) {
        LoggerManager.getLogger().d(message, throwable);
    }

    public static void i(String message, Throwable throwable) {
        LoggerManager.getLogger().i(message, throwable);
    }

    public static void w(String message, Throwable throwable) {
        LoggerManager.getLogger().w(message, throwable);
    }

    public static void e(String message, Throwable throwable) {
        LoggerManager.getLogger().e(message, throwable);
    }

    public static void a(String message, Throwable throwable) {
        LoggerManager.getLogger().a(message, throwable);
    }

    public static void v(Throwable throwable) {
        LoggerManager.getLogger().v(throwable);
    }

    public static void d(Throwable throwable) {
        LoggerManager.getLogger().d(throwable);
    }

    public static void i(Throwable throwable) {
        LoggerManager.getLogger().i(throwable);
    }

    public static void w(Throwable throwable) {
        LoggerManager.getLogger().w(throwable);
    }

    public static void e(Throwable throwable) {
        LoggerManager.getLogger().e(throwable);
    }

    public static void a(Throwable throwable) {
        LoggerManager.getLogger().a(throwable);
    }

    public static void v(Throwable throwable, String messageFormat, Object... args) {
        LoggerManager.getLogger().v(throwable, messageFormat, args);
    }

    public static void d(Throwable throwable, String messageFormat, Object... args) {
        LoggerManager.getLogger().d(throwable, messageFormat, args);
    }

    public static void i(Throwable throwable, String messageFormat, Object... args) {
        LoggerManager.getLogger().i(throwable, messageFormat, args);
    }

    public static void w(Throwable throwable, String messageFormat, Object... args) {
        LoggerManager.getLogger().w(throwable, messageFormat, args);
    }

    public static void e(Throwable throwable, String messageFormat, Object... args) {
        LoggerManager.getLogger().e(throwable, messageFormat, args);
    }

    public static void a(Throwable throwable, String messageFormat, Object... args) {
        LoggerManager.getLogger().a(throwable, messageFormat, args);
    }

    public static void v(Throwable throwable, String message) {
        LoggerManager.getLogger().v(throwable, message);
    }

    public static void d(Throwable throwable, String message) {
        LoggerManager.getLogger().d(throwable, message);
    }

    public static void i(Throwable throwable, String message) {
        LoggerManager.getLogger().i(throwable, message);
    }

    public static void w(Throwable throwable, String message) {
        LoggerManager.getLogger().w(throwable, message);
    }

    public static void e(Throwable throwable, String message) {
        LoggerManager.getLogger().e(throwable, message);
    }

    public static void a(Throwable throwable, String message) {
        LoggerManager.getLogger().a(throwable, message);
    }

    public static void v(String messageFormat, Object... args) {
        LoggerManager.getLogger().v(messageFormat, args);
    }

    public static void d(String messageFormat, Object... args) {
        LoggerManager.getLogger().d(messageFormat, args);
    }

    public static void i(String messageFormat, Object... args) {
        LoggerManager.getLogger().i(messageFormat, args);
    }

    public static void w(String messageFormat, Object... args) {
        LoggerManager.getLogger().w(messageFormat, args);
    }

    public static void e(String messageFormat, Object... args) {
        LoggerManager.getLogger().e(messageFormat, args);
    }

    public static void a(String messageFormat, Object... args) {
        LoggerManager.getLogger().a(messageFormat, args);
    }

    public static void v(String message) {
        LoggerManager.getLogger().v(message);
    }

    public static void d(String message) {
        LoggerManager.getLogger().d(message);
    }

    public static void i(String message) {
        LoggerManager.getLogger().i(message);
    }

    public static void w(String message) {
        LoggerManager.getLogger().w(message);
    }

    public static void e(String message) {
        LoggerManager.getLogger().e(message);
    }

    public static void a(String message) {
        LoggerManager.getLogger().a(message);
    }

}
