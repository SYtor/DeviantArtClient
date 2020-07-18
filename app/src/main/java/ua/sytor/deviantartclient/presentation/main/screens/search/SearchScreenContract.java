package ua.sytor.deviantartclient.presentation.main.screens.search;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.presentation.base.FragmentView;

public interface SearchScreenContract {

    interface View extends FragmentView {
        Observable<Integer> onListScrolledToEndObservable();

        void submitList();
    }

    interface Presenter {

    }

}
