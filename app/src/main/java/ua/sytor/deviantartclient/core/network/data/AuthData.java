package ua.sytor.deviantartclient.core.network.data;

public class AuthData {

    private String authUrl;
    private String redirectUrl;

    public AuthData(String authUrl, String redirectUrl) {
        this.authUrl = authUrl;
        this.redirectUrl = redirectUrl;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
