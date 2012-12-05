package edu.gatech.virtual_pet_app.activity;

import edu.gatech.virtual_pet_app.Pet;
import edu.gatech.virtual_pet_app.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class PetFragment extends Fragment {
	TextView petTalkText;
	TextView happinessText;
	TextView hungerText;
	TextView healthText;
	ImageButton petImage;
	Pet myPet;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.pet_tab, container, false);

		petTalkText = (TextView) view.findViewById(R.id.petTalkText);
		happinessText = (TextView) view.findViewById(R.id.happinessText);
		hungerText = (TextView) view.findViewById(R.id.hungerText);
		healthText = (TextView) view.findViewById(R.id.healthText);
		petImage = (ImageButton) view.findViewById(R.id.petImageBtn);

		myPet = ((PetActivity) getActivity()).getMyPet();
		petTalkText.setText(myPet.getName());
		happinessText.setText("" + myPet.getHappiness());
		hungerText.setText("" + myPet.getHunger());
		healthText.setText("" + myPet.getHealth());
		petImage.setImageResource(R.drawable.happycat);
		return view;
	}
}
