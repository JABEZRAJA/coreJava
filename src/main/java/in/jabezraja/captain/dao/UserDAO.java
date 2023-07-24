package in.jabezraja.captain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import in.jabezraja.captain.interfaces.UserInterface;
import in.jabezraja.captain.model.User;
import in.jabezraja.captain.util.ConnectionUtil;

public class UserDAO implements UserInterface{

	/**
	 * Returns all Users in the UserList.
	 *
	 * @return An array of all User objects in the UserList.
	 */

	@Override
	public Set<User> findAll() throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<User> userList = new HashSet<>();
		try {
			String query = "SELECT * FROM Users var IsActive = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery(); // this will get the object
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_Active"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return userList;
	}

	/**
	 * Adds a new User to the first available slot in UserList. Prints a success
	 * message if successful, or a failure message otherwise.
	 *
	 * @param newUser The User to be added to the UserList.
	 */

	@Override
	public void create(User newUser) {
		Set<User> arr = UserList.listOfUsers;
		arr.add(newUser);
	}

	/**
	 * Replaces a User in the UserList with updatedUser, matching by userId.
	 *
	 * @param updatedUser The User with updated information.
	 */

	@Override
	public void update(User updatedUser) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
			if (user.getId() == updatedUser.getId()) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setPassword(updatedUser.getPassword());

				break;
			}
		}
	}

	/**
	 * Deactivates a User in the UserList by setting its active status to false.
	 *
	 * @param userId The id of the User to be deactivated.
	 */

	@Override
	public void delete(int userId) {
		Set<User> userList = UserList.listOfUsers;
		for (User user : userList) {
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

	@Override
	public User findById(int userId) {
		Set<User> userList = UserList.listOfUsers;
		User userMatch = null;

		for (User user : userList) {
			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated metho
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
	}
}