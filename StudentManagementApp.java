import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentManagementApp {
    private StudentManagementSystem sms;
    private JFrame frame;
    private JTextArea textArea;
    private JTextField nameField, rollNumberField, gradeField, additionalDetailsField;
    
    public StudentManagementApp() {
        sms = new StudentManagementSystem();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create the GUI components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel("Roll Number:"));
        rollNumberField = new JTextField();
        panel.add(rollNumberField);
        
        panel.add(new JLabel("Grade:"));
        gradeField = new JTextField();
        panel.add(gradeField);
        
        panel.add(new JLabel("Additional Details:"));
        additionalDetailsField = new JTextField();
        panel.add(additionalDetailsField);

        JButton addButton = new JButton("Add Student");
        JButton removeButton = new JButton("Remove Student");
        JButton searchButton = new JButton("Search Student");
        JButton displayButton = new JButton("Display All Students");

        panel.add(addButton);
        panel.add(removeButton);
        panel.add(searchButton);
        panel.add(displayButton);
        
        // Text area for displaying results
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add button action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllStudents();
            }
        });

        frame.setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText().trim();
        String rollNumber = rollNumberField.getText().trim();
        String grade = gradeField.getText().trim();
        String additionalDetails = additionalDetailsField.getText().trim();

        if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name, Roll Number, and Grade are required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = new Student(name, rollNumber, grade, additionalDetails);
        sms.addStudent(student);
        clearFields();
        JOptionPane.showMessageDialog(frame, "Student added successfully.");
    }

    private void removeStudent() {
        String rollNumber = rollNumberField.getText().trim();
        if (rollNumber.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Roll Number is required to remove a student.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean removed = sms.removeStudent(rollNumber);
        clearFields();
        if (removed) {
            JOptionPane.showMessageDialog(frame, "Student removed successfully.");
        } else {
            JOptionPane.showMessageDialog(frame, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchStudent() {
        String rollNumber = rollNumberField.getText().trim();
        if (rollNumber.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Roll Number is required to search for a student.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            textArea.setText(student.toString());
        } else {
            textArea.setText("Student not found.");
        }
    }

    private void displayAllStudents() {
        List<Student> students = sms.getAllStudents();
        if (students.isEmpty()) {
            textArea.setText("No students found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Student student : students) {
                sb.append(student).append("\n");
            }
            textArea.setText(sb.toString());
        }
    }

    private void clearFields() {
        nameField.setText("");
        rollNumberField.setText("");
        gradeField.setText("");
        additionalDetailsField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementApp());
    }
}