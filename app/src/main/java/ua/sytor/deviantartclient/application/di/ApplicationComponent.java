package ua.sytor.deviantartclient.application.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import ua.sytor.deviantartclient.application.DaggerApplication;
import ua.sytor.deviantartclient.core.network.di.NetworkModule;
import ua.sytor.deviantartclient.core.storage.di.StorageModule;
import ua.sytor.deviantartclient.core.use_case.UseCaseModule;
import ua.sytor.deviantartclient.presentation.main.screens.auth.di.AuthScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.login.di.LoginScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.login.di.LoginScreenModule;
import ua.sytor.deviantartclient.presentation.main.screens.search.di.SearchScreenComponent;

@Component(modules = {NetworkModule.class, StorageModule.class, UseCaseModule.class})
public interface ApplicationComponent {

    void inject(DaggerApplication application);

    LoginScreenComponent.Builder loginScreenBuilder();
    AuthScreenComponent.Builder authScreenBuilder();
    SearchScreenComponent.Builder searchScreenBuilder();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();

    }

}
