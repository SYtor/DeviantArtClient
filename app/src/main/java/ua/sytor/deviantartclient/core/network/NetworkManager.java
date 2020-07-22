package ua.sytor.deviantartclient.core.network;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.sytor.deviantartclient.core.network.interceptor.LoggingInterceptor;

import static ua.sytor.deviantartclient.core.network.NetworkContract.ENDPOINT;

public class NetworkManager implements NetworkContract.NetworkManager {

    private OkHttpClient client;
    private Retrofit retrofit;

    @Inject
    public NetworkManager(Interceptor authInterceptor) {
        client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(authInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }


}
