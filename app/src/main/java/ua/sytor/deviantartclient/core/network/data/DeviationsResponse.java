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

    public boolean hasMore() {
        return hasMore;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public List<Deviation> getResults() {
        return results;
    }

}