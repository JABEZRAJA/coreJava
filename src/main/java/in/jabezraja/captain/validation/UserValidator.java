package in.jabezraja.captain.validation;

import in.jabezraja.captain.exception.ValidationException;
import in.jabezraja.captain.model.User;
import in.jabezraja.captain.util.StringUtil;

public class UserValidator {

	public static void validate(User user) throws ValidationException {

		if (user == null) {
			throw new ValidationException("Invalid user input");
		}
		// if (user.getEmail() == null || "".equals(user.getEmail().trim())) {
		// throw new ValidationException("Email can't be null or empty");
		// }
		StringUtil.rejectIfInvalidString(user.getEmail(), "Email");
		// if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
		// throw new ValidationException("Password can't be null or empty");
		// }
		StringUtil.rejectIfInvalidString(user.getPassword(), "Password");
		// if (user.getFirstName() == null || "".equals(user.getFirstName().trim())) {
		// throw new ValidationException("Firstname can't be null or empty");
		// }
		StringUtil.rejectIfInvalidString(user.getFirstName(), "FirstName");
	}
}
