package ua.sytor.deviantartclient.core.api.data.deviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Deviation {

    @SerializedName("deviationid")
    @Expose
    private String deviationid;

    @SerializedName("printid")
    @Expose
    private Object printid;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("category_path")
    @Expose
    private String categoryPath;

    @SerializedName("is_favourited")
    @Expose
    private boolean isFavourited;

    @SerializedName("is_deleted")
    @Expose
    private boolean isDeleted;

    @SerializedName("author")
    @Expose
    private Author author;

    @SerializedName("stats")
    @Expose
    private Stats stats;

    @SerializedName("published_time")
    @Expose
    private int publishedTime;

    @SerializedName("allows_comments")
    @Expose
    private boolean allowsComments;

    @SerializedName("content")
    @Expose
    private Content content;

    @SerializedName("thumbs")
    @Expose
    private List<Thumb> thumbs = null;

    public String getDeviationid() {
        return deviationid;
    }

    public void setDeviationid(String deviationid) {
        this.deviationid = deviationid;
    }

    public Object getPrintid() {
        return printid;
    }

    public void setPrintid(Object printid) {
        this.printid = printid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public boolean isIsFavourited() {
        return isFavourited;
    }

    public void setIsFavourited(boolean isFavourited) {
        this.isFavourited = isFavourited;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public int getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(int publishedTime) {
        this.publishedTime = publishedTime;
    }

    public boolean isAllowsComments() {
        return allowsComments;
    }

    public void setAllowsComments(boolean allowsComments) {
        this.allowsComments = allowsComments;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Thumb> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<Thumb> thumbs) {
        this.thumbs = thumbs;
    }

}