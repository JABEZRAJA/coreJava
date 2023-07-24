package in.jabezraja.captain.dao;

import java.util.Set;

import in.jabezraja.captain.interfaces.TaskInterface;
import in.jabezraja.captain.model.Task;

public class TaskDAO implements TaskInterface {

	/**
	 * Returns all Tasks in the TaskList.
	 *
	 * @return An array of all Task objects in the TaskList.
	 */

	@Override
	public Set<Task> findAll() {
		Set<Task> userTask = TaskList.listOfTasks;
		return userTask;
	}

	/**
	 * Adds a new Task to the first available slot in TaskList. Prints a success
	 * message if successful, or a failure message otherwise.
	 *
	 * @param newTask The Task to be added to the TaskList.
	 */

	@Override
	public void create(Task newTask) {
		Set<Task> taskList = TaskList.listOfTasks;
		taskList.add(newTask);

	}

	/**
	 * Replaces a Task in the TaskList with updatedTask, matching by taskId.
	 *
	 * @param updatedTask The Task with updated information.
	 */

	@Override
	public void update(Task updatedTask) {
		Set<Task> taskList = TaskList.listOfTasks;
		for (Task task : taskList) {
			if (task.getId() == updatedTask.getId()) {
				task.setName(updatedTask.getName());
				task.setDueDate(updatedTask.getDueDate());
				break;
			}
		}
	}

	/**
	 * Deactivates a Task in the TaskList by setting its active status to false.
	 *
	 * @param taskId The id of the Task to be deactivated.
	 */

	@Override
	public void delete(int TaskId) {
		Set<Task> taskList = TaskList.listOfTasks;
		for (Task task : taskList) {
			if (task == null) {
				continue;
			}
			if (task.getId() == TaskId) {
				task.setActive(false);
				break;
			}
		}
	}

	/**
	 * Finds and returns a Task from TaskList matching the given taskId.
	 *
	 * @param taskId The id of the Task to be found.
	 * @return The Task with the matching id, or null if no match is found.
	 */

	@Override
	public Task findById(int id) {
		Set<Task> taskList = TaskList.listOfTasks;
		Task taskMatch = null;

		for (Task task : taskList) {
			if (task.getId() == id) {
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}
}
