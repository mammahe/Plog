package com.example.logfilter;

import android.util.Log;

public class PatternHandler implements Handler {

    private final Logger.Level level;
    private final String tagPattern;
    private final String messagePattern;
    private final Pattern compiledTagPattern;
    private final Pattern compiledMessagePattern;


    public PatternHandler(Logger.Level level, String tagPattern, String messagePattern) {
        this.level = level;
        this.tagPattern = tagPattern;
        this.compiledTagPattern = Pattern.compile(tagPattern);
        this.messagePattern = messagePattern;
        this.compiledMessagePattern = Pattern.compile(messagePattern);
    }


    public Logger.Level getLevel() {
        return level;
    }


    public String getTagPattern() {
        return tagPattern;
    }


    public String getMessagePattern() {
        return messagePattern;
    }

    @Override
    public boolean isEnabled(Logger.Level level) {
        return this.level != null && level != null && this.level.includes(level);
    }

    @Override
    public void print(String loggerName, Logger.Level level,
                      Throwable throwable, String message) throws IllegalArgumentException {
        if (isEnabled(level)) {
            String messageBody;

            if (message == null) {
                if (throwable == null) {
                    messageBody = "";
                } else {
                    messageBody = Log.getStackTraceString(throwable);
                }
            } else {
                if (throwable == null) {
                    messageBody = message;
                } else {
                    messageBody = message + '\n' + Log.getStackTraceString(throwable);
                }
            }

            StackTraceElement caller = null;
            if ((compiledTagPattern != null && compiledTagPattern.isCallerNeeded())
                    || (compiledMessagePattern != null && compiledMessagePattern.isCallerNeeded())) {
                caller = Utils.getCaller();
            }

            String tag = compiledTagPattern == null ? "" : compiledTagPattern.apply(caller, loggerName, level);
            String messageHead = compiledMessagePattern == null ? "" : compiledMessagePattern.apply(caller, loggerName, level);

            if (messageHead.length() > 0 && !Character.isWhitespace(messageHead.charAt(0))) {
                messageHead = messageHead + " ";
            }
            Log.println(level.intValue(), tag, messageHead + messageBody);
        }
    }

    @Override
    public void print(String loggerName, Logger.Level level,
                      Throwable throwable, String messageFormat, Object... args) throws IllegalArgumentException {
        if (isEnabled(level)) {
            if (messageFormat == null && args != null && args.length > 0) {
                throw new IllegalArgumentException("message format is not set but arguments are presented");
            }

            print(loggerName, level, throwable, messageFormat == null ? null : String.format(messageFormat, args));
        }
    }

}
