package command;

import model.Task;
import state.ITaskState;

public class ChangeStateBackCommand implements ICommand {
	private Task task;
	private ITaskState previousState;

	public ChangeStateBackCommand(Task task) {
		this.task = task;
	}

	@Override
	public void execute() {
		previousState = task.getState();
		task.back();
	}

	@Override
	public void undo() {
		task.setState(previousState);
	}
}
