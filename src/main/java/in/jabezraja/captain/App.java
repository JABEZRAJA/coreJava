package in.jabezraja.captain;

import in.jabezraja.captain.service.Userservice;

public class App {

	public static void main(String[] args) {
		Userservice userService = new Userservice();

		userService.getAll();
	}

}
