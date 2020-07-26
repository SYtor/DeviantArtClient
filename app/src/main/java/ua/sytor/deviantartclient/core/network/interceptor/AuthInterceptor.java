package ua.sytor.deviantartclient.core.network.interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ua.sytor.deviantartclient.core.network.NetworkContract;
import ua.sytor.deviantartclient.core.network.errors.AuthFailedException;

public class AuthInterceptor implements Interceptor {

    private NetworkContract.NetworkStorage storage;

    @Inject
    public AuthInterceptor(NetworkContract.NetworkStorage storage) {
        this.storage = storage;
    }

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = createRequestWithToken(chain.request());
        Response response = chain.proceed(request);

        if (response.code() == 401)
            throw new AuthFailedException();

        return response;
    }

    private Request createRequestWithToken(Request request) {
        String token = storage.getAccessToken();
        if (token != null && !token.isEmpty()) {
            return request.newBuilder()
                    .header("Authorization", "Bearer " + token)
                    .build();
        }
        return request;
    }

}