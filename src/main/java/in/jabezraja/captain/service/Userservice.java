package in.jabezraja.captain.service;

import java.util.Set;

import in.jabezraja.captain.dao.UserDAO;
import in.jabezraja.captain.model.User;
import in.jabezraja.captain.validation.UserValidator;

public class Userservice {
	public Set<User> getAll() {

		UserDAO userDao = new UserDAO();
		Set<User> userList = userDao.findAll();
		for (User user : userList) {
			System.out.println(user);
		}
		return userList;
	}

	public void create(User newUser) throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDao = new UserDAO();
		userDao.create(newUser);

	}

	public void update() {
		User updatedUser = new User();
		updatedUser.setFirstName("King");
		updatedUser.setLastName("JR");
		updatedUser.setEmail("king@gmail.com");
		updatedUser.setId(7);
		updatedUser.setPassword("asdf;lkj");
		updatedUser.setActive(true);

		UserDAO userDao = new UserDAO();
		userDao.update(updatedUser);

	}

	public void delete(int userId) {
		UserDAO userDao = new UserDAO();
		userDao.delete(userId);
	}

//	public User findById(int id) {
//		UserDAO userDao = new UserDAO();
//		User user = userDao.findById(id);
//		return user;
//	}
}