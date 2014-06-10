package app4am.app.ui;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import app4am.app.MainActivity;
import app4am.app.data.model.Data;
import app4am.app.fragment.NewsFragment;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

public class TopicNewsListRefreshListener implements OnRefreshListener {

	private PullToRefreshLayout pullToRefreshLayout = null;
	private TopicNewsAdapter topicNewsAdapter = null;
	private MainActivity mainActivity = null;

	public TopicNewsListRefreshListener(TopicNewsAdapter topicNewsAdapter,
			PullToRefreshLayout pullToRefreshLayout, MainActivity mainActivity) {
		this.topicNewsAdapter = topicNewsAdapter;
		this.pullToRefreshLayout = pullToRefreshLayout;
		this.mainActivity = mainActivity;
	}

	@Override
	public void onRefreshStarted(View view) {
		// TODO Auto-generated method stub
		mainActivity.setListShown(false); // This will hide the listview and
											// visible a
		// round progress bar
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(5000); // 5 seconds
					// app4am.app.data.model.Data.refreshNews();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);

				topicNewsAdapter.notifyDataSetChanged();
				// Notify PullToRefreshLayout that the refresh has finished
				pullToRefreshLayout.setRefreshComplete();

				// if you set the "setListShown(false)" then you have to
				// uncomment the below code segment

				mainActivity.setListShown(true);
			}
		}.execute();
	}

}
