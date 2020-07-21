package ua.sytor.deviantartclient.core.storage.di;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import ua.sytor.deviantartclient.core.storage.PersistentKeyValueStorage;
import ua.sytor.deviantartclient.core.storage.StorageContract;

@Module
public class StorageModule {

    @Provides
    StorageContract.KeyValueStorage providePersistentKeyValueStorage(Application application) {
        return new PersistentKeyValueStorage(
                new Gson(),
                application.getSharedPreferences("data", Context.MODE_PRIVATE)
        );
    }

}
