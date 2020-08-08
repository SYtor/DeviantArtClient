package ua.sytor.deviantartclient.core.utils;

public class Complete {

    private static final Complete ourInstance = new Complete();

    private Complete() {
    }

    public static Complete getInstance() {
        return ourInstance;
    }

}
