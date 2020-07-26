package ua.sytor.deviantartclient.presentation.main.screens.host.screens.search;

import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.utils.DiUtils;
import ua.sytor.deviantartclient.presentation.base.BaseFragment;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class SearchFragment extends BaseFragment<SearchScreenContract.View, BaseFragmentPresenter<SearchScreenContract.View>> {

    @Inject
    BaseFragmentPresenter<SearchScreenContract.View> presenter;

    @NonNull
    @Override
    protected Integer getLayoutResId() {
        return R.layout.fragment_search;
    }

    @Override
    protected BaseFragmentPresenter<SearchScreenContract.View> getPresenter() {
        return presenter;
    }

    @Override
    protected void setupDI(Context context) {
        DiUtils.getAppComponent(context)
                .searchScreenBuilder()
                .fragment(this)
                .build()
                .inject(this);
    }

}
