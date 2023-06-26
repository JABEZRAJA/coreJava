package in.jabezraja.captain.dao;

import in.jabezraja.captain.model.User;

public class UserDAO {
	public User[] findAll() {
		User[] userlist = UserList.listOfUser;
		return userlist;
	}

	public void create(User newUser) {
		UserList.listOfUser[0] = newUser;
	}
}
