package com.example.zyb.qunyingzhuan5;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 随着手指移动的view
 * Created by zyb on 2017/5/2.
 */

public class DragView2 extends View {

    private int downX;
    private int downY;

    public DragView2(Context context) {
        super(context);
    }

    public DragView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //使用绝对坐标系
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点坐标
                downX = rawX;
                downY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = rawX - downX;
                int offsetY = rawY - downY;
                //根据偏移量重新layout
//                layout(getLeft() + offsetX,
//                        getTop() + offsetY,
//                        getRight() + offsetX,
//                        getBottom() + offsetY);

                //同时对left和right进行偏移
                offsetLeftAndRight(offsetX);
                //同时对top和bottom进行偏移
                offsetTopAndBottom(offsetY);
                //重新设置初始坐标
                downX = rawX;
                downY = rawY;
                break;
        }
        return true;
    }
}
