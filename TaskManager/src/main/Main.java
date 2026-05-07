package main;

import model.Task;
import model.Project;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;
import strategy.PrioritySortStrategy;
import strategy.DeadlineSortStrategy;

public class Main {

	public static void main(String[] args) {
		Project project = new Project("Website Redesign");
		
		Task task1 = new Task("Update homepage", "Redesign hero section", Priority.HIGH, TaskType.TASK, LocalDate.of(2026, 5, 10));
		Task task2 = new Task("Fix bug", "Login not working", Priority.CRITICAL, TaskType.TASK, LocalDate.of(2026, 5, 5));
		Task task3 = new Task("Launch website", "Go live", Priority.LOW, TaskType.MILESTONE, LocalDate.of(2026, 6, 15));
		
		project.addTask(task1);
		project.addTask(task2);
		project.addTask(task3);
		
		// testing state pattern
		System.out.println("--- State Pattern ---");
		System.out.println(task1);
		task1.forward();
		System.out.println(task1);
		
		// testing strategy pattern (sorted by priority)
		System.out.println("\n--- Sort by Priority ---");
		project.setSortStrategy(new PrioritySortStrategy());
		for (Task task : project.getTasks()) {
			System.out.println(task);
		}
		
		// testing strategy pattern (sorted by deadline)
		System.out.println("\n--- Sort By Deadline ---");
		project.setSortStrategy(new DeadlineSortStrategy());
		for (Task task : project.getTasks()) {
			System.out.println(task);
		}
		
	}
}