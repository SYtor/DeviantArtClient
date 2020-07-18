package ua.sytor.deviantartclient.application;

import android.app.Application;

import ua.sytor.deviantartclient.application.di.ApplicationComponent;

public class DaggerApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }

}
