package strategy;

import java.util.List;
import java.util.ArrayList;
import model.Task;

public class PrioritySortStrategy implements ISortStrategy {

	@Override
	public List<Task> sort(List<Task> tasks) {
		List<Task> sorted = new ArrayList<>(tasks);
		sorted.sort((a, b) -> b.getPriority().ordinal() - a.getPriority().ordinal());
		return sorted;
	}
}
