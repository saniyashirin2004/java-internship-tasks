import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Force load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            return;
        }

        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // Consume newline

            try {
                if (ch == 1) {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Country: ");
                    String country = sc.nextLine();
                    dao.addEmployee(new Employee(name, email, country));
                    System.out.println("Employee added.");
                } else if (ch == 2) {
                    List<Employee> emps = dao.getAllEmployees();
                    for (Employee e : emps)
                        System.out.println(e);
                } else if (ch == 3) {
                    System.out.print("ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String name = sc.nextLine();
                    System.out.print("New Email: ");
                    String email = sc.nextLine();
                    System.out.print("New Country: ");
                    String country = sc.nextLine();
                    dao.updateEmployee(new Employee(id, name, email, country));
                    System.out.println("Employee updated.");
                } else if (ch == 4) {
                    System.out.print("ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                    System.out.println("Employee deleted.");
                } else if (ch == 5) {
                    break;
                }
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}