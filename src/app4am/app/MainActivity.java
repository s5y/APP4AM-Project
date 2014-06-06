package app4am.app;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;
import app4am.app.ui.TopicNewsAdapter;

public class MainActivity extends Activity {

	//UI
	private ListView topicNewList;
	private TopicNewsAdapter adapter;
	
	//generator data
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// set up user interface
		topicNewList = (ListView) findViewById(R.id.topicnewslist);
		
		adapter = new TopicNewsAdapter(this);
		topicNewList.setAdapter(adapter);
	
	}
}
