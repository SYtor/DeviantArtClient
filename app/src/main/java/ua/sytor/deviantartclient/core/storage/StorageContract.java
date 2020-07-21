package ua.sytor.deviantartclient.core.storage;

public interface StorageContract {

    interface KeyValueStorage {
        <T> void save(String key, T value, Class<T> clazz);
        <T> T get(String key, Class<T> clazz);
    }

}
