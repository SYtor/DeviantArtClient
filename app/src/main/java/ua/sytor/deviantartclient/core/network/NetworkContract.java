package ua.sytor.deviantartclient.core.network;

import io.reactivex.Completable;
import ua.sytor.deviantartclient.BuildConfig;
import ua.sytor.deviantartclient.core.network.data.AuthInitiationData;

public interface NetworkContract {

    String ENDPOINT = "https://www.deviantart.com/";
    String AUTH_PATH = "oauth2/";
    String API_PATH = "api/v1/oauth2/";
    String REDIRECT_URL = "ua.syt0r.deviantartclient://oauth2";

    String CLIENT_ID = BuildConfig.CLIENT_ID;
    String CLIENT_SECRET = BuildConfig.CLIENT_SECRET;

    String TOKEN_FETCH_GRANT_TYPE = "authorization_code";
    String TOKEN_REFRESH_GRANT_TYPE = "refresh_token";

    interface NetworkManager {
        AuthInitiationData getAuthInitiationData();

        <T> T createApi(Class<T> clazz);
    }

    interface SessionManager {
        Completable logIn(String redirectUrl);
        Completable logOut();
        Boolean isLogged();
    }

}
