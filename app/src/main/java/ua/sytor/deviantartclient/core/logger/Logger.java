package ua.sytor.deviantartclient.core.logger;

public class Logger {

    private static LoggerContract.LogPrinter logPrinter = new AndroidLogPrinter();

    public static void setLogPrinter(LoggerContract.LogPrinter printer) {
        logPrinter = printer;
    }

    public static void log(String message) {
        print(message);
    }

    public static void log(String format, Object... arguments) {
        String message = String.format(format, arguments);
        print(message);
    }

    private static void print(String message) {
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        StackTraceElement callingElement = stackTrace[4];

        String threadName = currentThread.getName();

        String[] classFullPackage = callingElement.getClassName().split("\\.");
        String className = classFullPackage[classFullPackage.length - 1];

        String methodName = callingElement.getMethodName();

        String log = String.format("%s %s[%s] %s", threadName, className, methodName, message);
        logPrinter.print(log);
    }

}
