package ua.sytor.deviantartclient.core.network;

import android.net.Uri;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import ua.sytor.deviantartclient.core.network.api.AuthApi;
import ua.sytor.deviantartclient.core.network.data.AuthInitiationData;
import ua.sytor.deviantartclient.core.network.errors.AuthFailedException;

import static ua.sytor.deviantartclient.core.network.NetworkContract.AUTH_PATH;
import static ua.sytor.deviantartclient.core.network.NetworkContract.CLIENT_ID;
import static ua.sytor.deviantartclient.core.network.NetworkContract.ENDPOINT;
import static ua.sytor.deviantartclient.core.network.NetworkContract.REDIRECT_URL;

public class SessionManager implements NetworkContract.SessionManager {

    private AuthApi authApi;
    private NetworkContract.NetworkStorage storage;

    @Inject
    public SessionManager(AuthApi authApi, NetworkContract.NetworkStorage storage) {
        this.authApi = authApi;
        this.storage = storage;
    }

    @Override
    public Completable logIn(String redirectUrl) {
        return Single.fromCallable(() -> parseToken(redirectUrl))
                .flatMapCompletable(token -> {
                    storage.saveAccessToken(token);
                    return Completable.complete();
                });
    }

    @Override
    public Completable logOut() {
        return null;
    }

    @Override
    public Single<Boolean> isLogged() {
        String accessToken = storage.getAccessToken();
        if (accessToken == null) {
            return Single.just(false);
        }
        return authApi.placebo(accessToken)
                .andThen(Single.just(true))
                .onErrorReturn(throwable -> {
                    if (throwable instanceof AuthFailedException) {
                        return false;
                    } else {
                        throw new IllegalStateException(throwable);
                    }
                });
    }

    @Override
    public AuthInitiationData getAuthInitiationData() {
        return new AuthInitiationData(getAuthUrl(), REDIRECT_URL);
    }

    private String getAuthUrl() {
        Uri baseUri = Uri.parse(ENDPOINT + AUTH_PATH + "authorize");
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(baseUri.getScheme())
                .encodedAuthority(baseUri.getAuthority())
                .encodedPath(baseUri.getPath())
                .appendQueryParameter("response_type", "token")
                .appendQueryParameter("client_id", CLIENT_ID)
                .appendQueryParameter("redirect_uri", REDIRECT_URL)
                .appendQueryParameter("state", UUID.randomUUID().toString())
                .appendQueryParameter("scope", "browse");
        return builder.build().toString();
    }

    private String parseToken(String redirectUrl) {

        Uri uri = Uri.parse(redirectUrl);
        String encodedFragments = uri.getEncodedFragment();
        if (encodedFragments == null) {
            throw new RuntimeException("");
        }
        String[] fragments = encodedFragments.split("&");

        Map<String, String> fragmentsData = new HashMap<>();
        for (String fragment : fragments) {
            String[] pair = fragment.split("=");
            fragmentsData.put(pair[0], pair[1]);
        }

        String token = fragmentsData.get("access_token");
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Can't parse token");
        }
        return token;
    }

}
