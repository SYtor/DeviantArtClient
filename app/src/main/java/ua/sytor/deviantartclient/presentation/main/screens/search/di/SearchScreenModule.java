package ua.sytor.deviantartclient.presentation.main.screens.search.di;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.api.BrowseApi;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;
import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.search.SearchScreenContract;
import ua.sytor.deviantartclient.presentation.main.screens.search.SearchScreenPresenter;
import ua.sytor.deviantartclient.presentation.main.screens.search.SearchScreenView;

@Module
public class SearchScreenModule {

    @Provides
    public SearchScreenContract.View provideView(NavigatorContract.Navigator navigator) {
        return new SearchScreenView(navigator);
    }

    @Provides
    public BaseFragmentPresenter<SearchScreenContract.View> providePresenter(
            SearchScreenContract.View view,
            BrowseApi browseApi
    ) {
        return new SearchScreenPresenter(view, browseApi);
    }

}
