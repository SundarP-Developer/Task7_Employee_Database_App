package com.package1;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scan=new Scanner(System.in);
		boolean isEntering=true;
		
		while(isEntering) {
			System.out.println("-------------------------------");
			System.out.println("      Employee Management      ");
			System.out.println("-------------------------------");
			System.out.println("1. Add Employee");
			System.out.println("2. View All Employee");
			System.out.println("3. View Employee By Id");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			
			System.out.println("Enter the Operation Number : ");
			int choice=scan.nextInt();
			
			switch(choice) {
			
			case 1:{
				UserOperations.addEmployee();
				break;
			}
			case 2:{
				UserOperations.viewAllEmployee();
				break;
			}
			case 3:{
				System.out.println("Enter Employee Id : ");
				int id =scan.nextInt();
				Employee emp=UserOperations.viewEmployeeById(id);
				
				if(emp !=null ) {
					System.out.println(emp);
				}
				else {
					System.out.println("No Employee is found with this id!....");
				}
				break;
			}
			case 4:{
				UserOperations.updateEmployee();
				break;
			}
			case 5:{
				UserOperations.deleteEmployee();
				break;
			}
			case 6:{
				break;
			}
			default:{
				System.out.println("Invalid Operation Number !...");
				break;
			}
			}
			if(choice==6) {
				isEntering=false;
				System.out.println("Exited Successfully.....");
			}
		}
		scan.close();
	}
}
