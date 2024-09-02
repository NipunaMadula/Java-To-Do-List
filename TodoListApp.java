import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListApp {
    private JFrame frame;
    private JTextField taskInput;

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

        // Add components to the panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        inputPanel.add(completeButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        // Set the frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoListApp::new);
    }
}
