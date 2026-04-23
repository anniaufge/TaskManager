package model;

import java.time.LocalDate;

public class Task {
	private String title;
	private String description;
	private Priority priority;
	private TaskType type;
	private String status;
	private LocalDate deadline;
	
	public Task(String title, String description, Priority priority, TaskType type, LocalDate deadline) {
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.type = type;
		this.status = "TODO";
		this.deadline = deadline;
	}

	// getters
	public String getTitle() { return title; }
	public String getDescription() { return description; }
	public Priority getPriority() { return priority; }
	public TaskType getType() { return type; }
	public String getStatus() { return status; }
	public LocalDate getDeadline() { return deadline; }
	
	// setters
	public void setTitle(String title) { this.title = title; }
	public void setDescription(String description) { this.description = description; }
	public void setPriority(Priority priority) { this.priority = priority; }
	public void setType(TaskType type) {this.type = type; }
	public void setStatus(String status) { this.status = status; }
	public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
	
	@Override
	public String toString() {
		return title + " {" + type + "] - " + priority + " - " + status;
	}
}