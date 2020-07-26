package ua.sytor.deviantartclient.core.use_case.contracts;

import io.reactivex.Single;

public interface CheckIsUserLoggedUseCase {
    Single<Boolean> isLogged();
}
