package ua.sytor.deviantartclient.presentation.main.screens.host.screens.search.di;

import dagger.Binds;
import dagger.Module;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.host.screens.search.SearchScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.host.screens.search.SearchScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.host.screens.search.SearchScreenView;

@Module
public abstract class SearchScreenModule {

    @Binds
    public abstract SearchScreenContract.View provideView(SearchScreenView impl);

    @Binds
    public abstract BaseFragmentPresenter<SearchScreenContract.View> providePresenter(SearchScreenPresenter impl);

}
