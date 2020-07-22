package ua.sytor.deviantartclient.core.use_case;

import javax.inject.Inject;

import ua.sytor.deviantartclient.core.network.data.AuthInitiationData;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.use_case.contracts.GetAuthDataUseCase;

class GetAuthDataUseCaseImpl implements GetAuthDataUseCase {

    private NetworkContract.SessionManager sessionManager;

    @Inject
    public GetAuthDataUseCaseImpl(NetworkContract.SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public AuthInitiationData getAuthData() {
        return sessionManager.getAuthInitiationData();
    }

}
