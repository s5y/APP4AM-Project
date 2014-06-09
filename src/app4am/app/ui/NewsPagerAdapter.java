package app4am.app.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import app4am.app.fragment.NewsFragment;

public class NewsPagerAdapter extends FragmentStatePagerAdapter {
	
	/**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;
	
    public NewsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

    @Override
    public Fragment getItem(int position) {
    	NewsFragment newsFragment = new NewsFragment();
    	newsFragment.setNewspaperID(position);
        return newsFragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
