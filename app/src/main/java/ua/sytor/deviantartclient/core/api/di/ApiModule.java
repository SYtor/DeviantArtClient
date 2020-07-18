package ua.sytor.deviantartclient.core.api.di;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.api.BrowseApi;

@Module
public class ApiModule {

    @Provides
    BrowseApi provideBrowseApi() {
        return BrowseApi.create();
    }

}
