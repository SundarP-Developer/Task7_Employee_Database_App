package com.package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserOperations {

	static Scanner scan=new Scanner(System.in);
	
	public static void addEmployee() throws ClassNotFoundException, SQLException {
		
		Connection connect = DataBaseConnection.getConnection();
		
		System.out.println("Enter the Employee Id : ");
		int id=scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("Enter the Employee Name : ");
		String name=scan.nextLine();

		System.out.println("Enter the Employee Role : ");
		String role=scan.nextLine();
		
		System.out.println("Enter the Employee Salary : ");
		int salary=scan.nextInt();
		
		Employee emp= new Employee(id,name,role,salary);
		
		String query="insert into employee_details(id,emp_name,emp_role,salary) values (?,?,?,?)";
		PreparedStatement pst = connect.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, role);
		pst.setInt(4, salary);
		int rows=pst.executeUpdate();
		
		if(rows>0) {
			System.out.println("Employee Details Added Successfully...");
		}
		pst.close();
		connect.close();
	}
	
	public static void viewAllEmployee() throws ClassNotFoundException, SQLException{
		
		Connection connect=DataBaseConnection.getConnection();
		
		List<Employee> emp=new ArrayList<>();
		
		String query="select * from employee_details";
		Statement state=connect.createStatement();
		ResultSet rs=state.executeQuery(query);
		
		while(rs.next()) {
			emp.add(new Employee(rs.getInt(1),
								 rs.getString(2),
								 rs.getString(3),
								 rs.getInt(4)));
		}
		for(Employee em:emp) {
			System.out.println(em);
		}
		rs.close();
		state.close();
		connect.close();
	}
	
	public static Employee viewEmployeeById(int id) throws ClassNotFoundException, SQLException {
		
		Connection connect=DataBaseConnection.getConnection();
		
		String query="select * from employee_details where id = ?";
		PreparedStatement pst=connect.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			Employee emp = new Employee(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getInt(4));
			return emp;
		}
		else {
			return null;
		}
	}
	
	public static void updateEmployee() throws ClassNotFoundException, SQLException {
		Connection connect=DataBaseConnection.getConnection();
		
		System.out.println("Enter Employee Id to change : ");
		int getId=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the Employee Name : ");
		String name=scan.nextLine();
		System.out.println("Enter the Employee Role : ");
		String role=scan.nextLine();
		System.out.println("Enter the Employee salary : ");
		int salary=scan.nextInt();
		
		String query="update employee_details set emp_name = ?,emp_role = ?,salary = ? where id = ? ";
		PreparedStatement pst=connect.prepareStatement(query);
		pst.setString(1, name);
		pst.setString(2, role);
		pst.setInt(3, salary);
		pst.setInt(4, getId);
		int row=pst.executeUpdate();
		
		if(row>0) {
			System.out.println("Employee data updated Successfully...");
		}
		else {
			System.out.println("No Employee is found with this id...");
		}
		pst.close();
		connect.close();
	}
	
	public static void deleteEmployee() throws ClassNotFoundException, SQLException {
		
		Connection connect=DataBaseConnection.getConnection();
		
		System.out.println("Enter Employee Id to delete : ");
		int getId=scan.nextInt();
		
		String query = "delete from employee_details where id = ?";
		PreparedStatement pst=connect.prepareStatement(query);
		pst.setInt(1, getId);
		int row=pst.executeUpdate();
		
		if(row>0) {
			System.out.println("Employee with id "+getId+" is deleted Successfully...");
		}
		else {
			System.out.println("No Employee is found with this id!...");
		}
		pst.close();
		connect.close();
	}
	
}
