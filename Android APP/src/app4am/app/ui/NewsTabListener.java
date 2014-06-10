package app4am.app.ui;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

public class NewsTabListener implements ActionBar.TabListener {

	private ViewPager newsPager = null;
	private boolean isTabEnabled = true;

	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		if (isTabEnabled) {// show the given tab
			if (newsPager != null)
				newsPager.setCurrentItem(tab.getPosition());
		}
	}

	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
		// hide the given tab
	}

	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
		// probably ignore this event
	}

	public ViewPager getNewsPager() {
		return newsPager;
	}

	public void setNewsPager(ViewPager newsPager) {
		this.newsPager = newsPager;
	}
	
	public boolean isTabEnabled() {
		return isTabEnabled;
	}

	public void setTabEnabled(boolean isTabEnabled) {
		this.isTabEnabled = isTabEnabled;
	}

}
