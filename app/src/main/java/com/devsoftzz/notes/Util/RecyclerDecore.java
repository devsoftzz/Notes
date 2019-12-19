package com.devsoftzz.notes.Util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerDecore extends RecyclerView.ItemDecoration {

    private final int PaddingBetweenItems;

    public RecyclerDecore(int paddingBetweenItems) {
        PaddingBetweenItems = paddingBetweenItems;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = PaddingBetweenItems/2;
        outRect.left = PaddingBetweenItems;
        outRect.right = PaddingBetweenItems;
        outRect.top = PaddingBetweenItems/2;
    }
}
