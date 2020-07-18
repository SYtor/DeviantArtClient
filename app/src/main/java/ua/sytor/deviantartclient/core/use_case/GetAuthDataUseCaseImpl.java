package ua.sytor.deviantartclient.core.use_case;

import javax.inject.Inject;

import ua.sytor.deviantartclient.core.network.data.AuthData;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.use_case.contracts.GetAuthDataUseCase;

class GetAuthDataUseCaseImpl implements GetAuthDataUseCase {

    private NetworkContract.Manager networkManager;

    @Inject
    public GetAuthDataUseCaseImpl(NetworkContract.Manager networkManager) {
        this.networkManager = networkManager;
    }

    @Override
    public AuthData getAuthData() {
        return networkManager.getAuthData();
    }

}
