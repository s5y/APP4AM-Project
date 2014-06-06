package app4am.app.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import app4am.app.MainActivity;

public class TopicNewsAdapter extends BaseAdapter {

	private MainActivity mainActivity;
	public List<String> topicNews;
	private static LayoutInflater inflater = null;

	public TopicNewsAdapter(MainActivity mainActivity) {
		topicNews = new ArrayList<String>();
		this.mainActivity = mainActivity;
		inflater = (LayoutInflater) mainActivity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getViewTypeCount() {
		return 2; // return 2, you have two types that the getView() method will
					// return, normal(0) and for the last row(1)
	}

	@Override
	public int getItemViewType(int position) {
		return (position == this.getCount() - 1) ? 1 : 0; // if we are at the
															// last position
															// then return 1,
															// for any other
															// position return 0
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		int theType = getItemViewType(position);
		if (view == null) {
			ViewHolder holder = new ViewHolder();
			LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			if (theType == 0) {
				// inflate the ordinary row
				view = vi.inflate(R.layout.list_item_bn, null);
				holder.textView = (TextView) view.findViewById(R.id.tv_name);
			} else if (theType == 1) {
				// inflate the row for the last position
				view = vi.inflate(R.layout.list_item_record, null);
				holder.textView = (TextView) view
						.findViewById(R.id.record_view);
			}
			view.setTag(holder);
		}
		// other stuff here, keep in mind that you have a different layout for
		// your last position so double check what are trying to initialize
	}

}
