import java.util.Objects;

public class Employees {
    private String name;
    private boolean isCool;
    private int salary;
    private boolean isFired;
    static int employeeNum = 1;
    private int idNum;

    Employees(){
        this.name = "unnamed";
        this.isCool = false;
        this.salary = 0;
        isFired = false;
        idNum = employeeNum;
        employeeNum ++;
    }

    Employees(String name, boolean isCool, int salary){
        this.name = name;
        this.isCool = isCool;
        this.salary = salary;
        isFired = false;
        idNum = employeeNum;
        employeeNum++;
    }


    public String toString() {
        return this.name;
    }

    public boolean equals(Employees b){
        return Objects.equals(this.name, b.name);
    }


    public void fireEmployee(){ //Mine
        isFired = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isCool() {
        return isCool;
    }

    public void setCool(boolean cool) {
        isCool = cool;
    }

    public void increasePay(int increaseNum){
        if (salary == increaseNum){
            System.out.println("Just doubled a salary!");
        }
        salary += increaseNum;
    }
}
