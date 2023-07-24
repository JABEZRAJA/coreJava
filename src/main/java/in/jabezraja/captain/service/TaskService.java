package in.jabezraja.captain.service;

import java.time.format.DateTimeParseException;
import java.util.Set;

import in.jabezraja.captain.dao.TaskDAO;
import in.jabezraja.captain.exception.ValidationException;
import in.jabezraja.captain.model.Task;
import in.jabezraja.captain.validation.TaskValidator;

public class TaskService {
	public Set<Task> getAll() {
		TaskDAO taskDao = new TaskDAO();
		Set<Task> taskList = taskDao.findAll();
		for (Task task : taskList) {
			System.out.println(task);
		}
		return taskList;

	}

	public void create(Task newTask) throws Exception {
		try {
			TaskValidator.validate(newTask);
		} catch (DateTimeParseException e) {
			throw new ValidationException("Invalid date format or Invalid Date");
		}

		TaskValidator.validate(newTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.create(newTask);
	}

	public void update(Task updateTask) throws Exception {
		TaskValidator.validate(updateTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.update(updateTask);
	}

	public void delete(int taskId) {
		TaskDAO taskDao = new TaskDAO();
		taskDao.delete(1);
	}

	public Task findById(int taskId) {
		TaskDAO taskDao = new TaskDAO();
		Task task = taskDao.findById(1);
		return task;
	}
}