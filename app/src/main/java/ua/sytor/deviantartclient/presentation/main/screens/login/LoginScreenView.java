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
    private Subject<Integer> loginDataObservable;

    private View loadingLayout;
    private View loadedLayout;

    @Inject
    public LoginScreenView(NavigatorContract.Navigator navigator) {
        Logger.log(">>");
        this.navigator = navigator;
        loginDataObservable = PublishSubject.create();
    }

    @Override
    public void onAttach(View view) {
        view.findViewById(R.id.login_button).setOnClickListener((v) -> {
            Logger.log("login button clicked");
            loginDataObservable.onNext(v.getId());
        });
        loadingLayout = view.findViewById(R.id.loading_layout);
        loadedLayout = view.findViewById(R.id.loaded_layout);
    }

    @Override
    public void onDetach() {

    }

    @Override
    public Observable<Integer> observeButtonClick() {
        return loginDataObservable;
    }

    @Override
    public void setLoadingVisibility(boolean isVisible) {
        loadingLayout.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void setLoadedVisibility(boolean isVisible) {
        loadedLayout.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
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
