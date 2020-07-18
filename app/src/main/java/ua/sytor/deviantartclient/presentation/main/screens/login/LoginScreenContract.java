package ua.sytor.deviantartclient.presentation.main.screens.login;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.presentation.base.FragmentView;

public interface LoginScreenContract {

    interface View extends FragmentView {

        Observable<LoginOption> onButtonSelected();

        void navigateAuthScreen();

        void navigateToApp();

    }

    interface Presenter {

    }

    enum LoginOption {
        AUTH,
        SKIP_AUTH
    }

}
