package ua.sytor.deviantartclient.core.paginator.data;

import java.util.List;

public class PaginableData<T> {

    private boolean hasNext;

    private int nextOffset;

    private List<T> data;

    public PaginableData(boolean hasNext, int nextOffset, List<T> data) {
        this.hasNext = hasNext;
        this.nextOffset = nextOffset;
        this.data = data;
    }

    public boolean hasNext() {
        return hasNext;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public List<T> getData() {
        return data;
    }

}
