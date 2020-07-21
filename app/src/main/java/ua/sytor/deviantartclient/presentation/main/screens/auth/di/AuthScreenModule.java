package ua.sytor.deviantartclient.presentation.main.screens.auth.di;

import dagger.Binds;
import dagger.Module;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.auth.AuthScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.auth.AuthScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.auth.AuthScreenView;

@Module
public abstract class AuthScreenModule {

    @Binds
    public abstract AuthScreenContract.View provideView(AuthScreenView impl);

    @Binds
    public abstract BaseFragmentPresenter<AuthScreenContract.View> providePresenter(AuthScreenPresenter impl);

}
