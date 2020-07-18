package ua.sytor.deviantartclient.core.use_case.contracts;

import ua.sytor.deviantartclient.core.network.data.AuthData;

public interface GetAuthDataUseCase {
    AuthData getAuthData();
}
