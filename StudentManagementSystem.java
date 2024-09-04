import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(String rollNumber) {
        Optional<Student> studentToRemove = students.stream()
                .filter(student -> student.getRollNumber().equals(rollNumber))
                .findFirst();
        
        if (studentToRemove.isPresent()) {
            students.remove(studentToRemove.get());
            return true;
        }
        return false;
    }

    public Student searchStudent(String rollNumber) {
        return students.stream()
                .filter(student -> student.getRollNumber().equals(rollNumber))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return students;
    }
}