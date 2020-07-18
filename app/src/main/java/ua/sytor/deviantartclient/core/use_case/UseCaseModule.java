package ua.sytor.deviantartclient.core.use_case;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.use_case.contracts.GetAuthDataUseCase;
import ua.sytor.deviantartclient.core.use_case.contracts.GetUserAccessTokenUseCase;

@Module
public class UseCaseModule {

    @Provides
    public GetAuthDataUseCase provideGetAuthUrlUseCase(NetworkContract.Manager networkManager) {
        return new GetAuthDataUseCaseImpl(networkManager);
    }

    @Provides
    public GetUserAccessTokenUseCase provideGetUserAccessTokenUseCase(NetworkContract.Manager networkManager) {
        return new GetUserAccessTokenUseCaseImpl(networkManager);
    }

}
