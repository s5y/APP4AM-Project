package app4am.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class ArticleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article_activity);
		
		ActionBar ab = getActionBar();
		// Enable the home up function
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		
		LinearLayout liLayout = (LinearLayout)findViewById(R.id.article_linearlayout);
		int newsPaperID =  getIntent().getIntExtra("newspaper", -1);
		switch (newsPaperID) {
		case 0:
			liLayout.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case 1:
			liLayout.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case 2:
			liLayout.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case 3:
			liLayout.setBackgroundColor(getResources().getColor(R.color.orange));
			break;

		default:
			break;
		}

		
	}

}