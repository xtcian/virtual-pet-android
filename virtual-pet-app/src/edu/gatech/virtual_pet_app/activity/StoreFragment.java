package edu.gatech.virtual_pet_app.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;
import edu.gatech.virtual_pet_app.R;
import edu.gatech.virtual_pet_app.Store;
import edu.gatech.virtual_pet_app.database.PDSource;

/**
 * Demonstrates expandable lists using a custom {@link ExpandableListAdapter}
 * from {@link BaseExpandableListAdapter}.
 */
public class StoreFragment extends Fragment {

	ExpandableListAdapter mAdapter;
	ExpandableListView listView;
	PDSource dataSource;
	Store store;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.store_tab, container, false);
		dataSource = ((PetActivity) getActivity()).getDataSource();
		store = dataSource.getItems();
		Log.d("StoreFragment", store.toString());
		// Set up our adapter
		listView = (ExpandableListView) view.findViewById(R.id.expandable_list);
		mAdapter = new MyExpandableListAdapter();
		listView.setAdapter(mAdapter);
		registerForContextMenu(listView);
		return view;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("Menu");
		menu.add(0, 0, 0, R.string.buy_item);

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) item
				.getMenuInfo();

		String title = ((TextView) info.targetView).getText().toString();

		int type = ExpandableListView
				.getPackedPositionType(info.packedPosition);
		if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
			int groupPos = ExpandableListView
					.getPackedPositionGroup(info.packedPosition);
			int childPos = ExpandableListView
					.getPackedPositionChild(info.packedPosition);
			Toast.makeText(
					this.getActivity(),
					title + ": Child " + childPos + " clicked in group "
							+ groupPos, Toast.LENGTH_SHORT).show();
			return true;
		} else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
			int groupPos = ExpandableListView
					.getPackedPositionGroup(info.packedPosition);
			Toast.makeText(this.getActivity(),
					title + ": Group " + groupPos + " clicked",
					Toast.LENGTH_SHORT).show();
			return true;
		}

		return false;
	}

	/**
	 * A simple adapter which maintains an ArrayList of photo resource Ids. Each
	 * photo is displayed as an image. This adapter supports clearing the list
	 * of photos and adding a new photo.
	 * 
	 */
	public class MyExpandableListAdapter extends BaseExpandableListAdapter {
		// Sample data set. children[i] contains the children (String[]) for
		// groups[i].
		private String[] groups = { "Food", "Toys", "Medicine" };

		public Object getChild(int groupPosition, int childPosition) {

			if (groupPosition == 0) {
				return store.getFood().valueAt(childPosition);
			} else if (groupPosition == 1) {
				return store.getToys().valueAt(childPosition);
			} else {
				return store.getMedicine().valueAt(childPosition);
			}
		}

		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		public int getChildrenCount(int groupPosition) {
			if (groupPosition == 0) {
				return store.getFood().size();
			} else if (groupPosition == 1) {
				return store.getToys().size();

			} else {
				return store.getMedicine().size();
			}
		}

		public TextView getGenericView() {
			// Layout parameters for the ExpandableListView
			AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 64);

			TextView textView = new TextView(StoreFragment.this.getActivity());
			textView.setLayoutParams(lp);
			// Center the text vertically
			textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			// Set the text starting position
			textView.setPadding(36, 0, 0, 0);
			return textView;
		}

		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			TextView textView = getGenericView();
			Log.d("StoreFragment", "(" + groupPosition + ", " + childPosition
					+ ")");
			textView.setText(getChild(groupPosition, childPosition).toString());
			return textView;
		}

		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		public int getGroupCount() {
			return groups.length;
		}

		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			TextView textView = getGenericView();
			textView.setText(getGroup(groupPosition).toString());
			return textView;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

		public boolean hasStableIds() {
			return true;
		}

	}
}