package com.package1;

import java.util.Scanner;

public class Employee {
	
	private int empID;
	private String empName;
	private String role;
	private int salary;
	
	Scanner scan=new Scanner(System.in);
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String role, int salary) {
		this.empID=id;
		this.empName=name;
		this.role=role;
		this.salary=salary;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		System.out.println("--------------------");
		System.out.println("  Employee Details  ");
		System.out.println("--------------------");
		return "Employee ID = " + empID + ",\nEmployee Name = " + empName + ",\nRole = " + role + ",\nSalary = " + salary + ".\n";
	}
}
