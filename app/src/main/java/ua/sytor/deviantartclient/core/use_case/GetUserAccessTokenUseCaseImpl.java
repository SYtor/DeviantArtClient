package ua.sytor.deviantartclient.core.use_case;

import javax.inject.Inject;

import io.reactivex.Completable;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.network.data.AuthData;
import ua.sytor.deviantartclient.core.use_case.contracts.GetAuthDataUseCase;
import ua.sytor.deviantartclient.core.use_case.contracts.GetUserAccessTokenUseCase;

class GetUserAccessTokenUseCaseImpl implements GetUserAccessTokenUseCase {

    private NetworkContract.Manager networkManager;

    @Inject
    public GetUserAccessTokenUseCaseImpl(NetworkContract.Manager networkManager) {
        this.networkManager = networkManager;
    }

    @Override
    public Completable getAccessToken(String redirectUrl) {
        return null;
    }

}
