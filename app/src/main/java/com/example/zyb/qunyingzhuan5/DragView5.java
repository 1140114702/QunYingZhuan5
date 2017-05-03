package com.example.zyb.qunyingzhuan5;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by zyb on 2017/5/2.
 */

public class DragView5 extends View {

    private Scroller scroller;
    private int downX;
    private int downY;

    public DragView5(Context context) {
        super(context);
        initView();
    }

    public DragView5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragView5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        scroller = new Scroller(getContext());
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //判断Scroller是否执行完毕
        if (scroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            //通过重绘来不断调用computeScroll
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = x;
                downY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - downX;
                int offsetY = y - downY;
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                //手指离开时，执行滑动过程
                ViewGroup viewGroup = (ViewGroup) getParent();
                int scrollX = viewGroup.getScrollX();
                int scrollY = viewGroup.getScrollY();
                scroller.startScroll(scrollX, scrollY,-scrollX,-scrollY);
                invalidate();
                break;
        }
        return true;
    }
}
