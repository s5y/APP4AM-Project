package app4am.app.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NewsViewPager extends ViewPager{
	private boolean isPagingEnabled = true;


	public NewsViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isPagingEnabled = true;
    }
	
	@Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.isPagingEnabled) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.isPagingEnabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

	
	public boolean isPagingEnabled() {
		return isPagingEnabled;
	}

	public void setPagingEnabled(boolean isPagingEnabled) {
		this.isPagingEnabled = isPagingEnabled;
	}
}
