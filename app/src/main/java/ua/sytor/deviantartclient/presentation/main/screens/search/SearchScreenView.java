package ua.sytor.deviantartclient.presentation.main.screens.search;

import android.view.View;

import javax.inject.Inject;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;

public class SearchScreenView implements SearchScreenContract.View {

    private NavigatorContract.Navigator navigator;

    @Inject
    public SearchScreenView(NavigatorContract.Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void onAttach(View view) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void submitList() {

    }

    @Override
    public Observable<Integer> onListScrolledToEndObservable() {
        return null;
    }
}
