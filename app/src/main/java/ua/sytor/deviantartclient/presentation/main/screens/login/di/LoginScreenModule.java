package ua.sytor.deviantartclient.presentation.main.screens.login.di;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.login.LoginScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.login.LoginScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.login.LoginScreenView;

@Module
public class LoginScreenModule {

    @Provides
    public LoginScreenContract.View provideView(NavigatorContract.Navigator navigator) {
        return new LoginScreenView(navigator);
    }

    @Provides
    public BaseFragmentPresenter<LoginScreenContract.View> providePresenter(LoginScreenContract.View view) {
        return new LoginScreenPresenter(view);
    }

}
