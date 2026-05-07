package strategy;

import java.util.List;
import java.util.ArrayList;
import model.Task;

public class StatusSortStrategy implements ISortStrategy {

	@Override
	public List<Task> sort(List<Task> tasks) {
		List<Task> sorted = new ArrayList<>(tasks);
		sorted.sort((a, b) -> a.getState().getStatus().compareTo(b.getState().getStatus()));
		return sorted;
	}

}
