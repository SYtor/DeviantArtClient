package ua.sytor.deviantartclient.presentation.main.screens.search;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.network.api.BrowseApi;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class SearchScreenPresenter extends BaseFragmentPresenter<SearchScreenContract.View> implements SearchScreenContract.Presenter {

    private BrowseApi browseApi;

    @Inject
    public SearchScreenPresenter(
            SearchScreenContract.View view,
            BrowseApi browseApi
    ) {
        super(view);
        this.browseApi = browseApi;
    }

    @Override
    public void onAttach(View view) {
        super.onAttach(view);

        Disposable d = browseApi.browseNewest("", "", 0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    getView().submitList(response.getResults());
                    Logger.log("Got response " + response.toString());
                });
        addDisposable(d);

    }
}
