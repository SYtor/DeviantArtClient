package ua.sytor.deviantartclient.core.logger;

import android.util.Log;

class AndroidLogPrinter implements LoggerContract.LogPrinter {

    private final static String TAG = "DArtClient";

    @Override
    public void print(String message) {
        Log.d(TAG, message);
    }

}
