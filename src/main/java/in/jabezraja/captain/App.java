package in.jabezraja.captain;

import in.jabezraja.captain.model.Task;
import in.jabezraja.captain.model.User;
import in.jabezraja.captain.service.TaskService;
import in.jabezraja.captain.service.Userservice;

public class App {

	public static void main(String[] args) {
		try {
			TaskService taskService = new TaskService();
			Task newTask = new Task();
			newTask.setId(123);
			newTask.setDueDate("14-12-2024");
			newTask.setName("Task Management");
			newTask.setActive(true);

			taskService.create(newTask);
			taskService.getAll();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}