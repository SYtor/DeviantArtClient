package ua.sytor.deviantartclient.presentation.main.screens.image.di;

import dagger.Binds;
import dagger.Module;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.image.ImageScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.image.ImageScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.image.ImageScreenView;

@Module
public abstract class ImageScreenModule {

    @Binds
    public abstract ImageScreenContract.View provideView(ImageScreenView view);

    @Binds
    public abstract BaseFragmentPresenter<ImageScreenContract.View> providePresenter(
            ImageScreenPresenter presenter
    );

}
