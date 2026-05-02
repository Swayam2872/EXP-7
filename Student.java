import java.io.Serializable;

public class Student {
    int studentId;
    String name;
    String branch;
    int marks1, marks2, marks3, marks4, marks5;
    double percentage;

    public Student(int studentId, String name, String branch,
                   int m1, int m2, int m3, int m4, int m5) {
        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.marks4 = m4;
        this.marks5 = m5;
        this.percentage = 0;
    }

    // Calculate percentage
    public void calculatePercentage() {
        int total = marks1 + marks2 + marks3 + marks4 + marks5;
        percentage = total / 5.0;
    }

    // Convert object → CSV format
    public String toCSV() {
        return studentId + "," + name + "," + branch + "," +
               marks1 + "," + marks2 + "," + marks3 + "," +
               marks4 + "," + marks5 + "," + percentage;
    }
}