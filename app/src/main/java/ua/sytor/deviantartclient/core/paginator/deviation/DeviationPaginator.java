package ua.sytor.deviantartclient.core.paginator.deviation;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.paginator.PaginatorContract;
import ua.sytor.deviantartclient.core.utils.Complete;

public class DeviationPaginator implements PaginatorContract.Paginator<Deviation> {

    private PaginatorContract.NextDataProvider<Deviation> nextDataProvider;
    private PaginatorContract.Validator<Deviation> validator;

    private Subject<Complete> onEndReachedSubject;

    @Inject
    public DeviationPaginator(
            PaginatorContract.NextDataProvider<Deviation> nextDataProvider,
            PaginatorContract.Validator<Deviation> validator
    ) {
        this.nextDataProvider = nextDataProvider;
        this.validator = validator;
        onEndReachedSubject = BehaviorSubject.create();
    }

    @Override
    public Single<List<Deviation>> getNext() {
        Logger.log(">>");
        return nextDataProvider.provide()
                .map(paginableData -> {
                    if (!paginableData.hasNext()) {
                        onEndReachedSubject.onNext(Complete.getInstance());
                    }
                    Logger.log("get data, filtering");
                    return paginableData.getData()
                            .stream()
                            .filter(validator::isValid)
                            .collect(Collectors.toList());
                });
    }

    @Override
    public Observable<Complete> subscribeOnListEndReached() {
        return onEndReachedSubject;
    }

}
