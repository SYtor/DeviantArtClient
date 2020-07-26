package ua.sytor.deviantartclient.presentation.main.screens.image;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.presentation.base.FragmentView;

public interface ImageScreenContract {

    interface View extends FragmentView {

        Observable<Integer> observeButtonClick();

        void navigateAuthScreen();

        void navigateToApp();

    }

    interface Presenter {

    }

}
