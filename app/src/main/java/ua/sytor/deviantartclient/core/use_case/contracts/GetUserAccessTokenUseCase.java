package ua.sytor.deviantartclient.core.use_case.contracts;

import io.reactivex.Completable;

public interface GetUserAccessTokenUseCase {
    Completable getAccessToken(String redirectUrl);
}
