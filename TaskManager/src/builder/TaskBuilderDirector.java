package builder;

import model.Task;

public class TaskBuilderDirector {
	private ITaskBuilder builder;
	
	public TaskBuilderDirector(ITaskBuilder builder) {
		this.builder = builder;
	}
	
	public void setBuilder(ITaskBuilder builder) {
		this.builder = builder;
	}
	
	public Task construct(String title, String description) {
		return builder.buildTitle(title).buildDescription(description).getTask();
	}

}
