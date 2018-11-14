package application.User;

import java.util.ArrayList;

public class UserArrayList {
	private static ArrayList<User> userList;
	
	public UserArrayList() {
		userList = new ArrayList<User>();
	}
	public ArrayList<User> getUserList(){
		return userList;
	}
	public void addUser(User toAdd) {
		userList.add(toAdd);
	}
	public int getSize() {
		return this.userList.size();
	}

}
