package com.ca.app;

import com.ca.entity.Employee;
import com.ca.logic.EmployeeDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        EmployeeDAOImpl empDAOImpl = new EmployeeDAOImpl();

        while (true) {

            displayMenu();
            String value = scan.next();

            switch (value) {
                case "1":
                    //Add Employee
                    Employee e = addEmployee();
                    if ( e != null ) {
                        empDAOImpl.add(e);
                        System.out.println("Employee added successfully");
                    }
                    break;
                case "2":
                    //System.out.println("Please enter Employee ID ");
                    findEmployeeById(empDAOImpl);
                    break;
                case "3":
                    //System.out.println("Search Employee by Name");
                    findEmployeeByFirstName(empDAOImpl);
                    break;
                case "4":
                    //Print List of Employees
                    printAllEmployees(empDAOImpl.getEmployeesList());
                    break;
                case "5":
                    //Exit
                    empDAOImpl.saveFile();
                    System.out.println("Good Bye!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid number mentioned in the Display Menu");
            }

        }

    }

    public static void displayMenu() {
        System.out.println("Display the Menu");
        System.out.println("1. Add Employee");
        System.out.println("2. Find Employee by Employee Id");
        System.out.println("3. Search Employee by Employee First Name");
        System.out.println("4. Display all Employees");
        System.out.println("5. Exit");
        System.out.println("Enter the Number to select Action!");
    }


    public static Employee addEmployee() {
        Integer empId;
        String firstName;
        String lastName;
        Date joiningDate;
        String designation;
        Employee e;
        try {
            System.out.println("Please enter Employee Id: ");
            empId = scan.nextInt();
            System.out.println("Please enter Employee First Name: ");
            firstName = scan.next();
            System.out.println("Please enter Employee Last Name: ");
            lastName = scan.next();
            System.out.println("Please enter Joining Date: ");
            /*DateTimeFormatter formatter = null;
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(scan.next(),formatter);*/
            joiningDate = new SimpleDateFormat("dd/MM/yyyy").parse(scan.next());
            System.out.println("Please enter Designation: ");
            designation = scan.next();

            e = new Employee(empId, firstName, lastName, joiningDate, designation);
            System.out.println(e);
            return e;
        } catch (ParseException | NumberFormatException pEx) {
            pEx.printStackTrace();
            return null;
        }
    }

    public static void findEmployeeByFirstName(EmployeeDAOImpl empDAOImpl) {
        System.out.println("Please enter First Name to search for Employees: ");
        String empFirstName = scan.next();
        List<Employee> listEmployee = empDAOImpl.findByFirstName(empFirstName);
        if(listEmployee.size()==0){
            System.out.println("No Employees found");
        }
        for (Employee e : listEmployee) {
            System.out.println(e);
        }
    }

    public static void findEmployeeById(EmployeeDAOImpl empDAOImpl) {
        System.out.println("Please enter Emp Id to find the Employee: ");
        try {
            int empId = scan.nextInt();
            Employee emp = empDAOImpl.findById(empId);
            if ( emp != null ) {
                System.out.println(emp);
            } else {
                System.out.println("Employee with Emp id: " + empId + " not found");
            }
        } catch (NumberFormatException nfEx) {
            System.out.println("Please enter numeric Emp id");
            nfEx.printStackTrace();
        }
    }

    private static void printAllEmployees(List<Employee> listEmployee) {
        for (Employee e : listEmployee) {
            System.out.println(e);
        }
    }
}
