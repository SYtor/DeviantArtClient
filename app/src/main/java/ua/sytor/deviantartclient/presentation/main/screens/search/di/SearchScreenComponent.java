package ua.sytor.deviantartclient.presentation.main.screens.search.di;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Component;
import ua.sytor.deviantartclient.core.network.di.NetworkModule;
import ua.sytor.deviantartclient.core.navigator.di.NavigatorModule;
import ua.sytor.deviantartclient.presentation.main.screens.search.SearchFragment;

@Component(modules = {SearchScreenModule.class, NavigatorModule.class, NetworkModule.class})
public interface SearchScreenComponent {

    void inject(SearchFragment fragment);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder fragment(Fragment fragment);

        SearchScreenComponent build();

    }

}
