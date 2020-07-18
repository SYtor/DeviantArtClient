package ua.sytor.deviantartclient.application.di;

import dagger.Component;
import ua.sytor.deviantartclient.application.DaggerApplication;

@Component
public interface ApplicationComponent {

    void inject(DaggerApplication application);

}
