package ua.sytor.deviantartclient.core.network;

import android.net.Uri;

import androidx.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import ua.sytor.deviantartclient.core.network.api.AuthApi;
import ua.sytor.deviantartclient.core.network.data.UserTokenResponse;
import ua.sytor.deviantartclient.core.storage.StorageContract;

public class SessionManager implements NetworkContract.SessionManager {

    private static final String USER_TOKEN_KEY = "user_token";

    private AuthApi authApi;
    private StorageContract.KeyValueStorage storage;

    @Inject
    public SessionManager(AuthApi authApi, StorageContract.KeyValueStorage storage) {
        this.authApi = authApi;
        this.storage = storage;
    }

    @Override
    public Completable logIn(String redirectUrl) {
        return Single.fromCallable(() -> parseCode(redirectUrl))
                .flatMap(code ->
                        authApi.token(
                                NetworkContract.CLIENT_ID,
                                NetworkContract.CLIENT_SECRET,
                                NetworkContract.TOKEN_FETCH_GRANT_TYPE,
                                code,
                                NetworkContract.REDIRECT_URL
                        )
                )
                .flatMapCompletable(userTokenResponse -> {
                    storage.save(USER_TOKEN_KEY, userTokenResponse, UserTokenResponse.class);
                    return CompletableObserver::onComplete;
                });
    }

    @Override
    public Completable logOut() {
        return null;
    }

    @Override
    public Boolean isLogged() {
        return storage.get(USER_TOKEN_KEY, UserTokenResponse.class) != null;
    }

    private String parseCode(String redirectUrl) {
        Uri uri = Uri.parse(redirectUrl);
        String code = uri.getQueryParameter("code");
        if (code == null || code.isEmpty()) {
            throw new RuntimeException("Can't parse code");
        }
        return code;
    }

    class CustomAuthenticator implements Authenticator {

        @Override
        public Request authenticate(Route route, @NonNull Response response) {
            return null;
        }

    }


}
