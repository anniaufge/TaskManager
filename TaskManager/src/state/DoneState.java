package state;

import model.Task;

public class DoneState implements ITaskState {

	@Override
	public void next(Task task) {
		System.out.println("Already at final state.");
	}

	@Override
	public void previous(Task task) {
		task.setState(new InReviewState());
	}

	@Override
	public String getStatus() {
		return "DONE";
	}
}
