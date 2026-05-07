package strategy;

import java.util.List;
import model.Task;

public interface ISortStrategy {
	List<Task> sort(List<Task> tasks);
}
