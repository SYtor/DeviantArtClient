package ua.sytor.deviantartclient.presentation.main.screens.auth;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.presentation.base.FragmentView;

public interface AuthScreenContract {

    interface View extends FragmentView {
        Observable<AuthData> observeAuthState();

        void loadAuthPage(String url);

        void navigateToApp();
    }

    interface Presenter {

    }

    class AuthData {

        public String code;

        AuthData(String code) {
            this.code = code;
        }
    }

}
