package ua.sytor.deviantartclient.presentation.main.screens.image;

import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.utils.DiUtils;
import ua.sytor.deviantartclient.presentation.base.BaseFragment;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class ImageFragment extends BaseFragment<ImageScreenContract.View, BaseFragmentPresenter<ImageScreenContract.View>> {

    @Inject
    ImageScreenContract.View view;

    @Inject
    BaseFragmentPresenter<ImageScreenContract.View> presenter;

    @NonNull
    @Override
    protected Integer getLayoutResId() {
        return R.layout.fragment_login;
    }

    @Override
    public BaseFragmentPresenter<ImageScreenContract.View> getPresenter() {
        return presenter;
    }


    @Override
    protected void setupDI(Context context) {
        DiUtils.getAppComponent(context)
                .imageScreenBuilder()
                .fragment(this)
                .build()
                .inject(this);
    }

}
