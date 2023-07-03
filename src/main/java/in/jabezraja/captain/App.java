package in.jabezraja.captain;

import in.jabezraja.captain.model.User;
import in.jabezraja.captain.service.Userservice;

public class App {

	public static void main(String[] args) {
		Userservice userService = new Userservice();

		User newUser = new User();
		newUser.setId(001);
		newUser.setFirstName("King");
		newUser.setLastName("JR");
		newUser.setEmail("jabezking777@gmail.com");
		newUser.setPassword("jjjbro777");
		newUser.setActive(true);

		userService.create(newUser);
		userService.update();
		userService.getAll();
	}

}
