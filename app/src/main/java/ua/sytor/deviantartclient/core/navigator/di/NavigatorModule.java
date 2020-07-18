package ua.sytor.deviantartclient.core.navigator.di;

import androidx.fragment.app.Fragment;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.navigator.Navigator;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;

@Module
public class NavigatorModule {

    @Provides
    public NavigatorContract.Navigator provide(Fragment fragment) {
        return new Navigator(fragment);
    }

}
