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

}
