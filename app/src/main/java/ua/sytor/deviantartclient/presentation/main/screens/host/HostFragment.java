package ua.sytor.deviantartclient.presentation.main.screens.host;

import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.utils.DiUtils;
import ua.sytor.deviantartclient.presentation.base.BaseFragment;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class HostFragment extends BaseFragment<HostScreenContract.View, BaseFragmentPresenter<HostScreenContract.View>> {

    @Inject
    HostScreenContract.View view;

    @Inject
    BaseFragmentPresenter<HostScreenContract.View> presenter;

    @NonNull
    @Override
    protected Integer getLayoutResId() {
        return R.layout.fragment_host;
    }

    @Override
    public BaseFragmentPresenter<HostScreenContract.View> getPresenter() {
        return presenter;
    }

    @Override
    protected void setupDI(Context context) {
        DiUtils.getAppComponent(context)
                .hostScreenBuilder()
                .fragment(this)
                .build()
                .inject(this);
    }

}
