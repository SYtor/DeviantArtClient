package ua.sytor.deviantartclient.core.utils;

import android.content.Context;

import ua.sytor.deviantartclient.application.DaggerApplication;
import ua.sytor.deviantartclient.application.di.ApplicationComponent;

public class DiUtils {

    static ApplicationComponent getAppComponent(Context context) {
        return ((DaggerApplication) context.getApplicationContext()).getAppComponent();
    }

}
