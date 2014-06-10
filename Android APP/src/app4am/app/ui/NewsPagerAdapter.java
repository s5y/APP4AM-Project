package app4am.app.ui;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import app4am.app.fragment.NewsFragment;

public class NewsPagerAdapter extends FragmentPagerAdapter {
	
	/**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;
    private ArrayList<NewsFragment> newsFragmentsList = null;

	public NewsPagerAdapter(FragmentManager fm) {
		super(fm);
    	newsFragmentsList = new ArrayList<NewsFragment>();
		// TODO Auto-generated constructor stub
	}

    @Override
    public Fragment getItem(int position) {
    	NewsFragment newsFragment = new NewsFragment();
    	newsFragment.setNewspaperID(position);
    	newsFragmentsList.add(newsFragment);
        return newsFragment;
    }
    
    public ArrayList<NewsFragment> getNewsFragmentsList() {
		return newsFragmentsList;
	}        

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
