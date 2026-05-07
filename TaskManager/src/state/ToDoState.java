package state;

import model.Task;

public class ToDoState implements ITaskState {

	@Override
	public void next(Task task) {
		task.setState(new InProgressState());
	}

	@Override
	public void previous(Task task) {
		System.out.println("Already at the first state");
	}

	@Override
	public String getStatus() {
		return "TODO";
	}
}