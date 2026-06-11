package ui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import model.*;
import command.*;
import builder.DefaultTaskBuilder;
import builder.TaskBuilderDirector;

public class TaskFormDialog extends JDialog {
    private JTextField titleField;
    private JTextField descriptionField;
    private JComboBox<TaskType> typeDropdown;
    private JComboBox<Priority> priorityDropdown;
    private JTextField deadlineField;

    public TaskFormDialog(MainFrame parent, Project project, CommandManager commandManager) {
        super(parent, "Add Task", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Description:"));
        descriptionField = new JTextField();
        add(descriptionField);

        add(new JLabel("Type:"));
        typeDropdown = new JComboBox<>(TaskType.values());
        add(typeDropdown);

        add(new JLabel("Priority:"));
        priorityDropdown = new JComboBox<>(Priority.values());
        add(priorityDropdown);

        add(new JLabel("Deadline (YYYY-MM-DD):"));
        deadlineField = new JTextField();
        add(deadlineField);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dispose());

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            String title = titleField.getText();
            String description = descriptionField.getText();
            TaskType type = (TaskType) typeDropdown.getSelectedItem();
            Priority priority = (Priority) priorityDropdown.getSelectedItem();
            LocalDate deadline;
            try {
                deadline = LocalDate.parse(deadlineField.getText());
            } catch (Exception ex) {
                deadline = LocalDate.now().plusDays(7);
            }

            TaskBuilderDirector director = new TaskBuilderDirector(new DefaultTaskBuilder());
            Task task = director.construct(title, description, priority, type, deadline);
            commandManager.executeCommand(new CreateTaskCommand(project, task));
            dispose();
        });

        add(cancelBtn);
        add(addBtn);
    }
}