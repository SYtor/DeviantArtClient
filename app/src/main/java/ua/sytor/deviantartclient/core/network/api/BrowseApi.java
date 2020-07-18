package ua.sytor.deviantartclient.core.network.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.sytor.deviantartclient.core.network.data.DeviationsResponse;

public interface BrowseApi {

    @GET("browse/newest")
    Single<DeviationsResponse> browseNewest(
            @Query("category_path") String categoryPath,
            @Query("q") String searchQuery,
            @Query("offset") int offset,
            @Query("limit") int limit
    );

}
