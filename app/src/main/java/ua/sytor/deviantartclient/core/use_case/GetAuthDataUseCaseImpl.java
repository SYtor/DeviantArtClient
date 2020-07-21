package ua.sytor.deviantartclient.core.use_case;

import javax.inject.Inject;

import ua.sytor.deviantartclient.core.network.data.AuthInitiationData;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.use_case.contracts.GetAuthDataUseCase;

class GetAuthDataUseCaseImpl implements GetAuthDataUseCase {

    private NetworkContract.NetworkManager networkManager;

    @Inject
    public GetAuthDataUseCaseImpl(NetworkContract.NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    @Override
    public AuthInitiationData getAuthData() {
        return networkManager.getAuthInitiationData();
    }

}
