package ua.sytor.deviantartclient.core.logger;

public interface LoggerContract {

    interface LogPrinter {
        void print(String message);
    }

    interface Logger {
        void d(String message);
    }

}
