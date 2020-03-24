package com.example.logfilter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class LoggerManager {

    private static final Handler DEFAULT_HANDLER = new PatternHandler(Logger.Level.VERBOSE, "%logger", "%date %caller%n");
    private static final Logger DEFAULT_LOGGER = new SimpleLogger(Logger.ROOT_LOGGER_NAME, DEFAULT_HANDLER);
    private static final int MAX_LOG_TAG_LENGTH = 23;
    private static final String PROPERTIES_NAME = "android-logger.properties";
    private static final String CONF_ROOT = "root";
    private static final String CONF_LOGGER = "logger.";
    private static final Pattern CONF_LOGGER_REGEX = Pattern.compile("(.*?):(.*?)(:(.*))?");
    private static final Map<String, Handler> HANDLER_MAP = Collections.unmodifiableMap(loadConfiguration());
    private static final Map<String, Logger> LOGGER_CACHE = new WeakHashMap<String, Logger>();

    private LoggerManager() {
        throw new UnsupportedOperationException();
    }

    private static void loadProperties(Properties properties) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = LoggerManager.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(PROPERTIES_NAME);
                if (inputStream != null) {
                    properties.load(inputStream);
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static Handler decodeHandler(String handlerString) {
        Matcher matcher = CONF_LOGGER_REGEX.matcher(handlerString);
        if (matcher.matches()) {
            String levelString = matcher.group(1);
            String tag = matcher.group(2);
            String message = matcher.group(4);
            if (tag.length() > 23) {
                String trimmedTag = tag.substring(0, MAX_LOG_TAG_LENGTH);
                DEFAULT_LOGGER.w("Android doesn't support tags %d characters longer. Tag '%s' will be trimmed to '%s'", MAX_LOG_TAG_LENGTH, tag, trimmedTag);
                tag = trimmedTag;
            }
            try {
                return new PatternHandler(Logger.Level.valueOf(levelString), tag, message);
            } catch (IllegalArgumentException e) {
                DEFAULT_LOGGER.w("Cannot parse '%s' as logging level. Only %s are allowed",
                        levelString, Arrays.toString(Logger.Level.values()));
                return null;
            }
        } else {
            DEFAULT_LOGGER.w("Wrong format of logger configuration: '%s'", handlerString);
            return null;
        }
    }

    private static Map<String, Handler> loadConfiguration() {
        Map<String, Handler> handlerMap = new HashMap<String, Handler>();

        Properties properties = new Properties();
        try {
            loadProperties(properties);
        } catch (IOException e) {
            DEFAULT_LOGGER.e(e, "Cannot configure logger from '%s'. Default configuration will be used", PROPERTIES_NAME);
            handlerMap.put(null, DEFAULT_HANDLER);
            return handlerMap;
        }

        // something is wrong if property file is empty
        if (!properties.propertyNames().hasMoreElements()) {
            DEFAULT_LOGGER.e("Logger configuration file is empty. Default configuration will be used");
            handlerMap.put(null, DEFAULT_HANDLER);
            return handlerMap;
        }

        for (Enumeration<?> names = properties.propertyNames(); names.hasMoreElements(); ) {
            String propertyName = (String) names.nextElement();
            String propertyValue = properties.getProperty(propertyName);

            Handler handler = decodeHandler(propertyValue);
            if (handler != null) {
                if (propertyName.equals(CONF_ROOT)) {
                    handlerMap.put(null, handler);
                } else if (propertyName.startsWith(CONF_LOGGER)) {
                    String loggerName = propertyName.substring(CONF_LOGGER.length());
                    if (loggerName.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME)) {
                        loggerName = null;
                    }
                    handlerMap.put(loggerName, handler);
                } else {
                    DEFAULT_LOGGER.e("unknown key '%s' in '%s' file", propertyName, PROPERTIES_NAME);
                }
            }
        }
        if (!handlerMap.containsKey(null)) {
            handlerMap.put(null, DEFAULT_HANDLER);
        }

        return handlerMap;
    }

    private static Handler findHandler(String name) {
        String currentKey = null;
        if (name != null) {
            for (String key : HANDLER_MAP.keySet()) {
                if (key != null && name.startsWith(key)) {
                    if (key.length() >= name.length()
                            || name.charAt(key.length()) == '.' || name.charAt(key.length()) == '$') {
                        if (currentKey == null || currentKey.length() < key.length()) {
                            currentKey = key;
                        }
                    }
                }
            }
        }
        Handler handler = HANDLER_MAP.get(currentKey);
        return handler != null ? handler : DEFAULT_HANDLER;
    }

    public static Logger getLogger(String name) {
        Logger logger;

        synchronized (LOGGER_CACHE) {
            logger = LOGGER_CACHE.get(name);
        }

        if (logger == null) {
            logger = new SimpleLogger(name, findHandler(name));
            synchronized (LOGGER_CACHE) {
                LOGGER_CACHE.put(logger.getName(), logger);
            }
        }

        return logger;
    }

    public static Logger getLogger(Class<?> aClass) {
        return getLogger(aClass == null ? null : aClass.getName());
    }

    public static Logger getLogger() {
        return getLogger(Utils.getCallerClassName());
    }

}
