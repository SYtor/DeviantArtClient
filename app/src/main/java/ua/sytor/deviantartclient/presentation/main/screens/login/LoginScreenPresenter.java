package ua.sytor.deviantartclient.presentation.main.screens.login;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class LoginScreenPresenter extends BaseFragmentPresenter<LoginScreenContract.View> implements LoginScreenContract.Presenter {

    @Inject
    public LoginScreenPresenter(LoginScreenContract.View view) {
        super(view);
        Logger.log("LoginScreenPresenter");
    }

    @Override
    public void onAttach(View view) {
        super.onAttach(view);

        Disposable d = getView().observeSelectedOption()
                .observeOn(Schedulers.io())
                .forEach((loginOption) -> {
                    switch (loginOption) {
                        case AUTH:
                            getView().navigateAuthScreen();
                            break;
                        case SKIP_AUTH:
                            getView().navigateToApp();
                            break;
                    }
                });
        addDisposable(d);

    }
}
