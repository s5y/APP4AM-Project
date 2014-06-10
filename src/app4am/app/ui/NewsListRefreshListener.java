package app4am.app.ui;

import java.util.ArrayList;

import android.graphics.DashPathEffect;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.view.View;
import app4am.app.data.model.Data;
import app4am.app.fragment.NewsFragment;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

public class NewsListRefreshListener implements OnRefreshListener {

	private PullToRefreshLayout pullToRefreshLayout = null;
	private NewsFragment newsFragment = null;
	// get all adapter for update all news
	private ArrayList<NewsFragment> newsFragmentsList = null;

	public NewsListRefreshListener(ArrayList<NewsFragment> newsFragmentsList,
			PullToRefreshLayout pullToRefreshLayout, NewsFragment newsFragment) {
		this.newsFragmentsList = newsFragmentsList;
		this.pullToRefreshLayout = pullToRefreshLayout;
		this.newsFragment = newsFragment;
	}

	@Override
	public void onRefreshStarted(View view) {
		// TODO Auto-generated method stub
		newsFragment.setListShown(false); // This will hide the listview and visible a
		// round progress bar
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(5000); // 5 seconds
					// app4am.app.data.model.Data.refreshNews();
					Log.d("app4am", newsFragmentsList.size() + "");
					for (NewsFragment item : newsFragmentsList) {
						Data.refreshNews(item.getAdapter().news);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);

				for (NewsFragment item : newsFragmentsList) {
					item.getAdapter().notifyDataSetChanged();
				}
				// Notify PullToRefreshLayout that the refresh has finished
				pullToRefreshLayout.setRefreshComplete();

				// if you set the "setListShown(false)" then you have to
				// uncomment the below code segment

				newsFragment.setListShown(true);
			}
		}.execute();
	}

}
