package ua.sytor.deviantartclient.core.use_case;

import javax.inject.Inject;

import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.use_case.contracts.CheckIsUserLoggedUseCase;

class CheckIsUserLoggedUseCaseImpl implements CheckIsUserLoggedUseCase {

    private NetworkContract.SessionManager sessionManager;

    @Inject
    public CheckIsUserLoggedUseCaseImpl(NetworkContract.SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public Boolean isLogged() {
        return sessionManager.isLogged();
    }

}
