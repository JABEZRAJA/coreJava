package in.jabezraja.captain.interfaces;

import java.util.Set;

import in.jabezraja.captain.model.Task;

public interface TaskInterface extends Base {
	public abstract Set<Task> findAll();

	public abstract void create(Task newTask);

	public abstract Task findById(int id);

	public abstract void update(Task updatedTask);

	public abstract void delete(int TaskId);
}
