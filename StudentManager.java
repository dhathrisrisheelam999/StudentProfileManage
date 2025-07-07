import java.util.*;

public class StudentManager {
    HashMap<String, Student> studentMap = new HashMap<>();
    Trie trie = new Trie();

    public void addStudent(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        Student student = new Student(name, rollNo, department, phone);
        studentMap.put(rollNo, student);
        trie.insert(name);
        System.out.println("Student added successfully!\n");
    }

    public void searchByRollNo(Scanner sc) {
        System.out.print("Enter Roll No to search: ");
        String rollNo = sc.nextLine();
        Student student = studentMap.get(rollNo);
        if (student != null) {
            student.display();
        } else {
            System.out.println("Student not found.\n");
        }
    }

    public void searchByNamePrefix(Scanner sc) {
        System.out.print("Enter Name Prefix: ");
        String prefix = sc.nextLine();
        ArrayList<String> suggestions = trie.getWordsWithPrefix(prefix);
        if (suggestions.isEmpty()) {
            System.out.println("No matching names found.\n");
        } else {
            System.out.println("Matching Names:");
            for (String name : suggestions) {
                for (Student s : studentMap.values()) {
                    if (s.name.equalsIgnoreCase(name)) {
                        s.display();
                    }
                }
            }
        }
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Enter Roll No to delete: ");
        String rollNo = sc.nextLine();
        if (studentMap.containsKey(rollNo)) {
            studentMap.remove(rollNo);
            System.out.println("Student deleted successfully.\n");
        } else {
            System.out.println("Student not found.\n");
        }
    }

    public void displayAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students to display.\n");
            return;
        }
        ArrayList<Student> list = new ArrayList<>(studentMap.values());
        list.sort(Comparator.comparing(s -> s.name.toLowerCase()));
        for (Student s : list) {
            s.display();
        }
    }
}
