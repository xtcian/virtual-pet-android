package edu.gatech.virtual_pet_app.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.gatech.virtual_pet_app.Pet;
import edu.gatech.virtual_pet_app.R;

public class PetActivity extends Activity implements ActionBar.TabListener {

	Pet myPet;

	Fragment petFragment;
	Fragment storeFragment;
	Fragment workFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pet);

		myPet = new Pet("Meowy");
		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		ActionBar.Tab petTab = actionBar.newTab().setText(
				R.string.title_section1);
		ActionBar.Tab storeTab = actionBar.newTab().setText(
				R.string.title_section2);
		ActionBar.Tab workTab = actionBar.newTab().setText(
				R.string.title_section3);
		petTab.setTabListener(this);
		storeTab.setTabListener(this);
		workTab.setTabListener(this);
		actionBar.addTab(petTab, 0);
		actionBar.addTab(storeTab, 1);
		actionBar.addTab(workTab, 2);

	}

//	@Override
//	public void onRestoreInstanceState(Bundle savedInstanceState) {
//		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
//			getActionBar().setSelectedNavigationItem(
//					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
//		}
//	}

//	@Override
//	public void onSaveInstanceState(Bundle outState) {
//		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
//				.getSelectedNavigationIndex());
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_pet, menu);
		return true;
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		public DummySectionFragment() {
		}

		public static final String ARG_SECTION_NUMBER = "section_number";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			Bundle args = getArguments();
			textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
			return textView;
		}
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		if (tab.getPosition() == 0) {
			Log.d("PetActivity", "onTabSelected 0");
			petFragment = new PetFragment();
			ft.add(R.id.container, petFragment);

		} else if (tab.getPosition() == 1) {
			Log.d("PetActivity", "onTabSelected 1");
			storeFragment = new StoreFragment();
			ft.add(R.id.container, storeFragment);

		} else {
			Log.d("PetActivity", "onTabSelected 2");
			workFragment = new WorkFragment();
			ft.add(R.id.container, workFragment);

		}

	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		if (tab.getPosition() == 0) {
			Log.d("PetActivity", "TabUNSelected 0");
			ft.remove(petFragment);

		} else if (tab.getPosition() == 1) {
			Log.d("PetActivity", "TabUNSelected 1");
			ft.remove(storeFragment);
		} else {
			Log.d("PetActivity", "TabUNSelected 2");
			ft.remove(workFragment);
		}

	}

	public Pet getMyPet() {
		return myPet;
	}

	public void setMyPet(Pet myPet) {
		this.myPet = myPet;
	}
}
