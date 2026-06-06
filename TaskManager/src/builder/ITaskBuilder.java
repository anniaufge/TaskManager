package builder;

import model.Task;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;

public interface ITaskBuilder {
	ITaskBuilder buildTitle(String title);
	ITaskBuilder buildDescription(String description);
	ITaskBuilder buildPriority(Priority priority);
	ITaskBuilder buildType(TaskType type);
	ITaskBuilder buildDeadline(LocalDate deadline);
	Task getTask();

}
