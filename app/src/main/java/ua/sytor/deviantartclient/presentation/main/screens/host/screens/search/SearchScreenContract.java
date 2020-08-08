package ua.sytor.deviantartclient.presentation.main.screens.host.screens.search;

import java.util.List;

import io.reactivex.Observable;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.utils.Complete;
import ua.sytor.deviantartclient.presentation.base.FragmentView;

public interface SearchScreenContract {

    interface View extends FragmentView {

        Observable<Complete> subscribeOnEndReached();
        Observable<Complete> subscribeOnRetryClick();

        void addDeviations(List<Deviation> list);

        void showAuthError();

        void showRequestError();

    }

    interface Presenter {

    }

}
