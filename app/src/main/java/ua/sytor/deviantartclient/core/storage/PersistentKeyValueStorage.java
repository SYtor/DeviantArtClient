package ua.sytor.deviantartclient.core.storage;

import android.content.SharedPreferences;

import com.google.gson.Gson;

public class PersistentKeyValueStorage implements StorageContract.KeyValueStorage {

    private Gson gson;
    private SharedPreferences sharedPreferences;

    public PersistentKeyValueStorage(Gson gson, SharedPreferences sharedPreferences) {
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public <T> void save(String key, T value, Class<T> clazz) {
        String json = gson.toJson(value);
        sharedPreferences.edit()
                .putString(key, json)
                .apply();
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        if (!sharedPreferences.contains(key))
            return null;

        return gson.fromJson(sharedPreferences.getString(key, null), clazz);
    }

}
