import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("========== Student Profile Manager ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Search by Roll No");
            System.out.println("3. Search by Name Prefix");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    manager.addStudent(sc);
                    break;
                case 2:
                    manager.searchByRollNo(sc);
                    break;
                case 3:
                    manager.searchByNamePrefix(sc);
                    break;
                case 4:
                    manager.deleteStudent(sc);
                    break;
                case 5:
                    manager.displayAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }

        } while (choice != 6);

        sc.close();
    }
}
