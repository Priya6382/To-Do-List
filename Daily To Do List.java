import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp {
    private DefaultListModel<String> toDoListModel;
    private JList<String> toDoList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListApp app = new ToDoListApp();
            app.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create components
        JLabel titleLabel = new JLabel("To-Do List");
        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        toDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(toDoListModel);
        JButton completeButton = new JButton("Mark as Completed");
        JButton removeButton = new JButton("Remove Task");

        // Set layout manager
        frame.setLayout(new BorderLayout());

        // Add components to the frame
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(new JScrollPane(toDoList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(completeButton);
        inputPanel.add(removeButton);

        frame.add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask(taskField.getText());
                taskField.setText("");
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markAsCompleted();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    private void addTask(String task) {
        if (!task.isEmpty()) {
            toDoListModel.addElement(task);
        }
    }

    private void markAsCompleted() {
        int selectedIndex = toDoList.getSelectedIndex();
        if (selectedIndex != -1) {
            // Add logic to mark the task as completed
            // For simplicity, we remove the task from the list
            toDoListModel.remove(selectedIndex);
        }
    }

    private void removeTask() {
        int selectedIndex = toDoList.getSelectedIndex();
        if (selectedIndex != -1) {
            toDoListModel.remove(selectedIndex);
        }
    }
}
