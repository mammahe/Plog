package com.example.logfilter;

import android.os.Build;

import androidx.annotation.RequiresApi;

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
            LoggerManager.getLogger().v(tag, getCallingMethod() + msg);
        }
    }

    public static void v(String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().v(msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void v(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            LoggerManager.getLogger().v(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void v(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            LoggerManager.getLogger().v(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void v(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            LoggerManager.getLogger().v(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void v(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().v(tag, getCallingMethod() + msg, throwable);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void d(String tag, String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().d(tag, getCallingMethod() + msg);
        }
    }

    public static void d(String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().v(msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void d(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            LoggerManager.getLogger().d(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void d(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            LoggerManager.getLogger().d(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void d(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            LoggerManager.getLogger().d(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void d(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().d(tag, getCallingMethod() + msg, throwable);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void i(String tag, String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().i(tag, getCallingMethod() + msg);
        }
    }

    public static void i(String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().v(msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void i(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            LoggerManager.getLogger().i(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void i(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            LoggerManager.getLogger().i(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void i(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            LoggerManager.getLogger().i(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void i(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().i(tag, getCallingMethod() + msg, throwable);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void w(String tag, String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().w(tag, getCallingMethod() + msg);
        }
    }

    public static void w(String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().v(msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void w(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            LoggerManager.getLogger().w(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void w(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            LoggerManager.getLogger().w(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void w(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            LoggerManager.getLogger().w(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void w(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().w(tag, getCallingMethod() + msg, throwable);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void e(String tag, String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().e(tag, getCallingMethod() + msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void e(String tag, String format, Object arg) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg);
            LoggerManager.getLogger().e(tag, getCallingMethod() + ft.getMessage());
        }
    }

    public static void e(String msg) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().v(msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void e(String tag, String format, Object arg1, Object arg2) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, arg1, arg2);
            LoggerManager.getLogger().e(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void e(String tag, String format, Object[] args) {
        if (Environment.LOGGING) {
            FormateClass ft = MessageFormatter.format(format, args);
            LoggerManager.getLogger().e(tag, getCallingMethod() + ft.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void e(String tag, String msg, Throwable throwable) {
        if (Environment.LOGGING) {
            LoggerManager.getLogger().e(tag, getCallingMethod() + msg, throwable);
        }
    }

    private static String getCallingMethod() {
        return Thread.currentThread().getStackTrace()[4].getMethodName() + "()" + ":"
                + Thread.currentThread().getStackTrace()[4].getLineNumber() + " > ";
    }
}