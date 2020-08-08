package ua.sytor.deviantartclient.core.paginator.di;

import dagger.Binds;
import dagger.Module;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.paginator.PaginatorContract;
import ua.sytor.deviantartclient.core.paginator.deviation.DeviationPaginator;
import ua.sytor.deviantartclient.core.paginator.deviation.DeviationValidator;
import ua.sytor.deviantartclient.core.paginator.deviation.provider.BrowseNextDataProvider;

@Module
public abstract class PaginatorModule {

    @Binds
    abstract PaginatorContract.Paginator<Deviation> deviationPaginator(DeviationPaginator paginator);

    @Binds
    abstract PaginatorContract.Validator<Deviation> deviationValidator(DeviationValidator validator);

    @Binds
    abstract PaginatorContract.NextDataProvider<Deviation> deviationNextDataProvider(BrowseNextDataProvider provider);

}
