public class Student {
    String name;
    String rollNo;
    String department;
    String phone;

    public Student(String name, String rollNo, String department, String phone) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
        this.phone = phone;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + department);
        System.out.println("Phone: " + phone);
        System.out.println("------------------------");
    }
}
