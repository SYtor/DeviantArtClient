package ua.sytor.deviantartclient.core.network;

import android.net.Uri;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.sytor.deviantartclient.core.network.data.AuthInitiationData;
import ua.sytor.deviantartclient.core.network.interceptor.AuthInterceptor;
import ua.sytor.deviantartclient.core.network.interceptor.LoggingInterceptor;

import static ua.sytor.deviantartclient.core.network.NetworkContract.AUTH_PATH;
import static ua.sytor.deviantartclient.core.network.NetworkContract.CLIENT_ID;
import static ua.sytor.deviantartclient.core.network.NetworkContract.ENDPOINT;
import static ua.sytor.deviantartclient.core.network.NetworkContract.REDIRECT_URL;

public class NetworkManager implements NetworkContract.NetworkManager {

    private OkHttpClient client;
    private Retrofit retrofit;

    public NetworkManager() {
        client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new AuthInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public AuthInitiationData getAuthInitiationData() {
        return new AuthInitiationData(getAuthUrl(), REDIRECT_URL);
    }

    @Override
    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    private String getAuthUrl() {
        Uri baseUri = Uri.parse(ENDPOINT + AUTH_PATH + "authorize");
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(baseUri.getScheme())
                .encodedAuthority(baseUri.getAuthority())
                .encodedPath(baseUri.getPath())
                .appendQueryParameter("response_type", "code")
                .appendQueryParameter("client_id", CLIENT_ID)
                .appendQueryParameter("redirect_uri", REDIRECT_URL);
        return builder.build().toString();
    }

}
