package in.jabezraja.captain.dao;

import in.jabezraja.captain.model.User;

public class UserDAO {
	public User[] findAll() {
		User[] userlist = UserList.listOfUser;
		return userlist;
	}

	public void create() {
		User newUser = new User();
		newUser.setId(001);
		newUser.setFirstName("King");
		newUser.setLastName("JR");
		newUser.setEmail("jabezking777@gmail.ocm");
		newUser.setPassword("jjjbro777");
		newUser.setActive(true);

		UserList.listOfUser[0] = newUser;
	}
}
