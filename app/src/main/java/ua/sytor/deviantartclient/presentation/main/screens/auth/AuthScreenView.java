package ua.sytor.deviantartclient.presentation.main.screens.auth;

import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.widget.Toolbar;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;
import ua.sytor.deviantartclient.presentation.main.screens.auth.data.AuthRedirectData;

public class AuthScreenView implements AuthScreenContract.View {

    private NavigatorContract.Navigator navigator;
    private Subject<AuthRedirectData> authSubject;

    private WebView webView;
    private CustomWebClient webClient;

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

        webView.getSettings().setJavaScriptEnabled(true);

        webClient = new CustomWebClient();
        webView.setWebViewClient(webClient);

    }

    @Override
    public void onDetach() {

    }

    @Override
    public Observable<AuthRedirectData> observeAuthState() {
        return authSubject;
    }

    @Override
    public void loadAuthPage(String url, String redirectUrl) {
        Logger.log("opening url: " + url);
        webClient.setRedirectUrl(redirectUrl);
        webView.loadUrl(url);
    }

    @Override
    public void navigateToApp() {
        navigator.navigateBack();
    }

    class CustomWebClient extends WebViewClient {

        private String redirectUrl;

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Logger.log("shouldOverrideUrlLoading url:" + request.getUrl());
            if (redirectUrl != null && request.getUrl().toString().startsWith(redirectUrl)) {
                Logger.log("overriding");
                AuthRedirectData data = new AuthRedirectData(request.getUrl().toString());
                authSubject.onNext(data);
                return true;
            }
            return false;
        }

    }

}
