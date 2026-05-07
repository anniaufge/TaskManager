package model;

import java.util.ArrayList;
import java.util.List;
import strategy.ISortStrategy;

public class Project {
	private String name;
	private List<Task> tasks;
	private ISortStrategy sortStrategy;
	
	public Project(String name) {
		this.name = name;
		this.tasks = new ArrayList<>();
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public void removeTask(Task task) {
		tasks.remove(task);
	}
	
	public List<Task> getTasks() {
		if (sortStrategy != null) {
			return sortStrategy.sort(tasks);
		}
		return new ArrayList<>(tasks);
	}
	
	public void setSortStrategy(ISortStrategy sortStrategy) {
		this.sortStrategy = sortStrategy;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getTaskCount() { return tasks.size(); }
	
}
