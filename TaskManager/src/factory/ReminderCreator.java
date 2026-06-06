package factory;

import model.Task;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;

public class ReminderCreator implements ITaskCreator {

	@Override
	public Task createTask(String title, String description) {
		return new Task(title, description, Priority.LOW, TaskType.REMINDER, LocalDate.now().plusDays(3));
		
	}

}
