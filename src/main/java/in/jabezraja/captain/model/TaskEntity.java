package in.jabezraja.captain.model;

public class TaskEntity implements Comparable<TaskEntity> {
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", dueDate=" + dueDate + ", isActive=" + isActive + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	int id;
	String name;
	String dueDate;
	boolean isActive = true;

	@Override
	public int compareTo(TaskEntity o) {
		return Integer.compare(this.id, o.getId());
	}
}
