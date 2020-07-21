package ua.sytor.deviantartclient.presentation.main.screens.auth;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.network.data.AuthInitiationData;
import ua.sytor.deviantartclient.core.use_case.contracts.GetAuthDataUseCase;
import ua.sytor.deviantartclient.core.use_case.contracts.GetUserAccessTokenUseCase;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.auth.data.AuthRedirectData;

public class AuthScreenPresenter extends BaseFragmentPresenter<AuthScreenContract.View> implements AuthScreenContract.Presenter {

    private GetAuthDataUseCase getAuthDataUseCase;
    private GetUserAccessTokenUseCase getUserAccessTokenUseCase;

    private AuthRedirectData latestAuthRedirectData;

    @Inject
    public AuthScreenPresenter(
            AuthScreenContract.View view,
            GetAuthDataUseCase getAuthDataUseCase,
            GetUserAccessTokenUseCase getUserAccessTokenUseCase
    ) {
        super(view);
        this.getAuthDataUseCase = getAuthDataUseCase;
        this.getUserAccessTokenUseCase = getUserAccessTokenUseCase;
        Logger.log("LoginScreenPresenter");
    }

    @Override
    public void onAttach(View view) {
        super.onAttach(view);

        AuthInitiationData authData = getAuthDataUseCase.getAuthData();
        String authUrl = authData.getAuthUrl();
        String redirectUrl = authData.getRedirectUrl();

        getView().loadAuthPage(authUrl, redirectUrl);

        Disposable d = getView().observeAuthState()
                .observeOn(Schedulers.io())
                .switchMapCompletable(authRedirectData -> {
                    latestAuthRedirectData = authRedirectData;
                    return getUserAccessTokenUseCase.getAccessToken(authRedirectData.getRedirectUrl());
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> getView().navigateToApp());
        addDisposable(d);

    }

}
