import java.io.*;
import java.util.*;

public class StudentMain {

    static String fileName = "Students.csv";

    public static void main(String[] args) {

        try {
            createFile();
            addStudents();
            updateMarks();
            calculatePercentage();
            deleteStudent(3);
            displayFile();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // Exception Demo
        try {
            FileReader fr = new FileReader("NoFile.csv");
        } catch (IOException e) {
            System.out.println("Exception Example: " + e);
        }
    }

    // CREATE
    static void createFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        bw.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");

        Student s1 = new Student(1, "Rahul", "CS", 80, 85, 90, 0, 0);
        Student s2 = new Student(2, "Anjali", "IT", 75, 70, 80, 0, 0);

        bw.write(s1.toCSV() + "\n");
        bw.write(s2.toCSV() + "\n");

        bw.close();
        System.out.println("File created.");
    }

    // ADD
    static void addStudents() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        Student s3 = new Student(3, "Amit", "CS", 60, 65, 70, 0, 0);
        Student s4 = new Student(4, "Priya", "IT", 88, 90, 85, 0, 0);
        Student s5 = new Student(5, "Rohan", "CS", 78, 82, 80, 0, 0);

        bw.write(s3.toCSV() + "\n");
        bw.write(s4.toCSV() + "\n");
        bw.write(s5.toCSV() + "\n");

        bw.close();
        System.out.println("Students added.");
    }

    // UPDATE marks4 & marks5
    static void updateMarks() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!data[0].equals("studentId")) {
                data[6] = "85";
                data[7] = "90";
                line = String.join(",", data);
            }
            lines.add(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) bw.write(l + "\n");
        bw.close();

        System.out.println("Marks updated.");
    }

    // CALCULATE PERCENTAGE
    static void calculatePercentage() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!data[0].equals("studentId")) {
                int total = 0;
                for (int i = 3; i <= 7; i++) {
                    total += Integer.parseInt(data[i]);
                }
                double percentage = total / 5.0;
                data[8] = String.valueOf(percentage);

                line = String.join(",", data);
            }
            lines.add(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) bw.write(l + "\n");
        bw.close();

        System.out.println("Percentage updated.");
    }

    // DELETE
    static void deleteStudent(int id) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith(id + ",")) {
                lines.add(line);
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String l : lines) bw.write(l + "\n");
        bw.close();

        System.out.println("Student deleted.");
    }

    // READ
    static void displayFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        System.out.println("\nFinal Data:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}