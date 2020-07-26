package ua.sytor.deviantartclient.presentation.main.screens.login.di;

import dagger.Binds;
import dagger.Module;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.login.LoginScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.login.LoginScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.login.LoginScreenView;

@Module
public abstract class LoginScreenModule {

    @Binds
    public abstract LoginScreenContract.View provideView(LoginScreenView view);

    @Binds
    public abstract BaseFragmentPresenter<LoginScreenContract.View> providePresenter(
            LoginScreenPresenter presenter
    );

}
