package ua.sytor.deviantartclient.presentation.main.screens.login.di;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;
import ua.sytor.deviantartclient.core.navigator.di.NavigatorModule;
import ua.sytor.deviantartclient.presentation.main.screens.login.LoginFragment;

@Subcomponent(modules = {LoginScreenModule.class, NavigatorModule.class})
public interface LoginScreenComponent {

    void inject(LoginFragment fragment);

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder fragment(Fragment fragment);

        LoginScreenComponent build();

    }

}
