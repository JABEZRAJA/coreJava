package in.jabezraja.captain.service;

import in.jabezraja.captain.dao.TaskDAO;
import in.jabezraja.captain.model.Task;
import in.jabezraja.captain.validation.TaskValidator;

public class TaskService {
	public Task[] getAll() {

		TaskDAO taskDao = new TaskDAO();

		Task[] taskList = taskDao.findAll();

		for (int i = 0; i < taskList.length; i++) {
			System.out.println(taskList[i]);
		}
		return taskList;
	}

	public void create(Task newTask) throws Exception {
		TaskValidator.validate(newTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.create(newTask);

	}

	public void update(int id, Task updateTask) {
		// Task updateTask = new Task();
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(001, updateTask);
	}

	public void delete() {
		Task deleteTask = new Task();
		TaskDAO taskDao = new TaskDAO();
		taskDao.delete(001);
	}

	public Task findById(int id) {
		TaskDAO taskDao = new TaskDAO();
		Task task = taskDao.findById(id);
		return task;
	}
}
