package ua.sytor.deviantartclient.core.use_case;

import dagger.Binds;
import dagger.Module;
import ua.sytor.deviantartclient.core.use_case.contracts.CheckIsUserLoggedUseCase;
import ua.sytor.deviantartclient.core.use_case.contracts.GetAuthDataUseCase;
import ua.sytor.deviantartclient.core.use_case.contracts.GetUserAccessTokenUseCase;

@Module
public abstract class UseCaseModule {

    @Binds
    public abstract GetAuthDataUseCase provideGetAuthDataUseCase(GetAuthDataUseCaseImpl impl);

    @Binds
    public abstract GetUserAccessTokenUseCase provideGetUserAccessTokenUseCase(GetUserAccessTokenUseCaseImpl impl);

    @Binds
    public abstract CheckIsUserLoggedUseCase provideCheckIsUserLoggedUseCase(CheckIsUserLoggedUseCaseImpl impl);

}
