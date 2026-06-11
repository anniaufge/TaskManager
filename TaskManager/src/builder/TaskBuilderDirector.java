package builder;

import model.Task;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;

public class TaskBuilderDirector {
	private ITaskBuilder builder;
	
	public TaskBuilderDirector(ITaskBuilder builder) {
		this.builder = builder;
	}
	
	public void setBuilder(ITaskBuilder builder) {
		this.builder = builder;
	}
	
	public Task construct(String title, String description, Priority priority, TaskType type, LocalDate deadline) {
		return builder
			.buildTitle(title)
			.buildDescription(description)
			.buildPriority(priority)
			.buildType(type)
			.buildDeadline(deadline)
			.getTask();
	}

}
