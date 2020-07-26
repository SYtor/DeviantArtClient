package ua.sytor.deviantartclient.core.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewUtils {

    public static void addGridRowSpacing(RecyclerView recyclerView, @DimenRes int spacingResId) {
        Context context = recyclerView.getContext();
        final int spacing = context.getResources().getDimensionPixelOffset(spacingResId);

        GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        assert layoutManager != null;
        final int spanCount = layoutManager.getSpanCount();

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(
                    @NonNull Rect outRect,
                    @NonNull View view,
                    @NonNull RecyclerView parent,
                    @NonNull RecyclerView.State state
            ) {
                int position = parent.getChildAdapterPosition(view);
                boolean isFirstInRow = position % spanCount == 0;
                outRect.set(
                        isFirstInRow ? 0 : spacing,
                        0,
                        spacing,
                        0
                );
            }
        });

    }

}
