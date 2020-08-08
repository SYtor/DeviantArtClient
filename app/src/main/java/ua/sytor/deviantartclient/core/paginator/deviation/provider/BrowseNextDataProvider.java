package ua.sytor.deviantartclient.core.paginator.deviation.provider;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;
import ua.sytor.deviantartclient.core.network.api.BrowseApi;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;
import ua.sytor.deviantartclient.core.paginator.PaginatorContract;
import ua.sytor.deviantartclient.core.paginator.data.PaginableData;

public class BrowseNextDataProvider implements PaginatorContract.NextDataProvider<Deviation> {

    private BrowseApi browseApi;

    @Inject
    public BrowseNextDataProvider(BrowseApi browseApi) {
        this.browseApi = browseApi;
    }

    @Override
    public void setArguments(Map<String, Object> arguments) {

    }

    @Override
    public Single<PaginableData<Deviation>> provide() {
        return browseApi
                .browseNewest("", "", 0, 20)
                .map(response -> new PaginableData<>(
                        response.hasMore(),
                        response.getNextOffset(),
                        response.getResults()
                ));
    }
}
