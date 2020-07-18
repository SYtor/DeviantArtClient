package ua.sytor.deviantartclient.presentation.main.screens.auth.data;

public class AuthRedirectData {

    private String redirectUrl;

    public AuthRedirectData(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

}