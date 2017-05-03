package com.example.zyb.qunyingzhuan5;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 随着手指滑动的view
 * Created by zyb on 2017/5/2.
 */

public class DragView1 extends View {

    private float downX;
    private float downY;

    public DragView1(Context context) {
        super(context);
    }

    public DragView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点坐标
                downX = x;
                downY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = (int) (x - downX);
                int offsetY = (int) (y - downY);
                //在当前left、top、right、bottom的基础上加上偏移量
//                layout(getLeft() + offsetX,
//                        getTop() + offsetY,
//                        getRight() + offsetX,
//                        getBottom() + offsetY);

                //同时对left和right进行偏移
                offsetLeftAndRight(offsetX);
                //同时对top和bottom进行偏移
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
