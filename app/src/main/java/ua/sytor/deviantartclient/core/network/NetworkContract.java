package ua.sytor.deviantartclient.core.network;

import ua.sytor.deviantartclient.core.network.data.AuthData;

public interface NetworkContract {

    interface Manager {
        AuthData getAuthData();

        <T> T createApi(Class<T> clazz);
    }

}
