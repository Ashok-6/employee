package com.wipro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);

       // while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. List Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter salary: ");
                    int salary = scanner.nextInt();
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setSalary((int) salary);
                    dao.addEmployee(employee);
                    System.out.println("Employee Added Successfully");
                    break;

                case 2:
                    List<Employee> employees = dao.listEmployees();
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;

                case 3:
                	System.out.print("Enter employee ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new salary: ");
                    int newSalary = scanner.nextInt();
                    Employee updatedEmployee = new Employee();
                    updatedEmployee.setId(idToUpdate);
                    updatedEmployee.setName(newName);
                    updatedEmployee.setSalary(newSalary);
                    dao.updateEmployee(updatedEmployee);
                    
                    System.out.println("==== Details Updated ====");
                    break;

                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    dao.deleteEmployee(idToDelete);
                    System.out.println("Employee Deleted");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
   // }
}
