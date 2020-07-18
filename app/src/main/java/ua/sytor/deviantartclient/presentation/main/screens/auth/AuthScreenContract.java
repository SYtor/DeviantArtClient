package ua.sytor.deviantartclient.presentation.main.screens.auth;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.presentation.base.FragmentView;
import ua.sytor.deviantartclient.presentation.main.screens.auth.data.AuthRedirectData;

public interface AuthScreenContract {

    interface View extends FragmentView {
        Observable<AuthRedirectData> observeAuthState();

        void loadAuthPage(String url, String redirectUrl);

        void navigateToApp();
    }

    interface Presenter {

    }

}
