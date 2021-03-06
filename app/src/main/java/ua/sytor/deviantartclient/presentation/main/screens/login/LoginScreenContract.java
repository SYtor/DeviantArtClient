package ua.sytor.deviantartclient.presentation.main.screens.login;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.presentation.base.FragmentView;

public interface LoginScreenContract {

    interface View extends FragmentView {

        Observable<Integer> observeButtonClick();

        void setLoadingVisibility(boolean isVisible);

        void setLoadedVisibility(boolean isVisible);

        void navigateAuthScreen();

        void navigateToApp();

    }

    interface Presenter {

    }

}
