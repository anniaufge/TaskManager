package model;

import java.time.LocalDate;
import state.ITaskState;
import state.ToDoState;

public class Task {
	private String title;
	private String description;
	private Priority priority;
	private TaskType type;
	private ITaskState state;
	private LocalDate deadline;
	
	public Task(String title, String description, Priority priority, TaskType type, LocalDate deadline) {
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.type = type;
		this.state = new ToDoState();
		this.deadline = deadline;
	}

	// getters
	public String getTitle() { return title; }
	public String getDescription() { return description; }
	public Priority getPriority() { return priority; }
	public TaskType getType() { return type; }
	public ITaskState getState() { return state; }
	public LocalDate getDeadline() { return deadline; }
	
	// setters
	public void setTitle(String title) { this.title = title; }
	public void setDescription(String description) { this.description = description; }
	public void setPriority(Priority priority) { this.priority = priority; }
	public void setType(TaskType type) {this.type = type; }
	public void setState(ITaskState state) { this.state = state; }
	public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
	
	public void forward() { state.next(this); }
	public void back() { state.previous(this); }
	
	@Override
	public String toString() {
		return title + " [" + type + "] - " + priority + " - " + state.getStatus();
	}
}