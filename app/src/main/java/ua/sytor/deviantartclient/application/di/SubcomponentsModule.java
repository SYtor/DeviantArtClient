package ua.sytor.deviantartclient.application.di;

import dagger.Module;
import ua.sytor.deviantartclient.presentation.main.screens.auth.di.AuthScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.login.di.LoginScreenComponent;
import ua.sytor.deviantartclient.presentation.main.screens.host.screens.search.di.SearchScreenComponent;

@Module(subcomponents = {
        LoginScreenComponent.class,
        AuthScreenComponent.class,
        SearchScreenComponent.class
})
class SubcomponentsModule {
}
