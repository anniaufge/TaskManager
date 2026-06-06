package factory;

import model.Task;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;

public class TaskCreator implements ITaskCreator {

	@Override
	public Task createTask(String title, String description) {
		return new Task(title, description, Priority.MEDIUM, TaskType.TASK, LocalDate.now().plusDays(7));
	}

}
