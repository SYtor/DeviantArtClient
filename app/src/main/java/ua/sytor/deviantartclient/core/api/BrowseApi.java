package ua.sytor.deviantartclient.core.api;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.sytor.deviantartclient.core.api.data.DeviationsResponse;

public interface BrowseApi {

    String ENDPOINT = "https://www.deviantart.com/api/v1/oauth2/";

    static BrowseApi create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BrowseApi.class);
    }

    @GET("browse/newest")
    Single<DeviationsResponse> browseNewest(
            @Query("category_path") String categoryPath,
            @Query("q") String searchQuery,
            @Query("offset") int offset,
            @Query("limit") int limit
    );

}
