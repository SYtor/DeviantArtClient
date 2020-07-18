package ua.sytor.deviantartclient.presentation.main.screens.auth;

import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.presentation.base.BaseFragment;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.auth.di.DaggerAuthScreenComponent;

public class AuthFragment extends BaseFragment<AuthScreenContract.View, BaseFragmentPresenter<AuthScreenContract.View>> {

    @Inject
    AuthScreenContract.View view;

    @Inject
    BaseFragmentPresenter<AuthScreenContract.View> presenter;

    @NonNull
    @Override
    protected Integer getLayoutResId() {
        return R.layout.fragment_auth;
    }

    @Override
    public BaseFragmentPresenter<AuthScreenContract.View> getPresenter() {
        return presenter;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        DaggerAuthScreenComponent.builder()
                .fragment(this)
                .build()
                .inject(this);
    }

}
