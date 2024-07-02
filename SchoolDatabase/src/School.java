import java.util.ArrayList;

public class School {
    //Fields

    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    private String schoolName;
    private int cost;
    private String schoolLocation;

    // Default Constructor
    School(){
        this.schoolName = "unNamed";
        this.cost = 0;
        this.schoolLocation = "unknown";
    }

    // Constructor with params
    School(String schoolName, int cost, String schoolLocation){
        this.schoolName = schoolName;
        this.cost = cost;
        this.schoolLocation = schoolLocation;
    }

    // Setters and getters for my 3 fields of choosing
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
        this.teachers.add(teacher);
    }
    public void removeTeacher(Teacher teacher){
        this.teachers.remove(teacher);
    }
    public void addStudent(Student student){
        this.students.add(student);
    }
    public void removeStudent(Student student){
        this.students.remove(student);
    }

    // Methods to show all teachers & students
    public String showTeachers(){
        return this.teachers.toString();
    }
    public String showStudents(){
        return this.students.toString();
    }
}
