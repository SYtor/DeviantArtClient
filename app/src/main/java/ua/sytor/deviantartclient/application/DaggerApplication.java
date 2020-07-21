package ua.sytor.deviantartclient.application;

import android.app.Application;

import ua.sytor.deviantartclient.application.di.ApplicationComponent;
import ua.sytor.deviantartclient.application.di.DaggerApplicationComponent;

public class DaggerApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
    }

    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }

}
