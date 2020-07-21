package ua.sytor.deviantartclient.core.use_case.contracts;

import ua.sytor.deviantartclient.core.network.data.AuthInitiationData;

public interface GetAuthDataUseCase {
    AuthInitiationData getAuthData();
}
