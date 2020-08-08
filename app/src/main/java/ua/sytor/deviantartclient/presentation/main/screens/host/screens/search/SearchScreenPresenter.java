package ua.sytor.deviantartclient.presentation.main.screens.host.screens.search;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.network.errors.AuthFailedException;
import ua.sytor.deviantartclient.core.paginator.PaginatorContract;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class SearchScreenPresenter extends BaseFragmentPresenter<SearchScreenContract.View> implements SearchScreenContract.Presenter {

    private PaginatorContract.Paginator<Deviation> deviationPaginator;

    private boolean isErrorOccurred = false;

    @Inject
    public SearchScreenPresenter(SearchScreenContract.View view, PaginatorContract.Paginator<Deviation> deviationPaginator) {
        super(view);
        this.deviationPaginator = deviationPaginator;
    }

    @Override
    public void onAttach(View view) {
        super.onAttach(view);
        addDisposable(requestMoreDataHandler());
        addDisposable(retryHandler());
    }

    private Disposable requestMoreDataHandler() {
        return loadMore(getView().subscribeOnEndReached().filter((a) -> !isErrorOccurred));

    }

    private Disposable retryHandler() {
        return loadMore(getView().subscribeOnRetryClick());
    }

    private <T> Disposable loadMore(Observable<T> chainStartingObservable) {
        return chainStartingObservable
                .switchMap((a) -> {
                    Logger.log("starting loading");
                    int z = 1/0;
                    return deviationPaginator.getNext().toObservable();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        deviations -> {
                            getView().addDeviations(deviations);
                            Logger.log("Got response " + deviations);
                        },
                        throwable -> {
                            Logger.log("Got error %s", throwable.toString());
                            if (throwable instanceof AuthFailedException) {
                                getView().showAuthError();
                            } else {
                                getView().showRequestError();
                            }
                        }
                );
    }


}
