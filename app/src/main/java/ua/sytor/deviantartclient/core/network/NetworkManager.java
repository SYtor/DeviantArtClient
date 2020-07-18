package ua.sytor.deviantartclient.core.network;

import android.net.Uri;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.sytor.deviantartclient.BuildConfig;
import ua.sytor.deviantartclient.core.network.data.AuthData;

public class NetworkManager implements NetworkContract.Manager {

    private final static String ENDPOINT = "https://www.deviantart.com/api/v1/oauth2/";
    private final static String AUTH_ENDPOINT = "https://www.deviantart.com/oauth2/authorize";
    private final static String REDIRECT_URL = "ua.syt0r.deviantartclient://oauth2";

    private final static String CLIENT_ID = BuildConfig.CLIENT_ID;
    private final static String CLIENT_SECRET = BuildConfig.CLIENT_SECRET;

    private Retrofit retrofit;

    public NetworkManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public AuthData getAuthData() {
        return new AuthData(getAuthUrl(), ENDPOINT);
    }

    @Override
    public <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    private String getAuthUrl() {
        Uri baseUri = Uri.parse(AUTH_ENDPOINT);
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
