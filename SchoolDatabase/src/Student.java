
// Student class. This class is used for keeping track of students
public class Student {
    // Fields. Variables in each Student Class
    private String firstName;
    private String lastName;
    private int grade;
    private int studentId;
    static int studentIdCount = 1;

    // Default Constructor. Constructing default values for the Fields if initiating without params
    Student(){
        firstName = "unnamed";
        lastName = "unnamed";
        grade = 0;
        studentId = studentIdCount;
        studentId++;
    }

    // Constructor with params. Constructing the fields equal to the initiating params
    Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        studentId = studentIdCount;
        studentIdCount++;
    }

    //Setters and Getters for firstName & lastName & grade & studentId. Setters are methods to set field values, and getters are methods to get field values

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // toString method to return a students information in the format asked of me
    public String toString() {
        return ("Name: " + firstName + " " + lastName + ", Grade: " + grade + ", Student Number: " + studentId + ".\n");
    }
}
