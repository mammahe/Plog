package com.example.logfilter;

public final class Utils {

    private static final String PACKAGE_NAME = Logger.class.getPackage().getName();
    private static final CallerResolver CALLER_RESOLVER = new CallerResolver();

    private Utils() {
        throw new UnsupportedOperationException();
    }

    private static StackTraceElement getCallerStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }

        boolean packageFound = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!packageFound) {
                if (stackTraceElement.getClassName().startsWith(PACKAGE_NAME)) {
                    packageFound = true;
                }
            } else {
                if (!stackTraceElement.getClassName().startsWith(PACKAGE_NAME)) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[stackTrace.length - 1];
    }

    public static String getCallerClassName() {
        Class<?> caller = CALLER_RESOLVER.getCaller();
        if (caller == null) {
            StackTraceElement callerStackTrace = getCallerStackTrace();
            return callerStackTrace == null ? null : callerStackTrace.getClassName();
        } else {
            return caller.getName();
        }
    }

    public static StackTraceElement getCaller() {
        return getCallerStackTrace();
    }

    public static String shorten(String string, int count, int length) {

        if (string == null) return null;

        String resultString = string;
        if (Math.abs(length) < resultString.length()) {
            if (length > 0)
                resultString = string.substring(0, length);
            if (length < 0)
                resultString = string.substring(string.length() + length, string.length());
        }

        if (Math.abs(count) > resultString.length()) {

            return String.format("%" + count + "s", resultString);
        }

        return resultString;
    }

    // todo optimize it
    public static String shortenClassName(String className, int count, int maxLength) {

        className = shortenPackagesName(className, count);

        if (className == null) return null;
        if (maxLength == 0) return className;
        if (maxLength > className.length()) return className;

        if (maxLength < 0) {
            maxLength = -maxLength;
            StringBuilder builder = new StringBuilder();
            for (int index = className.length() - 1; index > 0; ) {
                int i = className.lastIndexOf('.', index);

                if (i == -1) {
                    if (builder.length() > 0
                            && builder.length() + index + 1 > maxLength) {
                        builder.insert(0, '*');
                        break;
                    }

                    builder.insert(0, className.substring(0, index + 1));
                } else {
                    if (builder.length() > 0
                            && builder.length() + (index + 1 - i) + 1 > maxLength) {
                        builder.insert(0, '*');
                        break;
                    }

                    builder.insert(0, className.substring(i, index + 1));
                }

                index = i - 1;
            }
            return builder.toString();

        } else {
            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < className.length(); ) {
                int i = className.indexOf('.', index);

                if (i == -1) {
                    if (builder.length() > 0) {
                        builder.insert(builder.length(), '*');
                        break;
                    }

                    builder.insert(builder.length(), className.substring(index, className.length()));
                    break;
                } else {
                    if (builder.length() > 0
                            && i + 1 > maxLength) {
                        builder.insert(builder.length(), '*');
                        break;
                    }

                    builder.insert(builder.length(), className.substring(index, i + 1));
                }

                index = i + 1;
            }

            return builder.toString();
        }
    }

    // todo optimize it
    private static String shortenPackagesName(String className, int count) {
        if (className == null) return null;
        if (count == 0) return className;

        StringBuilder builder = new StringBuilder();
        if (count > 0) {
            int points = 1;
            for (int index = 0; index < className.length(); ) {
                int i = className.indexOf('.', index);

                if (i == -1) {
                    builder.insert(builder.length(), className.substring(index, className.length()));
                    break;

                } else {
                    if (points == count) {
                        builder.insert(builder.length(), className.substring(index, i));
                        break;
                    }
                    builder.insert(builder.length(), className.substring(index, i + 1));
                }
                index = i + 1;
                points++;
            }
        } else if (count < 0) {
            String exceptString = shortenPackagesName(className, -count);
            if (className.equals(exceptString)) {
                int from = className.lastIndexOf('.') + 1;
                int to = className.length();
                builder.insert(builder.length(), className.substring(from, to));
            } else
                return className.replaceFirst(exceptString + '.', "");
        }
        return builder.toString();
    }

    private static final class CallerResolver extends SecurityManager {
        public Class<?> getCaller() {
            Class[] classContext = getClassContext();

            if (classContext == null || classContext.length <= 0) {
                return null;
            }

            boolean packageFound = false;
            for (Class aClass : classContext) {
                if (!packageFound) {
                    if (aClass.getPackage().getName().startsWith(PACKAGE_NAME)) {
                        packageFound = true;
                    }
                } else {
                    if (!aClass.getPackage().getName().startsWith(PACKAGE_NAME)) {
                        return aClass;
                    }
                }
            }
            return classContext[classContext.length - 1];
        }
    }

}
