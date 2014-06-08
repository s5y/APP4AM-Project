package app4am.app;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.os.Build;
import app4am.app.ui.TopicNewsAdapter;

public class MainActivity extends Activity {

	// UI
	private ListView topicNewList;
	private TopicNewsAdapter adapter;

	// avtivity
	private Intent intent = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// set up user interface
		topicNewList = (ListView) findViewById(R.id.topicnewslist);

		adapter = new TopicNewsAdapter(this);
		topicNewList.setAdapter(adapter);

		topicNewList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				intent = new Intent(MainActivity.this, NewsActivity.class);
				// intent.putExtra(EXTRA_MESSAGE, message);
				startActivity(intent);
			}
		});

	}
}
