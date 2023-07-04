package in.jabezraja.captain.dao;

import in.jabezraja.captain.model.Task;

public class TaskDAO {

	/**
	 * Returns all Tasks in the TaskList.
	 *
	 * @return An array of all Task objects in the TaskList.
	 */
	public Task[] findAll() {
		Task[] tasklist = TaskList.listOfTask;
		return tasklist;
	}

	/**
	 * Adds a new Task to the first available slot in TaskList. Prints a success
	 * message if successful, or a failure message otherwise.
	 *
	 * @param newTask The Task to be added to the TaskList.
	 */

	public void create(Task newTask) {

		Task[] arr = TaskList.listOfTask;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
			if (task == null) {
				arr[i] = newTask;
				break;
			}
		}
	}

	/**
	 * Replaces a Task in the TaskList with updatedTask, matching by taskId.
	 *
	 * @param updatedTask The Task with updated information.
	 */

	public void update(int id, Task updateTask) {
		Task[] arr = TaskList.listOfTask;

		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];
			if (task == null) {
				continue;
			}
			if (task.getId() == id) {
				arr[i].setName(updateTask.getName());
				arr[i].setDueDate(updateTask.getDueDate());
			}
		}
	}

	/**
	 * Deactivates a Task in the TaskList by setting its active status to false.
	 *
	 * @param taskId The id of the Task to be deactivated.
	 */

	public void delete(int taskId) {
		Task[] arr = TaskList.listOfTask;
		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];

			if (task == null) {
				continue;
			}

			if (task.getId() == taskId) {
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

	public Task findById(int taskId) {
		Task[] arr = TaskList.listOfTask;
		Task taskMatch = null;

		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];

			if (task.getId() == taskId) {
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}
}
