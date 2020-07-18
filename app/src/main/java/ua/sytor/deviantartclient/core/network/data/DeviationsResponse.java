package ua.sytor.deviantartclient.core.network.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;

public class DeviationsResponse {

    @SerializedName("has_more")
    @Expose
    private boolean hasMore;

    @SerializedName("next_offset")
    @Expose
    private int nextOffset;

    @SerializedName("results")
    @Expose
    private List<Deviation> results = null;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(int nextOffset) {
        this.nextOffset = nextOffset;
    }

    public List<Deviation> getResults() {
        return results;
    }

    public void setResults(List<Deviation> results) {
        this.results = results;
    }

}