package com.sixin.ztv.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class XTextView extends android.support.v7.widget.AppCompatTextView {
    private DrawableLeftListener mLeftListener ;
    private DrawableRightListener mRightListener ;

    final int DRAWABLE_LEFT = 0;
    final int DRAWABLE_TOP = 1;
    final int DRAWABLE_RIGHT = 2;
    final int DRAWABLE_BOTTOM = 3;

    public XTextView(Context context) {
        super(context);
    }

    public XTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XTextView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (mRightListener != null) {
                    Drawable drawableRight = getCompoundDrawables()[DRAWABLE_RIGHT] ;
                    if (drawableRight != null && event.getRawX() >= (getRight() - drawableRight.getBounds().width()-40)) {
                        mRightListener.onDrawableRightClick(this) ;
                        return true ;
                    }
                }

                if (mLeftListener != null) {
                    Drawable drawableLeft = getCompoundDrawables()[DRAWABLE_LEFT] ;
                    if (drawableLeft != null && event.getRawX() <= (getLeft() + drawableLeft.getBounds().width())) {
                        mLeftListener.onDrawableLeftClick(this) ;
                        return true ;
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setDrawableLeftListener(DrawableLeftListener listener) {
        this.mLeftListener = listener;
    }

    public void setDrawableRightListener(DrawableRightListener listener) {
        this.mRightListener = listener;
    }

    public interface DrawableLeftListener {
        public void onDrawableLeftClick(View view) ;
    }

    public interface DrawableRightListener {
        public void onDrawableRightClick(View view) ;
    }
}
