package ua.sytor.deviantartclient.core.network.interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ua.sytor.deviantartclient.core.logger.Logger;

public class LoggingInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Logger.log("request " + request);
        Response response = chain.proceed(request);
        Logger.log("response " + response + " " + response.message());
        return response;
    }

}