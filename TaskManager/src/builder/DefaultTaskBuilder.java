package builder;

import java.time.LocalDate;

import model.Priority;
import model.Task;
import model.TaskType;

public class DefaultTaskBuilder implements ITaskBuilder {
	private String title;
	private String description;
	private Priority priority;
	private TaskType type;
	private LocalDate deadline;
	
	public DefaultTaskBuilder() {
		this.title = "";
		this.description = "";
		this.priority = Priority.MEDIUM;
		this.type = TaskType.TASK;
		this.deadline = LocalDate.now().plusDays(7);
	}

	@Override
	public ITaskBuilder buildTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public ITaskBuilder buildDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public ITaskBuilder buildPriority(Priority priority) {
		this.priority = priority;
		return this;
	}

	@Override
	public ITaskBuilder buildType(TaskType type) {
		this.type = type;
		return this;
	}

	@Override
	public ITaskBuilder buildDeadline(LocalDate deadline) {
		this.deadline = deadline;
		return this;
	}

	@Override
	public Task getTask() {
		return new Task(title, description, priority, type, deadline);
	}

}
