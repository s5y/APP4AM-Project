package app4am.app.fragment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import app4am.app.ArticleActivity;
import app4am.app.NewsActivity;
import app4am.app.R;
import app4am.app.ui.NewsAdapter;
import app4am.app.ui.NewsListRefreshListener;
import app4am.app.ui.NewsViewPager;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

public class NewsFragment extends Fragment {
	// present which newspaper
	private int newspaperID = -1;

	// UI
	private ListView newsList;
	private NewsAdapter adapter;
	private NewsViewPager newsViewPager = null;
	private ActionBar actionBar = null;

	//
	private Intent intent = null;

	// News refresh
	private PullToRefreshLayout pullToRefreshLayout = null;
	private NewsListRefreshListener newsListRefreshListener = null;
	private boolean mListShown;
	private View mProgressContainer = null;
	private View mListContainer = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.news_fragment, container, false);

		// set up user interface
		newsList = (ListView) rootView.findViewById(R.id.news_list);
		mListContainer = rootView
				.findViewById(R.id.listContainer_news_fragment);
		mProgressContainer = rootView
				.findViewById(R.id.progressContainer_news_fragment);
		mListShown = true;

		adapter = new NewsAdapter(this);
		newsList.setAdapter(adapter);

		actionBar = ((NewsActivity) getActivity()).getActionBar();
		newsViewPager = ((NewsActivity) getActivity()).getNewsPager();

		newsList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				intent = new Intent(NewsFragment.this.getActivity(),
						ArticleActivity.class);
				intent.putExtra("newspaper", NewsFragment.this.newspaperID);
				startActivity(intent);
			}
		});

		// Now setup the PullToRefreshLayout
		pullToRefreshLayout = (PullToRefreshLayout) rootView
				.findViewById(R.id.ptr_news_layout);
		newsListRefreshListener = new NewsListRefreshListener(
				((NewsActivity) getActivity()).getPagerAdapter()
						.getNewsFragmentsList(), pullToRefreshLayout, this);
		ActionBarPullToRefresh.from(this.getActivity())
		// Mark All Children as pullable
				.allChildrenArePullable()
				// Set a OnRefreshListener
				.listener(newsListRefreshListener)
				// Finally commit the setup to our PullToRefreshLayout
				.setup(pullToRefreshLayout);

		return rootView;
	}

	public void setListShown(boolean shown, boolean animate) {
		if (mListShown == shown) {
			return;
		}
		mListShown = shown;
		if (shown) {
			if (animate) {
				mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
						getActivity(), android.R.anim.fade_out));
				mListContainer.startAnimation(AnimationUtils.loadAnimation(
						getActivity(), android.R.anim.fade_in));
			}
			mProgressContainer.setVisibility(View.GONE);
			mListContainer.setVisibility(View.VISIBLE);
			((NewsActivity) getActivity()).getNewsPager()
					.setPagingEnabled(true);
			((NewsActivity) getActivity()).getNewsTabListener().setTabEnabled(
					true);
			newsViewPager.setCurrentItem(actionBar.getSelectedTab()
					.getPosition());
		} else {
			if (animate) {
				mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
						getActivity(), android.R.anim.fade_in));
				mListContainer.startAnimation(AnimationUtils.loadAnimation(
						getActivity(), android.R.anim.fade_out));
			}
			mProgressContainer.setVisibility(View.VISIBLE);
			mListContainer.setVisibility(View.INVISIBLE);
			((NewsActivity) getActivity()).getNewsPager().setPagingEnabled(
					false);
			((NewsActivity) getActivity()).getNewsTabListener().setTabEnabled(
					false);
		}
	}

	public void setListShown(boolean shown) {
		setListShown(shown, true);
	}

	public void setListShownNoAnimation(boolean shown) {
		setListShown(shown, false);
	}

	public int getNewspaperID() {
		return newspaperID;
	}

	public void setNewspaperID(int newspaperID) {
		this.newspaperID = newspaperID;
	}

	public NewsAdapter getAdapter() {
		return adapter;
	}

}
