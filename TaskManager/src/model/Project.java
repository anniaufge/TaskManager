package model;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private List<Task> tasks;
	
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
		return new ArrayList<>(tasks);
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getTaskCount() { return tasks.size(); }
	
}
