package ua.sytor.deviantartclient.presentation.main.screens.image;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;

public class ImageScreenView implements ImageScreenContract.View {

    private NavigatorContract.Navigator navigator;
    private Subject<Integer> loginDataObservable;

    @Inject
    public ImageScreenView(NavigatorContract.Navigator navigator) {
        Logger.log("LoginScreenView");
        this.navigator = navigator;
        loginDataObservable = PublishSubject.create();
    }

    @Override
    public void onAttach(View view) {
        view.findViewById(R.id.login_button).setOnClickListener((v) -> {
            Logger.log("login button clicked");
            loginDataObservable.onNext(v.getId());
        });
    }

    @Override
    public void onDetach() {

    }

    @Override
    public Observable<Integer> observeButtonClick() {
        return loginDataObservable;
    }

    @Override
    public void navigateAuthScreen() {
        navigator.navigate(R.id.action_login_fragment_to_auth_fragment);
    }

    @Override
    public void navigateToApp() {
        navigator.navigate(R.id.action_login_fragment_to_host_fragment);
    }

}
