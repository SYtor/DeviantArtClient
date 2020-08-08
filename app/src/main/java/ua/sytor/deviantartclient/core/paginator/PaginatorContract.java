package ua.sytor.deviantartclient.core.paginator;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Single;
import ua.sytor.deviantartclient.core.paginator.data.PaginableData;
import ua.sytor.deviantartclient.core.utils.Complete;

public interface PaginatorContract {

    interface Paginator<T> {

        Single<List<T>> getNext();

        Observable<Complete> subscribeOnListEndReached();

    }

    interface Validator<T> {
        boolean isValid(T value);
    }

    interface NextDataProvider<T> {

        void setArguments(Map<String, Object> arguments);

        Single<PaginableData<T>> provide();

    }

}
