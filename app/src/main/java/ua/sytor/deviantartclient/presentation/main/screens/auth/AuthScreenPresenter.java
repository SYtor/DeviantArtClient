package ua.sytor.deviantartclient.presentation.main.screens.auth;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class AuthScreenPresenter extends BaseFragmentPresenter<AuthScreenContract.View> implements AuthScreenContract.Presenter {

    @Inject
    public AuthScreenPresenter(AuthScreenContract.View view) {
        super(view);
        Logger.log("LoginScreenPresenter");
    }

    @Override
    public void onAttach(View view) {
        super.onAttach(view);

        Disposable d = getView().observeAuthState()
                .observeOn(Schedulers.io())
                .forEach((loginData) -> {
                    getView().navigateToApp();
                });
        addDisposable(d);

    }
}
