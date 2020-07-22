package ua.sytor.deviantartclient.presentation.main.screens.login;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
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
        if (checkIsUserLoggedUseCase.isLogged()) {
            getView().navigateToApp();
        }

        super.onAttach(view);

        Disposable d = getView().observeSelectedOption()
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
