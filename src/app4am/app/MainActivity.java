package app4am.app;

import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.os.Build;
import app4am.app.ui.NewsListRefreshListener;
import app4am.app.ui.TopicNewsAdapter;
import app4am.app.ui.TopicNewsListRefreshListener;

public class MainActivity extends Activity {

	// UI
	private ListView topicNewList;
	private TopicNewsAdapter adapter;

	// avtivity
	private Intent intent = null;

	// TopicNews refresh
	private PullToRefreshLayout pullToRefreshLayout = null;
	private TopicNewsListRefreshListener topicNewsListRefreshListener = null;
	private boolean mListShown;
	private View mProgressContainer;
	private View mListContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// set up user interface
		topicNewList = (ListView) findViewById(R.id.topicnewslist);
		mListContainer = findViewById(R.id.listContainer_main_activity);
		mProgressContainer = findViewById(R.id.progressContainer_main_activity);
		mListShown = true;

		adapter = new TopicNewsAdapter(this);
		topicNewList.setAdapter(adapter);

		// Now setup the PullToRefreshLayout
		pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.ptr_topicnews_layout);
		topicNewsListRefreshListener = new TopicNewsListRefreshListener(
				adapter, pullToRefreshLayout, this);
		ActionBarPullToRefresh.from(this)
		// Mark All Children as pullable
				.allChildrenArePullable()
				// Set a OnRefreshListener
				.listener(topicNewsListRefreshListener)
				// Finally commit the setup to our PullToRefreshLayout
				.setup(pullToRefreshLayout);

		topicNewList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				intent = new Intent(MainActivity.this, NewsActivity.class);
				// intent.putExtra(EXTRA_MESSAGE, message);
				startActivity(intent);
			}
		});

		setListShown(true);

	}

	public void setListShown(boolean shown, boolean animate) {
		if (mListShown == shown) {
			return;
		}
		mListShown = shown;
		if (shown) {
			if (animate) {
				mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
						this, android.R.anim.fade_out));
				mListContainer.startAnimation(AnimationUtils.loadAnimation(
						this, android.R.anim.fade_in));
			}
			mProgressContainer.setVisibility(View.GONE);
			mListContainer.setVisibility(View.VISIBLE);
		} else {
			if (animate) {
				mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
						this, android.R.anim.fade_in));
				mListContainer.startAnimation(AnimationUtils.loadAnimation(
						this, android.R.anim.fade_out));
			}
			mProgressContainer.setVisibility(View.VISIBLE);
			mListContainer.setVisibility(View.INVISIBLE);
		}
	}

	public void setListShown(boolean shown) {
		setListShown(shown, true);
	}

	public void setListShownNoAnimation(boolean shown) {
		setListShown(shown, false);
	}

}
