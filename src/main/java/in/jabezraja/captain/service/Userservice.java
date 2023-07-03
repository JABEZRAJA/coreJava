package in.jabezraja.captain.service;

import in.jabezraja.captain.dao.UserDAO;
import in.jabezraja.captain.model.User;
import in.jabezraja.captain.validation.UserValidator;

public class Userservice {
	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}
		return userList;
	}

	public void create(User newUser) throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);

	}

	public void update(int id, User updateUser) {
		// User updateUser = new User();
		UserDAO userDao = new UserDAO();
		userDao.update(001, updateUser);
	}

	public void delete() {
		User deleteUser = new User();
		UserDAO userDao = new UserDAO();
		userDao.delete(001);
	}

	public User findById(int id) {
		UserDAO userDao = new UserDAO();
		User user = userDao.findById(id);
		return user;
	}
}