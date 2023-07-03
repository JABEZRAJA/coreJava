package in.jabezraja.captain.validation;

import in.jabezraja.captain.model.User;

public class UserValidator {

	public static boolean validate(User user) throws Exception {

		if (user == null) {
			throw new Exception("Invalid user input.");
		}
		if (user.getEmail() == null || "".equals(user.getEmail().trim())) {
			throw new Exception("Email can't be null or empty.");
		}
		if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
			throw new Exception("Password can't be null or empty.");
		}
		if (user.getFirstName() == null || "".equals(user.getFirstName().trim())) {
			throw new Exception("Firstname can't be null or empty.");
		}
		return false;
	}
}
