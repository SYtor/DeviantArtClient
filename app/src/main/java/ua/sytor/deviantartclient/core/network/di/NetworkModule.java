package ua.sytor.deviantartclient.core.network.di;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.network.NetworkManager;
import ua.sytor.deviantartclient.core.network.api.BrowseApi;

@Module
public class NetworkModule {

    @Provides
    NetworkContract.Manager provideNetworkManager() {
        return new NetworkManager();
    }

    @Provides
    BrowseApi provideBrowseApi(NetworkContract.Manager networkManager) {
        return networkManager.createApi(BrowseApi.class);
    }

}
