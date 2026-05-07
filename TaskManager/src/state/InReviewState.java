package state;

import model.Task;

public class InReviewState implements ITaskState {

	@Override
	public void next(Task task) {
		task.setState(new DoneState());
	}

	@Override
	public void previous(Task task) {
		task.setState(new InProgressState());
	}

	@Override
	public String getStatus() {
		return "IN_REVIEW";
	}
}
