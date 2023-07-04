package in.jabezraja.captain.dao;

import in.jabezraja.captain.model.User;

public class UserDAO {

	/**
	 * Returns all Users in the UserList.
	 *
	 * @return An array of all User objects in the UserList.
	 */
	public User[] findAll() {
		User[] userlist = UserList.listOfUser;
		return userlist;
	}

	/**
	 * Adds a new User to the first available slot in UserList. Prints a success
	 * message if successful, or a failure message otherwise.
	 *
	 * @param newUser The User to be added to the UserList.
	 */

	public void create(User newUser) {

		User[] arr = UserList.listOfUser;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				arr[i] = newUser;
				break;
			}
		}
	}

	/**
	 * Replaces a User in the UserList with updatedUser, matching by userId.
	 *
	 * @param updatedUser The User with updated information.
	 */

	public void update(int id, User updateUser) {
		User[] arr = UserList.listOfUser;

		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == id) {
				arr[i].setFirstName(updateUser.getFirstName());
				arr[i].setLastName(updateUser.getLastName());
				arr[i].setPassword(updateUser.getPassword());
				// user.setFirstName("Jabez");
			}
		}
	}

	/**
	 * Deactivates a User in the UserList by setting its active status to false.
	 *
	 * @param userId The id of the User to be deactivated.
	 */

	public void delete(int userId) {
		User[] arr = UserList.listOfUser;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];

			if (user == null) {
				continue;
			}

			if (user.getId() == userId) {
				user.setActive(false);
				break;
			}
		}
	}

	/**
	 * Finds and returns a User from UserList matching the given userId.
	 *
	 * @param userId The id of the User to be found.
	 * @return The User with the matching id, or null if no match is found.
	 */

	public User findById(int userId) {
		User[] arr = UserList.listOfUser;
		User userMatch = null;

		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];

			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

}
