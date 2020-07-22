package ua.sytor.deviantartclient.core.network.storage;

import javax.inject.Inject;

import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.storage.StorageContract;

public class NetworkStorage implements NetworkContract.NetworkStorage {

    private static final String USER_TOKEN_KEY = "user_token";

    private StorageContract.KeyValueStorage storage;

    private String cachedToken;

    @Inject
    public NetworkStorage(StorageContract.KeyValueStorage storage) {
        this.storage = storage;
        cachedToken = storage.get(USER_TOKEN_KEY, String.class);
    }

    @Override
    public void saveAccessToken(String token) {
        cachedToken = token;
        storage.save(USER_TOKEN_KEY, token, String.class);
    }

    @Override
    public String getAccessToken() {
        return cachedToken;
    }
}
