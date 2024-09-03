import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListApp {
    private JFrame frame;
    private JTextField taskInput;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public TodoListApp() {
        // Create the main frame
        frame = new JFrame("To-Do List Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        // Task input field and buttons
        taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Mark Complete");

        // Task list model and JList
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add components to the panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        inputPanel.add(completeButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Add ActionListeners
        addButton.addActionListener(new AddTaskListener());
        deleteButton.addActionListener(new DeleteTaskListener());
        completeButton.addActionListener(new CompleteTaskListener());
 
        // Set the frame visibility
        frame.setVisible(true);
    }

    private class AddTaskListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        }
    }

    private class DeleteTaskListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        }
    }

    private class CompleteTaskListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String task = taskListModel.getElementAt(selectedIndex);
                taskListModel.set(selectedIndex, task + " (Completed)");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoListApp::new);
    }
}
