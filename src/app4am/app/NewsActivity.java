package app4am.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import app4am.app.fragment.NewsFragment;
import app4am.app.ui.NewsPagerAdapter;
import app4am.app.ui.NewsTabListener;

public class NewsActivity extends FragmentActivity {

	public static String[] NEWSPAPER = { "蘋果", "自由", "中時", "聯合" };
	/**
	 * The pager widget, which handles animation and allows swiping horizontally
	 * to access previous and next wizard steps.
	 */
	private ViewPager newsPager;

	/**
	 * The pager adapter, which provides the pages to the view pager widget.
	 */
	private PagerAdapter pagerAdapter;

	// tab listener
	private NewsTabListener newsTabListener = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_activity);

		ActionBar ab = getActionBar();
		// Enable the home up function
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		// Specify that tabs should be displayed in the action bar.
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		newsTabListener = new NewsTabListener();

		// Add 4 tabs, specifying the tab's text and TabListener

		for (String itemString : NEWSPAPER) {
			ab.addTab(ab.newTab().setText(itemString)
					.setTabListener(newsTabListener));
		}

		// Instantiate a ViewPager and a PagerAdapter.
		newsPager = (ViewPager) findViewById(R.id.news_pager);
		pagerAdapter = new NewsPagerAdapter(getSupportFragmentManager());
		newsPager.setAdapter(pagerAdapter);
		newsPager.setOnPageChangeListener(
	            new ViewPager.SimpleOnPageChangeListener() {
	                @Override
	                public void onPageSelected(int position) {
	                    // When swiping between pages, select the
	                    // corresponding tab.
	                    getActionBar().setSelectedNavigationItem(position);
	                }
	            });
		//set tab switch can switch pager
		newsTabListener.setNewsPager(newsPager);
		
	}

	@Override
	public void onBackPressed() {
		if (newsPager.getCurrentItem() == 0) {
			// If the user is currently looking at the first step, allow the
			// system to handle the
			// Back button. This calls finish() on this activity and pops the
			// back stack.
			super.onBackPressed();
		} else {
			// Otherwise, select the previous step.
			newsPager.setCurrentItem(newsPager.getCurrentItem() - 1);
		}
	}

}