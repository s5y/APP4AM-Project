package app4am.app.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app4am.app.MainActivity;
import app4am.app.NewsActivity;
import app4am.app.R;
import app4am.app.basedata.Data;
import app4am.app.fragment.NewsFragment;

public class NewsAdapter extends BaseAdapter {

	private static final int TYPE_MAX_COUNT = 2;

	private NewsFragment newsFragment;
	public List<String> news;
	private static LayoutInflater inflater = null;

	public NewsAdapter(NewsFragment newsFragment) {
		news = new ArrayList<String>();
		this.newsFragment = newsFragment;
		inflater = (LayoutInflater) newsFragment.getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		Data.initTopicNews(news);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return news.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return news.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/*
	 * @Override public int getItemViewType(int position) { //first row if
	 * (position == 0) return 1; //not first row return 0; }
	 * 
	 * @Override public int getViewTypeCount() { return TYPE_MAX_COUNT; }
	 */

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		String content = news.get(position);
		if (row == null) {
			row = inflater.inflate(R.layout.row_news_list, null);
		}

		((TextView) row.findViewById(R.id.news_title)).setText(content);
		RelativeLayout rlLayout =  (RelativeLayout)row.findViewById(R.id.news_relative_layout);
		switch (newsFragment.getNewspaperID()) {
		case 0:
			rlLayout.setBackgroundColor(newsFragment.getResources().getColor(R.color.red));
			break;
		case 1:
			rlLayout.setBackgroundColor(newsFragment.getResources().getColor(R.color.green));
			break;
		case 2:
			rlLayout.setBackgroundColor(newsFragment.getResources().getColor(R.color.blue));
			break;
		case 3:
			rlLayout.setBackgroundColor(newsFragment.getResources().getColor(R.color.orange));
			break;

		default:
			break;
		}
		

		return row;
	}

}
