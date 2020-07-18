package ua.sytor.deviantartclient.core.api.data.deviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("userid")
    @Expose
    private String userId;

    @SerializedName("username")
    @Expose
    private String userName;

    @SerializedName("usericon")
    @Expose
    private String userIcon;

    @SerializedName("type")
    @Expose
    private String type;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}