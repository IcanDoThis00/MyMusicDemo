package com.example.mymusicdemo.views;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;

    public GridSpaceItemDecoration(int space,RecyclerView parent){
        mSpace = space;
        getRecyclerViewOffsets(parent);
    }

    /**
     *
     * @param outRect Item的矩形边界
     * @param view    ItemView
     * @param parent  RecyclerView
     * @param state   RecyclerView的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
    }

    private void getRecyclerViewOffsets(RecyclerView parent){
        //判断Item是不是第一行Item
//        if (parent.getChildLayoutPosition(view) % 3 == 0){
//            outRect.left = 0;
//            view margin
//            margin为正，则view会距离边界产生一个距离
//            margin为负数 ， view会超出边界产生一个距离

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        layoutParams.leftMargin = -mSpace;
        parent.setLayoutParams(layoutParams);
    }
}
