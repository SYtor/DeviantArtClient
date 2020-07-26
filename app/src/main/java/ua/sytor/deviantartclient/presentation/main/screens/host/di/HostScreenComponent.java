package ua.sytor.deviantartclient.presentation.main.screens.host.di;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Subcomponent;
import ua.sytor.deviantartclient.core.navigator.di.NavigatorModule;
import ua.sytor.deviantartclient.presentation.main.screens.host.HostFragment;

@Subcomponent(modules = {HostScreenModule.class, NavigatorModule.class})
public interface HostScreenComponent {

    void inject(HostFragment fragment);

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder fragment(Fragment fragment);

        HostScreenComponent build();

    }

}
