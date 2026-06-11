package command;

import model.Task;
import state.ITaskState;

public class ChangeStateCommand implements ICommand {
	private Task task;
	private ITaskState previousState;
	private boolean forward;

	public ChangeStateCommand(Task task) {
		this.task = task;
		this.forward = true;
	}

	public ChangeStateCommand(Task task, boolean forward) {
		this.task = task;
		this.forward = forward;
	}

	@Override
	public void execute() {
		previousState = task.getState();
		if (forward) task.forward();
		else task.back();
	}

	@Override
	public void undo() {
		task.setState(previousState);
	}

}
