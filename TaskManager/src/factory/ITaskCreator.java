package factory;

import model.Task;

public interface ITaskCreator {
	Task createTask(String title, String description);

}
