package ua.sytor.deviantartclient.presentation.main.screens.image;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.use_case.contracts.CheckIsUserLoggedUseCase;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class ImageScreenPresenter extends BaseFragmentPresenter<ImageScreenContract.View> implements ImageScreenContract.Presenter {

    private CheckIsUserLoggedUseCase checkIsUserLoggedUseCase;

    @Inject
    public ImageScreenPresenter(
            ImageScreenContract.View view,
            CheckIsUserLoggedUseCase checkIsUserLoggedUseCase
    ) {
        super(view);
        this.checkIsUserLoggedUseCase = checkIsUserLoggedUseCase;
    }

    @Override
    public void onAttach(View view) {
        super.onAttach(view);

        addDisposable(checkIsLogged());

        addDisposable(handleButtonClicks());

    }

    private Disposable checkIsLogged() {
        return checkIsUserLoggedUseCase.isLogged()
                .subscribe((isLogged) -> {
                    if (isLogged) {
                        getView().navigateToApp();
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
