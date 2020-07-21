package ua.sytor.deviantartclient.core.use_case;

import javax.inject.Inject;

import io.reactivex.Completable;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.use_case.contracts.GetUserAccessTokenUseCase;

class GetUserAccessTokenUseCaseImpl implements GetUserAccessTokenUseCase {

    private NetworkContract.SessionManager sessionManager;

    @Inject
    public GetUserAccessTokenUseCaseImpl(NetworkContract.SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public Completable getAccessToken(String redirectUrl) {
        return sessionManager.logIn(redirectUrl);
    }

}
