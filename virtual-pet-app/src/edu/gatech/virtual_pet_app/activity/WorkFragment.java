package edu.gatech.virtual_pet_app.activity;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.gatech.virtual_pet_app.Job;
import edu.gatech.virtual_pet_app.Pet;
import edu.gatech.virtual_pet_app.R;
import edu.gatech.virtual_pet_app.User;
import edu.gatech.virtual_pet_app.database.PDSource;

public class WorkFragment extends Fragment implements View.OnClickListener{
	Button job1Btn;
	Button job2Btn;
	Button job3Btn;
	ArrayList<Job> jobs;
	PDSource dataSource;
	Pet myPet;
	User myUser;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.work_tab, container,
				false);
		job1Btn = (Button)view.findViewById(R.id.workBtn1);
		job2Btn = (Button)view.findViewById(R.id.workBtn2);
		job3Btn = (Button)view.findViewById(R.id.workBtn3);
		job1Btn.setOnClickListener(this);
		job2Btn.setOnClickListener(this);
		job3Btn.setOnClickListener(this);
		dataSource = ((PetActivity) getActivity()).getDataSource();
		jobs=dataSource.getJobs(((PetActivity) getActivity()).getMyPet());
		myPet = ((PetActivity) getActivity()).getMyPet();
		myUser = ((PetActivity) getActivity()).getMyUser();
		job1Btn.setText(jobs.get(0).getDescription() + " Earns: "+jobs.get(0).getEarnings());
		job2Btn.setText(jobs.get(1).getDescription() + " Earns: "+jobs.get(1).getEarnings());
		job3Btn.setText(jobs.get(2).getDescription() + " Earns: "+jobs.get(2).getEarnings());
		
		
		return view;
	}
	public void onClick(View v) {
		if(v.getId()==R.id.workBtn1){
			myUser.earn(jobs.get(0).getEarnings());
			((PetActivity) getActivity()).setMyUser(myUser);
			dataSource.updateMoney(myUser);
		}else if(v.getId()==R.id.workBtn2){
			myUser.earn(jobs.get(1).getEarnings());
			((PetActivity) getActivity()).setMyUser(myUser);
			dataSource.updateMoney(myUser);
		}else if(v.getId()==R.id.workBtn3){
			myUser.earn(jobs.get(2).getEarnings());
			((PetActivity) getActivity()).setMyUser(myUser);
			dataSource.updateMoney(myUser);
		}
		
	}
	
	
}
