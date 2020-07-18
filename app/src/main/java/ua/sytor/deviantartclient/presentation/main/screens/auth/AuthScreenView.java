package ua.sytor.deviantartclient.presentation.main.screens.auth;

import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.widget.Toolbar;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;

public class AuthScreenView implements AuthScreenContract.View {

    private NavigatorContract.Navigator navigator;
    private Subject<AuthScreenContract.AuthData> authSubject;

    private WebView webView;

    @Inject
    public AuthScreenView(NavigatorContract.Navigator navigator) {
        Logger.log("LoginScreenView");
        this.navigator = navigator;
        authSubject = PublishSubject.create();
    }

    @Override
    public void onAttach(View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        navigator.setupToolbar(toolbar);

        webView = view.findViewById(R.id.webView);

    }

    @Override
    public void onDetach() {

    }

    @Override
    public Observable<AuthScreenContract.AuthData> observeAuthState() {
        return authSubject;
    }

    @Override
    public void loadAuthPage(String url) {
        webView.loadUrl(url);
    }

    @Override
    public void navigateToApp() {
        navigator.navigate(R.id.action_auth_fragment_to_search_fragment);
    }

}
