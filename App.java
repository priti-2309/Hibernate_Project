package Hibernate.Bank_Management_System;

import java.util.List;
import java.util.Scanner;

import Hibernate.Bank_Management_System.dao.CustomerDao;
import Hibernate.Bank_Management_System.daoIMPL.CustomerDaoIMPL;
import Hibernate.Bank_Management_System.daoIMPL.LoanDaoIMPL;
import Hibernate.Bank_Management_System.entity.Customer;
import Hibernate.Bank_Management_System.service.AccountService;
import Hibernate.Bank_Management_System.service.CustomerService;
import Hibernate.Bank_Management_System.service.EmployeeService;
import Hibernate.Bank_Management_System.service.LoanService;


import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        //creating service object
        
        while (!exit) {
            System.out.println("Welcome to Bank Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Admin login
                    System.out.print("Enter Admin username: ");
                    String username = scanner.next();
                    System.out.print("Enter Admin password: ");
                    String password = scanner.next();

                    if ("admin".equals(username) && "admin123".equals(password)) {
                        boolean adminExit = false;
                        while (!adminExit) {
                            System.out.println("\n1. Add Customer");
                            System.out.println("2. View Customers");
                            System.out.println("3. View Accounts");
                            System.out.println("4. View Loans");
                            System.out.println("5. View Employee Details");
                            System.out.println("6. Exit");
                            System.out.print("Enter choice: ");
                            int adminChoice = scanner.nextInt();

                            switch (adminChoice) {
                                
                        }
                    }
                    }