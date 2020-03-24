package com.example.logfilter;

import android.util.Log;

public class PLog {

    static class Environment{
        static final boolean LOGGING=true;
    }

    public static final String TAG_COMMON = "PLog";

    public static boolean isLoggingEnabled() {
        return Environment.LOGGING;
    }

    private static String getTag(String appTag, String className) {
        return ((appTag != null) ? appTag + "." : "") + className;
    }

    public static String getTag(String appTag, Class<?> clazz) {
        return getTag(appTag, clazz.getName());
    }

    public static void v(String tag, String msg) {
        if (Environment.LOGGING) {
            Log.v(tag, getCallingMethod(4) + msg);
        }
    }

    public static void v(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            Log.v(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void v(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            Log.v(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void v(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            Log.v(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void v(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            Log.v(tag, getCallingMethod(4) + msg, throwable);
        }
    }

    public static void d(String tag, String msg) {
        if (Environment.LOGGING) {
            Log.d(tag, getCallingMethod(4) + msg);
        }
    }

    public static void d(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            Log.d(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void d(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            Log.d(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void d(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            Log.d(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void d(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            Log.d(tag, getCallingMethod(4) + msg, throwable);
        }
    }

    public static void i(String tag, String msg) {
        if (Environment.LOGGING) {
            Log.i(tag, getCallingMethod(4) + msg);
        }
    }

    public static void i(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            Log.i(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void i(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            Log.i(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void i(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            Log.i(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void i(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            Log.i(tag, getCallingMethod(4) + msg, throwable);
        }
    }

    public static void w(String tag, String msg) {
        if (Environment.LOGGING) {
            Log.w(tag, getCallingMethod(4) + msg);
        }
    }

    public static void w(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            Log.w(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void w(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            Log.w(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void w(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            Log.w(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void w(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            Log.w(tag, getCallingMethod(4) + msg, throwable);
        }
    }

    public static void e(String tag, String msg) {
        if (Environment.LOGGING) {
            Log.e(tag, getCallingMethod(4) + msg);
        }
    }

    public static void e(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            Log.e(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void e(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            Log.e(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void e(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            Log.e(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            Log.e(tag, getCallingMethod(4) + msg, throwable);
        }
    }

    public static void wtf(String tag, String msg) {
        if (Environment.LOGGING) {
            Log.wtf(tag, getCallingMethod(4) + msg);
        }
    }

    public static void wtf(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            Log.wtf(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void wtf(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            Log.wtf(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void wtf(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            Log.wtf(tag, getCallingMethod(4) + ft.getMessage());
        }
    }

    public static void wtf(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            Log.wtf(tag, getCallingMethod(4) + msg, throwable);
        }
    }

    private static String getCallingMethod(int stack) {
        return Thread.currentThread().getStackTrace()[stack].getMethodName() + "()" + ":"
                + Thread.currentThread().getStackTrace()[stack].getLineNumber() + " > ";
    }
}