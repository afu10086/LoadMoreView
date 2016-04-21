package com.lidaofu.www.view;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class LoadMoreView extends ViewPager {

    private static final String TAG = LoadMoreView.class.getSimpleName();

    private boolean canScrollUp = false;
    private boolean canScrollDown = false;
    private int scrollY = 0;
    private int oldX = 0, oldY = 0;

    public LoadMoreView(Context context) {
        this(context, null);
    }

    public LoadMoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPageTransformer(false, new DefaultTransformer());
    }

    private MotionEvent swapTouchEvent(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();

        float swappedX = (event.getY() / height) * width;
        float swappedY = (event.getX() / width) * height;

        event.setLocation(swappedX, swappedY);
        return event;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercept = super.onInterceptTouchEvent(swapTouchEvent(event));
        //If not intercept, touch event should not be swapped.
        swapTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                oldX = (int) event.getX();
                oldY = (int) event.getY();
                intercept = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int newX = (int) event.getX();
                int newY = (int) event.getY();
                int disY = newY - oldY;
                int disX = newX - oldX;
                if (Math.abs(disY) > Math.abs(disX)) {
                    if ((canScrollUp && !canScrollDown && scrollY == 0 && (disY > 0)) || (!canScrollUp && canScrollDown && scrollY > 0 && (disY < 0))||(!canScrollDown&&!canScrollUp&&scrollY==0)) {
                        intercept = true;
                    } else {
                        intercept = false;
                    }
                } else {
                    intercept = false;
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                intercept = false;
                break;
            }
            default:
                break;
        }
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapTouchEvent(ev));
    }


    @Override
    protected boolean canScroll(View view, boolean checkV, int dx, int x, int y) {
        if (view != null && view instanceof ScrollMoreView) {
            canScrollUp = view.canScrollVertically(1);
            canScrollDown = view.canScrollVertically(-1);
            scrollY = view.getScrollY();
        }
        return super.canScroll(view, checkV, dx, x, y);
    }
}
