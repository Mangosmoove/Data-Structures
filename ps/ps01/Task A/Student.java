/**
 * Arinah Karim     ankarim
 * CSCI-C 343 / Fall 2020
 * Task A
 */

public class Student {
    //name, department are instance variables
    public String name = "Unknown";
    private String department = "Unknown";
    public int age = 0;
    private boolean drive = true;

    public Student(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setAge(int a){
        age = a;
    }

    public int getAge(){
        return age;
    }

    public void setDrive(Boolean d){
        drive = d;
    }

    public boolean getDrive(){
        return drive;
    }
    public void display() {
        System.out.println("Student Information");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Can drive?: " + drive + "\n");
    }

    public static void main(String[] args){
        //name is a local variable
        String name = "Burton Guster";
        //create an instance from the Student class
        Student stu1 = new Student(name);
        stu1.setDepartment("Pharmacy");
        Student stu2 = new Student("Shalissa");
        stu2.setDepartment("Media");
        stu1.setAge(18);
        stu2.setAge(20);
        stu1.setDrive(true);
        stu2.setDrive(false);
        stu1.display();
        stu2.display();

        //create an array of students
        Student[] stuList = new Student[3];
        stuList[0] = stu1;
        stuList[1] = new Student("Shawn Spencer");
        stuList[1].setDepartment("Psychology");
        stuList[1].setDrive(false);
        stuList[1].setAge(20);
        stuList[2] = new Student("Chad");
        stuList[2].setDepartment("Kelly");
        stuList[2].setAge(19);
        stuList[2].setDrive(true);
        stuList[2].setDrive(true);
        stuList[0].display();
        stuList[1].display();
        stuList[2].display();
    }
} // end of class Student
