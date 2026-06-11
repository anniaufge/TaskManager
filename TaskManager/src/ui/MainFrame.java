package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.*;
import command.*;
import observer.IObserver;
import observer.TaskLogger;
import strategy.*;

public class MainFrame  extends JFrame implements IObserver {
	private Project project;
	private CommandManager commandManager;
	private JTable taskTable;
	private DefaultTableModel tableModel;
	
	 public MainFrame() {
		 project = new Project("My Project");
		 commandManager = new CommandManager();
		 
		 // register as observer
		 project.attach(this);
		 project.attach(new TaskLogger(project));
		 
		 setTitle("TaskManager");
		 setSize(900, 600);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLocationRelativeTo(null);
		 setLayout(new BorderLayout());
		 
		 add(createToolbar(), BorderLayout.NORTH);
		 add(createTaskTable(), BorderLayout.CENTER);
		 
		 getContentPane().setBackground(Color.decode("#E8E4ED"));
		 
	
	 }
	 
	 private JPanel createToolbar() {
		 JPanel toolbar = new JPanel (new FlowLayout(FlowLayout.LEFT));
		 
		 toolbar.setBackground(Color.decode("#C9C2D1"));
		 
		 JButton addBtn = new JButton("Add Task");
		 JButton forwardBtn = new JButton("Forward");
		 JButton backBtn = new JButton("Back");
		 JButton deleteBtn = new JButton("Delete");
		 JButton undoBtn = new JButton("Undo");
		 JButton redoBtn = new JButton("Redo");
		 
		 addBtn.addActionListener(e -> openAddTaskDialog());
		 forwardBtn.addActionListener(e -> moveSelectedForward());
		 backBtn.addActionListener(e -> moveSelectedBack());
		 deleteBtn.addActionListener(e -> deleteSelectedTask());
		 undoBtn.addActionListener(e -> {
			 commandManager.undo();
			 update();
		 });
		 redoBtn.addActionListener(e -> {
			 commandManager.redo();
			 update();
		 });
		 
		 toolbar.add(addBtn);
		 toolbar.add(forwardBtn);
		 toolbar.add(backBtn);
		 toolbar.add(deleteBtn);
		 toolbar.add(Box.createHorizontalStrut(20));
		 toolbar.add(undoBtn);
		 toolbar.add(redoBtn);
		 toolbar.add(Box.createHorizontalStrut(20));
		 
		 toolbar.add(new JLabel("Sort by: "));
		 JComboBox<String> sortDropdown = new JComboBox<>(new String[] {
				 "None", "Priority", "Deadline", "Status"
		 });
		 
		 sortDropdown.addActionListener(e -> {
			 String selected = (String) sortDropdown.getSelectedItem();
			 switch (selected) {
			 case "Priority": project.setSortStrategy(new PrioritySortStrategy()); break;
			 case "Deadline": project.setSortStrategy(new DeadlineSortStrategy()); break;
			 case "Status": project.setSortStrategy(new StatusSortStrategy()); break;
			 default: project.setSortStrategy(null); break;
			 }
			 update();
		 });
		 toolbar.add(sortDropdown);
		 
		 return toolbar;
	 }
	 
	 private JScrollPane createTaskTable() {
		 String[] columns = {"Title", "Type", "Priority", "Status", "Deadline"};
		 tableModel = new DefaultTableModel(columns, 0) {
			 @Override
			 public boolean isCellEditable(int row, int column) {
				 return false;
			 }
		 };
		 
		 taskTable = new JTable(tableModel);
		 
		 taskTable.getTableHeader().setBackground(Color.decode("#B5ADBF"));
		 taskTable.setBackground(Color.decode("#F0EDF3"));
		 
		 return new JScrollPane(taskTable);
	 }
	 
	 private void openAddTaskDialog() {
		 TaskFormDialog dialog = new TaskFormDialog(this, project, commandManager);
		 dialog.setVisible(true);
	 }
	 
	 private void moveSelectedForward() {
		 int row = taskTable.getSelectedRow();
		 if (row >= 0) {
			 Task task = project.getTasks().get(row);
			 commandManager.executeCommand(new ChangeStateCommand(task));
			 update();
		 }
	 }
	 
	 private void moveSelectedBack() {
		 int row = taskTable.getSelectedRow();
		 if (row >= 0) {
			 Task task = project.getTasks().get(row);
			 commandManager.executeCommand(new ChangeStateCommand(task, false));
			 update();
		 }
	 }
	 
	 private void deleteSelectedTask() {
		 int row = taskTable.getSelectedRow();
		 if (row >= 0) {
			 Task task = project.getTasks().get(row);
			 commandManager.executeCommand(new DeleteTaskCommand(project, task));
		 }
	 }
	 
	 @Override
	 public void update() {
		 tableModel.setRowCount(0);
		 for (Task task : project.getTasks()) {
			 tableModel.addRow(new Object[] {
					 task.getTitle(),
					 task.getType(),
					 task.getPriority(),
					 task.getState().getStatus(),
					 task.getDeadline()
			 });
		 }
	 }
}


