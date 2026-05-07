package state;

import model.Task;

public class InProgressState implements ITaskState {

	@Override
	public void next(Task task) {
		task.setState(new InReviewState());

	}

	@Override
	public void previous(Task task) {
		task.setState(new ToDoState());

	}

	@Override
	public String getStatus() {
		return "IN_PROGRESS";
	}

}
