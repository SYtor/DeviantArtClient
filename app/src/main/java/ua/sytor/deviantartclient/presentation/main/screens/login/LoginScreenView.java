package ua.sytor.deviantartclient.presentation.main.screens.login;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;

public class LoginScreenView implements LoginScreenContract.View {

    private NavigatorContract.Navigator navigator;
    private Subject<LoginScreenContract.LoginOption> loginDataObservable;

    @Inject
    public LoginScreenView(NavigatorContract.Navigator navigator) {
        Logger.log("LoginScreenView");
        this.navigator = navigator;
        loginDataObservable = PublishSubject.create();
    }

    @Override
    public void onAttach(View view) {
        view.findViewById(R.id.login_button).setOnClickListener((v) -> {
            Logger.log("login button clicked");
            loginDataObservable.onNext(LoginScreenContract.LoginOption.AUTH);
        });
        view.findViewById(R.id.no_login_button).setOnClickListener((v) -> {
            Logger.log("login button clicked");
            loginDataObservable.onNext(LoginScreenContract.LoginOption.SKIP_AUTH);
        });
    }

    @Override
    public void onDetach() {

    }

    @Override
    public Observable<LoginScreenContract.LoginOption> onButtonSelected() {
        return loginDataObservable;
    }

    @Override
    public void navigateAuthScreen() {
        navigator.navigate(R.id.action_login_fragment_to_auth_fragment);
    }

    @Override
    public void navigateToApp() {
        navigator.navigate(R.id.action_login_fragment_to_search_fragment);
    }

}
