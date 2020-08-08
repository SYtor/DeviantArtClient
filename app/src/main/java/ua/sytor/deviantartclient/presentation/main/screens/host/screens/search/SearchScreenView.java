package ua.sytor.deviantartclient.presentation.main.screens.host.screens.search;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.utils.Complete;
import ua.sytor.deviantartclient.core.utils.NotSwipableSnackbarBehavior;
import ua.sytor.deviantartclient.core.utils.RecyclerViewUtils;
import ua.sytor.deviantartclient.presentation.base.BaseImageAdapter;

public class SearchScreenView implements SearchScreenContract.View {

    private NavigatorContract.Navigator navigator;

    private BaseImageAdapter adapter = new BaseImageAdapter();

    private Subject<Complete> onRetryClickSubject = PublishSubject.create();

    private Snackbar errorSnackbar;

    @Inject
    public SearchScreenView(NavigatorContract.Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void onAttach(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        RecyclerViewUtils.addGridRowSpacing(recyclerView, R.dimen.recycler_row_item_spacing);

        errorSnackbar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE)
                .setBehavior(new NotSwipableSnackbarBehavior())
                .setAction("Retry", (v) -> {
                    errorSnackbar.dismiss();
                    onRetryClickSubject.onNext(Complete.getInstance());
                });
    }

    @Override
    public void onDetach() {

    }

    @Override
    public Observable<Complete> subscribeOnEndReached() {
        return Observable.just(Complete.getInstance());
    }

    @Override
    public Observable<Complete> subscribeOnRetryClick() {
        return onRetryClickSubject;
    }

    @Override
    public void addDeviations(List<Deviation> list) {
        adapter.addList(list);
    }

    @Override
    public void showAuthError() {

    }

    @Override
    public void showRequestError() {
        errorSnackbar.show();
    }
}
