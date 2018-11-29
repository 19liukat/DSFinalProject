package application.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UserArrayList {
	private ArrayList<User> userList;
	
	public UserArrayList() {
		userList = new ArrayList<User>();
		try {
			Scanner file = new Scanner(new FileReader("src/application/User/UserList"));
			while(file.hasNextLine()){
				String[] users = file.nextLine().split(";");
				User tempUser = new User(users[0], users[1]);
				userList.add(tempUser);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
