package ua.sytor.deviantartclient.core.logger;

import android.util.Log;

public class Logger {

    private final static String TAG = "DArtClient";

    public static void log(String message) {
        Log.d(TAG, message);
    }

}
