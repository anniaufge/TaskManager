package strategy;

import java.util.List;
import java.util.ArrayList;
import model.Task;

public class StatusSortStrategy implements ISortStrategy {

	@Override
	public List<Task> sort(List<Task> tasks) {
		List<Task> sorted = new ArrayList<>(tasks);
		sorted.sort((a, b) -> order(a) - order(b));
		return sorted;
	}

	private int order(Task task) {
		switch (task.getState().getStatus()) {
			case "TODO":        return 0;
			case "IN_PROGRESS": return 1;
			case "IN_REVIEW":   return 2;
			case "DONE":        return 3;
			default:            return 0;
		}
	}

}
