package ua.sytor.deviantartclient.presentation.main.screens.search;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
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
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        navigator.setupToolbar(toolbar);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void submitList(List<Deviation> list) {
        adapter.setList(list);
    }

    @Override
    public Observable<Integer> onListScrolledToEndObservable() {
        return null;
    }
}
