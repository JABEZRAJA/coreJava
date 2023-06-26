package in.jabezraja.captain.service;

import in.jabezraja.captain.dao.UserDAO;

import in.jabezraja.captain.model.User;

public class Userservice {
	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}
		return userList;
	}

	public void create() {
		User newUser = new User();
		newUser.setId(001);
		newUser.setFirstName("King");
		newUser.setLastName("JR");
		newUser.setEmail("jabezking777@gmail.com");
		newUser.setPassword("jjjbro777");
		newUser.setActive(true);

		UserDAO userDao = new UserDAO();
		userDao.create(newUser);
	}

}