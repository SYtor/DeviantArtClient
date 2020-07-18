package ua.sytor.deviantartclient.core.api.data.deviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("comments")
    @Expose
    private int comments;

    @SerializedName("favourites")
    @Expose
    private int favourites;

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getFavourites() {
        return favourites;
    }

    public void setFavourites(int favourites) {
        this.favourites = favourites;
    }

}