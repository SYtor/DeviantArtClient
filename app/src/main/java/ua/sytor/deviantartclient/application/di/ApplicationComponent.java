package ua.sytor.deviantartclient.application.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import ua.sytor.deviantartclient.application.DaggerApplication;
import ua.sytor.deviantartclient.core.network.di.NetworkModule;
import ua.sytor.deviantartclient.core.paginator.di.PaginatorModule;
import ua.sytor.deviantartclient.core.storage.di.StorageModule;
import ua.sytor.deviantartclient.core.use_case.UseCaseModule;
import ua.sytor.deviantartclient.presentation.main.screens.auth.di.AuthScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.host.di.HostScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.host.screens.search.di.SearchScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.image.di.ImageScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.login.di.LoginScreenComponent;

@Component(modules = {NetworkModule.class, StorageModule.class, UseCaseModule.class, PaginatorModule.class})
public interface ApplicationComponent {

    void inject(DaggerApplication application);

    LoginScreenComponent.Builder loginScreenBuilder();

    AuthScreenComponent.Builder authScreenBuilder();

    HostScreenComponent.Builder hostScreenBuilder();

    SearchScreenComponent.Builder searchScreenBuilder();

    ImageScreenComponent.Builder imageScreenBuilder();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();

    }

}
