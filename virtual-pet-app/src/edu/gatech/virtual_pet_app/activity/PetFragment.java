package edu.gatech.virtual_pet_app.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import edu.gatech.virtual_pet_app.Pet;
import edu.gatech.virtual_pet_app.R;
import edu.gatech.virtual_pet_app.User;
import edu.gatech.virtual_pet_app.database.PDSource;

public class PetFragment extends Fragment {
	TextView petTalkText;
	TextView happinessText;
	TextView hungerText;
	TextView healthText;
	TextView moneyText;
	ImageButton petImage;
	Pet myPet;
	User myUser;
	PDSource dataSource;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.pet_tab, container, false);

		petTalkText = (TextView) view.findViewById(R.id.petTalkText);
		happinessText = (TextView) view.findViewById(R.id.happinessText);
		hungerText = (TextView) view.findViewById(R.id.hungerText);
		healthText = (TextView) view.findViewById(R.id.healthText);
		moneyText = (TextView) view.findViewById(R.id.txtMoney);
		petImage = (ImageButton) view.findViewById(R.id.petImageBtn);

		myPet = ((PetActivity) getActivity()).getMyPet();
		myUser = ((PetActivity) getActivity()).getMyUser();
		dataSource = ((PetActivity) getActivity()).getDataSource();
		
		petTalkText.setText(myPet.getName());
		happinessText.setText("Ha: " + myPet.getHappiness());
		hungerText.setText("Hu: " + myPet.getHunger());
		healthText.setText("He: " + myPet.getHealth());
		moneyText.setText("Money: "+myUser.getMoney());
		petImage.setImageResource(R.drawable.happycat);
		return view;
	}
}
