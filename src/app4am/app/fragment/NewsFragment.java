package app4am.app.fragment;

import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import app4am.app.ArticleActivity;
import app4am.app.MainActivity;
import app4am.app.NewsActivity;
import app4am.app.R;
import app4am.app.ui.NewsAdapter;
import app4am.app.ui.TopicNewsAdapter;

public class NewsFragment extends Fragment {
	//present which newspaper
	private int newspaperID = -1;

	// UI
	private ListView newsList;
	private NewsAdapter adapter;
	
	//
	private Intent intent = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.news_fragment, container, false);

		// set up user interface
		newsList = (ListView) rootView.findViewById(R.id.news_list);
		adapter = new NewsAdapter(this);
		newsList.setAdapter(adapter);
		
		newsList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				intent = new Intent(NewsFragment.this.getActivity(), ArticleActivity.class);
				intent.putExtra("newspaper", NewsFragment.this.newspaperID);
				startActivity(intent);
			}
		});

		return rootView;
	}
	
	public int getNewspaperID() {
		return newspaperID;
	}

	public void setNewspaperID(int newspaperID) {
		this.newspaperID = newspaperID;
	}
}
