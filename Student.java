public class Student {
    private String name;
    private String rollNumber;
    private String grade;
    private String additionalDetails;

    public Student(String name, String rollNumber, String grade, String additionalDetails) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.additionalDetails = additionalDetails;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getAdditionalDetails() { return additionalDetails; }
    public void setAdditionalDetails(String additionalDetails) { this.additionalDetails = additionalDetails; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", grade='" + grade + '\'' +
                ", additionalDetails='" + additionalDetails + '\'' +
                '}';
    }
}