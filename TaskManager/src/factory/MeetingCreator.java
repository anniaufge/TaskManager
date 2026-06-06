package factory;

import model.Task;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;

public class MeetingCreator implements ITaskCreator {

	@Override
	public Task createTask(String title, String description) {
		return new Task(title, description, Priority.MEDIUM, TaskType.MEETING, LocalDate.now().plusDays(1));
	}

}
