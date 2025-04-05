import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        StudentManager studentManager = new StudentManager(dbManager);
        ClassManager classManager = new ClassManager(dbManager);
        AuthManager authManager = new AuthManager(dbManager);


        ConsoleUI ui = new ConsoleUI(studentManager, classManager, authManager);
        ui.start();
    }
}


class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/universityms", "username", "password");
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

// Student class representing the Student table
class Student {
    private int studentID;
    private String name;
    private int age;
    private String email;
    private double gpa;

    public Student(int studentID, String name, int age, String email, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
    }

    // Getters and setters
    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Student{ID=" + studentID + ", name='" + name + "', age=" + age +
                ", email='" + email + "', gpa=" + gpa + "}";
    }
}


class Class {
    private int classID;
    private String description;
    private int numberOfCredits;

    public Class(int classID, String description, int numberOfCredits) {
        this.classID = classID;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    public static void forName(String s) {
        
    }

    // Getters and setters
    public int getClassID() { return classID; }
    public void setClassID(int classID) { this.classID = classID; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getNumberOfCredits() { return numberOfCredits; }
    public void setNumberOfCredits(int numberOfCredits) { this.numberOfCredits = numberOfCredits; }

    @Override
    public String toString() {
        return "Class{ID=" + classID + ", description='" + description +
                "', credits=" + numberOfCredits + "}";
    }
}


class StudentManager {
    private DatabaseManager dbManager;

    public StudentManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO Student (StudentID, name, age, email, gpa) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, student.getStudentID());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getEmail());
            stmt.setDouble(5, student.getGpa());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }

    public Student getStudentById(int studentID) {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, studentID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("StudentID"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getDouble("gpa")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error getting student: " + e.getMessage());
        }
        return null;
    }

    public boolean updateStudent(Student student) {
        String sql = "UPDATE Student SET name = ?, age = ?, email = ?, gpa = ? WHERE StudentID = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setDouble(4, student.getGpa());
            stmt.setInt(5, student.getStudentID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteStudent(int studentID) {
        String sql = "DELETE FROM Student WHERE StudentID = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, studentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getDouble("gpa")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error getting students: " + e.getMessage());
        }
        return students;
    }


    public String generateEmail(String fullName) {
        String[] nameParts = fullName.trim().split("\\s+");
        if (nameParts.length < 2) {
            return fullName.toLowerCase() + "@vku.udn.vn";
        }

        String lastName = nameParts[nameParts.length - 1].toLowerCase();


        StringBuilder initials = new StringBuilder();
        for (int i = 0; i < nameParts.length - 1; i++) {
            initials.append(nameParts[i].charAt(0));
        }

        return lastName + initials.toString().toLowerCase() + "@vku.udn.vn";
    }
    public List<Student> getStudentsByClassID(int classID) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT s.* FROM Student s JOIN Learn l ON s.StudentID = l.StudentID WHERE l.ClassID = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, classID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getDouble("gpa")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error getting students by class: " + e.getMessage());
        }
        return students;
    }
//

    public boolean addStudentToClass(int studentID, int classID) {
        String sql = "INSERT INTO Learn (LearnID, StudentID, ClassID) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            // Generate a unique LearnID (in real app, could use auto-increment or UUID)
            int learnID = studentID * 1000 + classID;

            stmt.setInt(1, learnID);
            stmt.setInt(2, studentID);
            stmt.setInt(3, classID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding student to class: " + e.getMessage());
            return false;
        }
    }
}

// Manager for Class operations
class ClassManager {
    private DatabaseManager dbManager;

    public ClassManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Add a new class
    public boolean addClass(Class classObj) {
        String sql = "INSERT INTO Class (ClassID, description, numberOfCredits) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, classObj.getClassID());
            stmt.setString(2, classObj.getDescription());
            stmt.setInt(3, classObj.getNumberOfCredits());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding class: " + e.getMessage());
            return false;
        }
    }

    // Get class by ID
    public Class getClassById(int classID) {
        String sql = "SELECT * FROM Class WHERE ClassID = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, classID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Class(
                        rs.getInt("ClassID"),
                        rs.getString("description"),
                        rs.getInt("numberOfCredits")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error getting class: " + e.getMessage());
        }
        return null;
    }

    // Get all classes
    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM Class";
        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                classes.add(new Class(
                        rs.getInt("ClassID"),
                        rs.getString("description"),
                        rs.getInt("numberOfCredits")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error getting classes: " + e.getMessage());
        }
        return classes;
    }
}

// Authentication manager for login/logout
class AuthManager {
    private DatabaseManager dbManager;
    private Student currentUser;

    public AuthManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }


    public boolean login(String email) {
        String sql = "SELECT * FROM Student WHERE email = ?";
        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                currentUser = new Student(
                        rs.getInt("StudentID"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getDouble("gpa")
                );
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return false;
    }

    // Logout
    public void logout() {
        currentUser = null;
        System.out.println("User logged out successfully");
    }

    // Get current user
    public Student getCurrentUser() {
        return currentUser;
    }
}

// Console UI for interacting with the system
class ConsoleUI {
    private Scanner scanner;
    private StudentManager studentManager;
    private ClassManager classManager;
    private AuthManager authManager;

    public ConsoleUI(StudentManager studentManager, ClassManager classManager, AuthManager authManager) {
        this.scanner = new Scanner(System.in);
        this.studentManager = studentManager;
        this.classManager = classManager;
        this.authManager = authManager;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== VKU Student Management System =====");
            System.out.println("1. Login");
            System.out.println("2. Add Student");
            System.out.println("3. View Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. List All Students");
            System.out.println("7. Add Class");
            System.out.println("8. List All Classes");
            System.out.println("9. Add Student to Class");
            System.out.println("10. List Students in Class");
            System.out.println("11. Generate Email");
            System.out.println("12. Logout");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                    addStudentMenu();
                    break;
                case 3:
                    viewStudentMenu();
                    break;
                case 4:
                    updateStudentMenu();
                    break;
                case 5:
                    deleteStudentMenu();
                    break;
                case 6:
                    listAllStudents();
                    break;
                case 7:
                    addClass();
                    break;
                case 8:
                    listAllClasses();
                    break;
                case 9:
                    addStudentToClass();
                    break;
                case 10:
                    listStudentsInClass();
                    break;
                case 11:
                    generateEmailMenu();
                    break;
                case 12:
                    authManager.logout();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using VKU Student Management System!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void loginMenu() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (authManager.login(email)) {
            Student currentUser = authManager.getCurrentUser();
            System.out.println("Login successful! Welcome " + currentUser.getName());
        } else {
            System.out.println("Login failed. User not found.");
        }
    }

    private void addStudentMenu() {
        System.out.println("\n===== Add New Student =====");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // Generate email automatically
        String email = studentManager.generateEmail(name);
        System.out.println("Generated Email: " + email);

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();

        Student student = new Student(id, name, age, email, gpa);

        if (studentManager.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private void viewStudentMenu() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Student student = studentManager.getStudentById(id);
        if (student != null) {
            System.out.println("\nStudent Details:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void updateStudentMenu() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentManager.getStudentById(id);
        if (student != null) {
            System.out.println("Current details: " + student);

            System.out.print("Enter new Name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                student.setName(name);
            }

            System.out.print("Enter new Age (0 to keep current): ");
            int age = scanner.nextInt();
            scanner.nextLine();
            if (age > 0) {
                student.setAge(age);
            }

            System.out.print("Enter new GPA (-1 to keep current): ");
            double gpa = scanner.nextDouble();
            if (gpa >= 0) {
                student.setGpa(gpa);
            }

            if (studentManager.updateStudent(student)) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Failed to update student.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private void deleteStudentMenu() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        if (studentManager.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Failed to delete student.");
        }
    }

    private void listAllStudents() {
        List<Student> students = studentManager.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== All Students =====");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void addClass() {
        System.out.println("\n===== Add New Class =====");

        System.out.print("Enter Class ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Number of Credits: ");
        int credits = scanner.nextInt();

        Class classObj = new Class(id, description, credits);

        if (classManager.addClass(classObj)) {
            System.out.println("Class added successfully!");
        } else {
            System.out.println("Failed to add class.");
        }
    }

    private void listAllClasses() {
        List<Class> classes = classManager.getAllClasses();
        if (classes.isEmpty()) {
            System.out.println("No classes found.");
            return;
        }

        System.out.println("\n===== All Classes =====");
        for (Class c : classes) {
            System.out.println(c);
        }
    }

    private void addStudentToClass() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Class ID: ");
        int classId = scanner.nextInt();

        // Verify both student and class exist
        Student student = studentManager.getStudentById(studentId);
        Class classObj = classManager.getClassById(classId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        if (classObj == null) {
            System.out.println("Class not found.");
            return;
        }

        if (studentManager.addStudentToClass(studentId, classId)) {
            System.out.println("Student added to class successfully!");
            // Print all students in the class as required
            listStudentsInClassById(classId);
        } else {
            System.out.println("Failed to add student to class.");
        }
    }

    private void listStudentsInClass() {
        System.out.print("Enter Class ID: ");
        int classId = scanner.nextInt();

        listStudentsInClassById(classId);
    }

    private void listStudentsInClassById(int classId) {
        List<Student> students = studentManager.getStudentsByClassID(classId);
        Class classObj = classManager.getClassById(classId);

        if (classObj == null) {
            System.out.println("Class not found.");
            return;
        }

        if (students.isEmpty()) {
            System.out.println("No students found in this class.");
            return;
        }

        System.out.println("\n===== Students in " + classObj.getDescription() + " =====");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void generateEmailMenu() {
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        String email = studentManager.generateEmail(fullName);
        System.out.println("Generated Email: " + email);
    }
}
