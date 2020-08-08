package ua.sytor.deviantartclient.presentation.main.screens.login;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.use_case.contracts.CheckIsUserLoggedUseCase;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class LoginScreenPresenter extends BaseFragmentPresenter<LoginScreenContract.View> implements LoginScreenContract.Presenter {

    private CheckIsUserLoggedUseCase checkIsUserLoggedUseCase;

    @Inject
    public LoginScreenPresenter(
            LoginScreenContract.View view,
            CheckIsUserLoggedUseCase checkIsUserLoggedUseCase
    ) {
        super(view);
        this.checkIsUserLoggedUseCase = checkIsUserLoggedUseCase;
    }

    @Override
    public void onAttach(View view) {
        Logger.log(">>");
        super.onAttach(view);

        addDisposable(checkIsLogged());

        addDisposable(handleButtonClicks());

    }

    private Disposable checkIsLogged() {
        return checkIsUserLoggedUseCase.isLogged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((disposable) -> {
                    getView().setLoadingVisibility(true);
                    getView().setLoadedVisibility(false);
                })
                .subscribe((isLogged) -> {
                    Logger.log("isLogged = " + isLogged);
                    if (isLogged) {
                        getView().navigateToApp();
                    } else {
                        getView().setLoadingVisibility(false);
                        getView().setLoadedVisibility(true);
                    }
                });
    }

    private Disposable handleButtonClicks() {
        return getView().observeButtonClick()
                .subscribe((buttonId) -> {
                    switch (buttonId) {
                        case R.id.login_button:
                            getView().navigateAuthScreen();
                            break;
                        default:
                            throw new IllegalStateException("Unhandled Button");
                    }
                });
    }

}
