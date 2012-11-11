package edu.gatech.virtual_pet_app;

public class User {
	String username;
	String password;
	int money;

	public User(String uname, String pwd) {
		username = uname;
		password = pwd;
	}

	boolean login(String pwd) {
		if (password.equals(pwd)) {
			return true;
		}
		return false;
	}
}
