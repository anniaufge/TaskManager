package state;

import model.Task;

public interface ITaskState {
	void next(Task task);
	void previous(Task task);
	String getStatus();
}
