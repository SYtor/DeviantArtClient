package ua.sytor.deviantartclient.core.network.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.sytor.deviantartclient.core.network.data.UserTokenResponse;

interface AuthApi {

    @GET("token")
    Single<UserTokenResponse> token(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("grant_type") String grantType,
            @Query("code") String code,
            @Query("redirect_uri ") String redirect_uri
    );

}
