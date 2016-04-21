package com.lidaofu.www.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by lidaofu on 2016/4/21.
 */
public class ScrollMoreView extends ScrollView {

    public ScrollMoreView(Context context) {
        super(context);
    }

    public ScrollMoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ScrollMoreView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
