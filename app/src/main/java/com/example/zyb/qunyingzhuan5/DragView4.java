package com.example.zyb.qunyingzhuan5;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zyb on 2017/5/2.
 */

public class DragView4 extends android.support.v7.widget.AppCompatTextView {

    private int downX;
    private int downY;

    public DragView4(Context context) {
        super(context);
    }

    public DragView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();
                downY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - downX;
                int offsetY = y - downY;
                //scrollBy(scrollTo)滑动的是子的东西
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
//                downX = x;
//                downY = y;
                break;
        }
        return true;
    }
}
