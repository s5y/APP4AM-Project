package app4am.app.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app4am.app.MainActivity;
import app4am.app.R;
import app4am.app.data.model.Data;

public class TopicNewsAdapter extends BaseAdapter {

	private static final int TYPE_MAX_COUNT = 2;

	private MainActivity mainActivity;
	public List<String> topicNews;
	private static LayoutInflater inflater = null;

	public TopicNewsAdapter(MainActivity mainActivity) {
		topicNews = new ArrayList<String>();
		this.mainActivity = mainActivity;
		inflater = (LayoutInflater) mainActivity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		Data.initTopicNews(topicNews);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return topicNews.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return topicNews.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		//first row
		if (position == 0)
			return 1;
		//not first row
		return 0;
	}

	@Override
	public int getViewTypeCount() {
		return TYPE_MAX_COUNT;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		int type = getItemViewType(position);
		String content = topicNews.get(position);
		if (row == null) {
			if (type == 1) {
				row = inflater.inflate(R.layout.row_first_topicnews_list, null);	
			} else {
				row = inflater.inflate(R.layout.row_topicnews_list, null);
			}
		}
		
		((TextView)row.findViewById(R.id.topic_news_title)).setText(content);
		
		return row;
	}

}
