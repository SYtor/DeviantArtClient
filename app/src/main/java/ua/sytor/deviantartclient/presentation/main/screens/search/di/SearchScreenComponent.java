package ua.sytor.deviantartclient.presentation.main.screens.search.di;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Subcomponent;
import ua.sytor.deviantartclient.core.navigator.di.NavigatorModule;
import ua.sytor.deviantartclient.presentation.main.screens.search.SearchFragment;

@Subcomponent(modules = {SearchScreenModule.class, NavigatorModule.class})
public interface SearchScreenComponent {

    void inject(SearchFragment fragment);

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        Builder fragment(Fragment fragment);

        SearchScreenComponent build();

    }

}
