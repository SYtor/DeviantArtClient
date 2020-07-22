package ua.sytor.deviantartclient.presentation.main.screens.search;

import java.util.List;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.presentation.base.FragmentView;

public interface SearchScreenContract {

    interface View extends FragmentView {
        Observable<Integer> onListScrolledToEndObservable();

        void submitList(List<Deviation> list);
    }

    interface Presenter {

    }

}
