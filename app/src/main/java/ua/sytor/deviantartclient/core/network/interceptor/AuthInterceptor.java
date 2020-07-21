package ua.sytor.deviantartclient.core.network.interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        if (true) {
//            request = request.newBuilder()
//                    .header("","")
//                    .build();
//        }
        Response response = chain.proceed(request);
        return response;
    }

}