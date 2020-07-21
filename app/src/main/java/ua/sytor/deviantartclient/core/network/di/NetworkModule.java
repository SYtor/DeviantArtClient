package ua.sytor.deviantartclient.core.network.di;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.network.NetworkManager;
import ua.sytor.deviantartclient.core.network.SessionManager;
import ua.sytor.deviantartclient.core.network.api.AuthApi;
import ua.sytor.deviantartclient.core.network.api.BrowseApi;
import ua.sytor.deviantartclient.core.storage.StorageContract;

@Module
public class NetworkModule {

    @Provides
    NetworkContract.NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }

    @Provides
    NetworkContract.SessionManager provideSessionManager(
            AuthApi authApi,
            StorageContract.KeyValueStorage storage
    ) {
        return new SessionManager(authApi, storage);
    }

    @Provides
    AuthApi provideAuthApi(NetworkContract.NetworkManager networkManager) {
        return networkManager.createApi(AuthApi.class);
    }

    @Provides
    BrowseApi provideBrowseApi(NetworkContract.NetworkManager networkManager) {
        return networkManager.createApi(BrowseApi.class);
    }

}
