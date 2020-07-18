package ua.sytor.deviantartclient.presentation.main.screens.auth.di;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.auth.AuthScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.auth.AuthScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.auth.AuthScreenView;

@Module
public class AuthScreenModule {

    @Provides
    public AuthScreenContract.View provideView(NavigatorContract.Navigator navigator) {
        return new AuthScreenView(navigator);
    }

    @Provides
    public BaseFragmentPresenter<AuthScreenContract.View> providePresenter(AuthScreenContract.View view) {
        return new AuthScreenPresenter(view);
    }

}
