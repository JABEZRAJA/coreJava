package in.jabezraja.captain;

import in.jabezraja.captain.model.Task;
import in.jabezraja.captain.model.User;
import in.jabezraja.captain.service.TaskService;
import in.jabezraja.captain.service.Userservice;

public class App {

	public static void main(String[] args) {
		User newUser;
		TaskService taskService;
		Task newTask;
		try {
			
			/// USER ///
			
			Userservice userService = new Userservice();

			newUser = new User();
			newUser.setId(001);
			newUser.setFirstName("King");
			newUser.setLastName("JR");
			newUser.setEmail("jabezking777@gmail.com");
			newUser.setPassword("jjjbro777");
			newUser.setActive(true);

			userService.create(newUser);
			
			/// TASK ///
			
			taskService = new TaskService();

			newTask = new Task();
			newTask.setId(1);
			newTask.setName("King");
			newTask.setDueDate("05-07-2023");
			newTask.setActive(true);

			taskService.create(newTask);

			userService.getAll();
			taskService.getAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

//		 userService.update();

	}

}
