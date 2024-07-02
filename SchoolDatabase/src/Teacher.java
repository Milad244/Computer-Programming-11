public class Teacher {
    //Fields

    private String firstName;
    private String lastName;
    private String subject;

    // Default Constructor
    Teacher(){
        firstName = "unnamed";
        lastName = "unnamed";
        subject = "unknown";
    }

    // Constructor with params
    Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    // Setters and getters for firstName & lastName & subject

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

    //

    public String toString() {
        return ("Name: " + firstName + " " + lastName + ", Subject: " + subject + ".\n");
    }
}
