package ua.sytor.deviantartclient.presentation.main.screens.host.di;

import dagger.Binds;
import dagger.Module;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.host.HostScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.host.HostScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.host.HostScreenView;

@Module
public abstract class HostScreenModule {

    @Binds
    public abstract HostScreenContract.View provideView(HostScreenView view);

    @Binds
    public abstract BaseFragmentPresenter<HostScreenContract.View> providePresenter(
            HostScreenPresenter presenter
    );

}
