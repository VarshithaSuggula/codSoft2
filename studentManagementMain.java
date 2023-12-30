import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNumber=" + rollNumber + ", grade=" + grade + "]";
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found with roll number: " + rollNumber);
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:\n" + student);
                return;
            }
        }
        System.out.println("Student not found with roll number: " + rollNumber);
    }

    public void displayAllStudents() {
        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class studentManagementMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = sc.nextInt();
                    System.out.print("Enter grade: ");
                    String grade = sc.next();

                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter roll number of the student to remove: ");
                    int removeRollNumber = sc.nextInt();
                    system.removeStudent(removeRollNumber);
                    break;

                case 3:
                    System.out.print("Enter roll number of the student to search: ");
                    int searchRollNumber = sc.nextInt();
                    system.searchStudent(searchRollNumber);
                    break;

                case 4:
                    system.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
