package main;

import model.Task;
import model.Project;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;
import command.*;
import observer.TaskLogger;
import factory.*;
import builder.*;

public class Main {

    public static void main(String[] args) {
        Project project = new Project("Website Redesign");
        CommandManager manager = new CommandManager();

        // attach observer
        TaskLogger logger = new TaskLogger(project);
        project.attach(logger);

        // factory method pattern
        System.out.println("--- Factory Method ---");
        ITaskCreator taskCreator = new TaskCreator();
        ITaskCreator milestoneCreator = new MilestoneCreator();

        Task task1 = taskCreator.createTask("Update homepage", "Redesign hero section");
        Task task2 = milestoneCreator.createTask("Site launch", "Go live with new site");

        manager.executeCommand(new CreateTaskCommand(project, task1));
        manager.executeCommand(new CreateTaskCommand(project, task2));

        System.out.println(task1);
        System.out.println(task2);

        // builder pattern
        System.out.println("\n--- Builder ---");
        ITaskBuilder builder = new DefaultTaskBuilder();
        TaskBuilderDirector director = new TaskBuilderDirector(builder);

        Task task3 = director.construct("Fix login bug", "Users can't log in");
        System.out.println(task3);

        Task task4 = new DefaultTaskBuilder()
                .buildTitle("Team standup")
                .buildType(TaskType.MEETING)
                .buildPriority(Priority.LOW)
                .buildDeadline(LocalDate.of(2026, 6, 1))
                .getTask();
        System.out.println(task4);

        // state pattern
        System.out.println("\n--- State ---");
        task1.forward();
        System.out.println(task1);

        // undo
        System.out.println("\n--- Undo ---");
        manager.undo();
        System.out.println("Tasks after undo: " + project.getTaskCount());
    }
}