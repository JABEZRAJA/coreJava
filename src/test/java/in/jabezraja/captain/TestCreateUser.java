package in.jabezraja.captain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.jabezraja.captain.exception.ValidationException;
import in.jabezraja.captain.model.User;
import in.jabezraja.captain.service.Userservice;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValidInput() {
		Userservice userService = new Userservice();

		User newUser = new User();
		newUser.setId(001);
		newUser.setFirstName("King");
		newUser.setLastName("JR");
		newUser.setEmail("jabezking777@gmail.com");
		newUser.setPassword("jjjbro777");
		newUser.setActive(true);

		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});
	}

	@Test
	public void testCreateUserWithInvalidInput() throws Exception {

		Userservice userService = new Userservice();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithEmailNull() throws Exception {

		Userservice userService = new Userservice();

		User newUser = new User();
		newUser.setId(3);
		newUser.setFirstName("King");
		newUser.setLastName("JR");
		newUser.setEmail(null);
		newUser.setPassword("jjjbro777");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithEmailEmpty() throws Exception {

		Userservice userService = new Userservice();

		User newUser = new User();
		newUser.setId(3);
		newUser.setFirstName("King");
		newUser.setLastName("JR");
		newUser.setEmail("");
		newUser.setPassword("jjjbro777");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
}
