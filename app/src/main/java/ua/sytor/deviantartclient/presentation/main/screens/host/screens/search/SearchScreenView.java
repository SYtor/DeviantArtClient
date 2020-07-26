package ua.sytor.deviantartclient.presentation.main.screens.host.screens.search;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.utils.RecyclerViewUtils;
import ua.sytor.deviantartclient.presentation.base.BaseImageAdapter;

public class SearchScreenView implements SearchScreenContract.View {

    private NavigatorContract.Navigator navigator;

    private BaseImageAdapter adapter = new BaseImageAdapter();

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
    }

    @Override
    public void onDetach() {

    }

    @Override
    public Observable<Integer> onListScrolledToEndObservable() {
        return null;
    }

    @Override
    public void submitList(List<Deviation> list) {
        adapter.setList(list);
    }

    @Override
    public void showAuthError() {

    }

}
