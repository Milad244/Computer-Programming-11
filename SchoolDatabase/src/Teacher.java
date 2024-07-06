
// Teacher class. This class is used for keeping track of teachers
public class Teacher {
    // Fields. Variables in each Teacher Class
    private String firstName;
    private String lastName;
    private String subject;

    // Default Constructor. Constructing default values for the Fields if initiating without params
    Teacher(){
        firstName = "unnamed";
        lastName = "unnamed";
        subject = "unknown";
    }

    // Constructor with params. Constructing the fields equal to the initiating params
    Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    // Setters and getters for firstName & lastName & subject. Setters are methods to set field values, and getters are methods to get field values

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // toString method to return a teachers information in the format asked of me

    public String toString() {
        return ("Name: " + firstName + " " + lastName + ", Subject: " + subject + ".\n");
    }
}
