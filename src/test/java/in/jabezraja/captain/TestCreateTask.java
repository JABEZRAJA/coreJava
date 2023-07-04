package in.jabezraja.captain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.jabezraja.captain.exception.ValidationException;
import in.jabezraja.captain.model.Task;
import in.jabezraja.captain.service.TaskService;

public class TestCreateTask {

	@Test
	public void testCreateTaskWithValidInput() {
		TaskService taskService = new TaskService();

		Task newTask = new Task();
		newTask.setId(1);
		newTask.setName("King");
		newTask.setDueDate("04-07-2023");
		newTask.setActive(true);

		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});
	}

	@Test
	public void testCreateTaskWithInvalidInput() throws Exception {

		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String exceptedMessage = "Invalid task input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithDueDateNull() throws Exception {

		TaskService taskService = new TaskService();

		Task newTask = new Task();
		newTask.setId(3);
		newTask.setName("King");
		newTask.setDueDate(null);
		newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String exceptedMessage = "DueDate cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithDueDateEmpty() throws Exception {

		TaskService taskService = new TaskService();

		Task newTask = new Task();
		newTask.setId(3);
		newTask.setName("King");
		newTask.setDueDate("");
		newTask.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String exceptedMessage = "DueDate cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithNameNull() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(1);
		newTask.setName(null);
		newTask.setDueDate("04-07-2023");
		newTask.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "Name cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithNameEmpty() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(1);
		newTask.setName("");
		newTask.setDueDate("04-07-2023");
		newTask.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "Name cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

}