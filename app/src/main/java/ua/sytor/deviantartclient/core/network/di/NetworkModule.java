package ua.sytor.deviantartclient.core.network.di;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.network.NetworkManager;
import ua.sytor.deviantartclient.core.network.SessionManager;
import ua.sytor.deviantartclient.core.network.api.AuthApi;
import ua.sytor.deviantartclient.core.network.api.BrowseApi;
import ua.sytor.deviantartclient.core.network.interceptor.AuthInterceptor;
import ua.sytor.deviantartclient.core.network.storage.NetworkStorage;

@Module
public abstract class NetworkModule {

    @Binds
    abstract NetworkContract.NetworkStorage provideNetworkStorage(NetworkStorage networkStorage);

    @Binds
    abstract Interceptor provideAuthInterceptor(AuthInterceptor authInterceptor);

    @Binds
    abstract NetworkContract.NetworkManager provideNetworkManager(NetworkManager networkManager);

    @Binds
    abstract NetworkContract.SessionManager provideSessionManager(SessionManager sessionManager);

    @Provides
    static AuthApi provideAuthApi(NetworkContract.NetworkManager networkManager) {
        return networkManager.createApi(AuthApi.class);
    }

    @Provides
    static BrowseApi provideBrowseApi(NetworkContract.NetworkManager networkManager) {
        return networkManager.createApi(BrowseApi.class);
    }

}
