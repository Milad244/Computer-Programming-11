public class Main {
    public static void main(String[] args) {
        Student Oliver = new Student("Oliver", "Queen", 62);
        Student Barry = new Student("Barry", "Allen", 87);
        Student Taylor = new Student("Taylor", "Swift", 70);
        Student Snow = new Student("Snow", "White", 77);
        Student Milad = new Student("Milad", "Abdi", 91);
        Student Michael = new Student("Michael", "Scofield", 98);
        Student Emma = new Student("Emma", "Swan", 90);
        Student Regina = new Student("Regina", "Mills", 88);
        Student Thea = new Student("Thea", "Queen", 65);
        Student Hinata = new Student("Hinata", "Hyuga", 95);

        Teacher Robert = new Teacher("Robert", "Queen", "Business");
        Teacher Rumpelstiltskin = new Teacher("Rumpelstiltskin", "Gold", "Accounting");
        Teacher Christina = new Teacher("Christina", "Scofield", "Engineering");

        School Hogwarts = new School("Hogwarts", 1500000, "Parallel Earth 244");

        Hogwarts.addStudent(Oliver);
        Hogwarts.addStudent(Barry);
        Hogwarts.addStudent(Taylor);
        Hogwarts.addStudent(Snow);
        Hogwarts.addStudent(Milad);
        Hogwarts.addStudent(Michael);
        Hogwarts.addStudent(Emma);
        Hogwarts.addStudent(Regina);
        Hogwarts.addStudent(Thea);
        Hogwarts.addStudent(Hinata);

        Hogwarts.addTeacher(Robert);
        Hogwarts.addTeacher(Rumpelstiltskin);
        Hogwarts.addTeacher(Christina);

        System.out.println(Hogwarts.showStudents());
        System.out.println(Hogwarts.showTeachers());

        Hogwarts.removeStudent(Oliver);
        Hogwarts.removeStudent(Thea);

        Hogwarts.removeTeacher(Rumpelstiltskin);

        System.out.println(Hogwarts.showStudents());
        System.out.println(Hogwarts.showTeachers());
    }
}
