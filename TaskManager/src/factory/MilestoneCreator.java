package factory;

import model.Task;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;

public class MilestoneCreator implements ITaskCreator {

	@Override
	public Task createTask(String title, String description) {
		return new Task(title, description, Priority.CRITICAL, TaskType.MILESTONE, LocalDate.now().plusDays(30));
	}

}
