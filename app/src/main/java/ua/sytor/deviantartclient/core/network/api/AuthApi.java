package ua.sytor.deviantartclient.core.network.api;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.network.data.UserTokenResponse;

public interface AuthApi {

    @GET(NetworkContract.API_PATH + "placebo")
    Completable placebo(@Query("access_token") String access_token);

    @POST(NetworkContract.AUTH_PATH + "token")
    Single<UserTokenResponse> token(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("grant_type") String grantType,
            @Query("code") String code,
            @Query("redirect_uri") String redirect_uri
    );

}
