package ua.sytor.deviantartclient.presentation.main.screens.auth.di;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;
import ua.sytor.deviantartclient.core.navigator.di.NavigatorModule;
import ua.sytor.deviantartclient.presentation.main.screens.auth.AuthFragment;

@Subcomponent(modules = {AuthScreenModule.class, NavigatorModule.class})
public interface AuthScreenComponent {

    void inject(AuthFragment fragment);

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder fragment(Fragment fragment);

        AuthScreenComponent build();

    }

}
