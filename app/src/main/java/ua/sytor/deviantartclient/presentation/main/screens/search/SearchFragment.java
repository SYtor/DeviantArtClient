package ua.sytor.deviantartclient.presentation.main.screens.search;

import android.content.Context;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.presentation.base.BaseFragment;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.search.di.DaggerSearchScreenComponent;

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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        DaggerSearchScreenComponent.builder()
                .fragment(this)
                .build()
                .inject(this);
    }
}
