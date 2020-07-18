package ua.sytor.deviantartclient.presentation.main.screens.login;

import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.presentation.base.BaseFragment;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.login.di.DaggerLoginScreenComponent;

public class LoginFragment extends BaseFragment<LoginScreenContract.View, BaseFragmentPresenter<LoginScreenContract.View>> {

    @Inject
    LoginScreenContract.View view;

    @Inject
    BaseFragmentPresenter<LoginScreenContract.View> presenter;

    @NonNull
    @Override
    protected Integer getLayoutResId() {
        return R.layout.fragment_login;
    }

    @Override
    public BaseFragmentPresenter<LoginScreenContract.View> getPresenter() {
        return presenter;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        DaggerLoginScreenComponent.builder()
                .fragment(this)
                .build()
                .inject(this);
    }

}
