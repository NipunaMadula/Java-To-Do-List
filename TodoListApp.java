import javax.swing.*;
import java.awt.*;

public class TodoListApp {
    private JFrame frame;

    public TodoListApp() {
        // Create the main frame
        frame = new JFrame("To-Do List Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        // Set the frame visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoListApp::new);
    }
}
