import java.util.ArrayList;

// School class. This class is used for keeping track of schools
public class School {
    // Fields. Variables in each School Class
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    private String schoolName;
    private int cost;
    private String schoolLocation;

    // Default Constructor. Constructing default values for the Fields if initiating without params
    School(){
        this.schoolName = "unNamed";
        this.cost = 0;
        this.schoolLocation = "unknown";
    }

    // Constructor with params. Constructing the fields equal to the initiating params
    School(String schoolName, int cost, String schoolLocation){
        this.schoolName = schoolName;
        this.cost = cost;
        this.schoolLocation = schoolLocation;
    }

    // Setters and getters for my 3 fields of choosing. Setters are methods to set field values, and getters are methods to get field values
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    // Methods to add and remove teachers & students
    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher); // Using .add from ArrayList method
    }
    public void removeTeacher(Teacher teacher){
        this.teachers.remove(teacher); // Using .remove from ArrayList method
    }
    public void addStudent(Student student){
        this.students.add(student); // Using .add from ArrayList method
    }
    public void removeStudent(Student student){
        this.students.remove(student); // Using .remove from ArrayList method
    }

    // Methods to show all teachers & students
    public String showTeachers(){
        return this.teachers.toString();
    }
    public String showStudents(){
        return this.students.toString();
    }
}
