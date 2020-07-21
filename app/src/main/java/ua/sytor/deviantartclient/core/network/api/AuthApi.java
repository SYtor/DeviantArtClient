package ua.sytor.deviantartclient.core.network.api;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.network.data.UserTokenResponse;

public interface AuthApi {

    @POST(NetworkContract.AUTH_PATH + "token")
    Single<UserTokenResponse> token(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("grant_type") String grantType,
            @Query("code") String code,
            @Query("redirect_uri") String redirect_uri
    );

}
