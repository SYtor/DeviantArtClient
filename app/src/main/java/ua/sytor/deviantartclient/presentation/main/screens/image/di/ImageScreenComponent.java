package ua.sytor.deviantartclient.presentation.main.screens.image.di;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Subcomponent;
import ua.sytor.deviantartclient.core.navigator.di.NavigatorModule;
import ua.sytor.deviantartclient.presentation.main.screens.image.ImageFragment;

@Subcomponent(modules = {ImageScreenModule.class, NavigatorModule.class})
public interface ImageScreenComponent {

    void inject(ImageFragment fragment);

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder fragment(Fragment fragment);

        ImageScreenComponent build();

    }

}
