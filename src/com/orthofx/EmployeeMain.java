package com.orthofx;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;


public class EmployeeMain {
	private static Map<Integer, Employee> employeeTable = new HashMap<>();
	private static Map<Integer, Department> deptTable = new HashMap<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int op=0;
		while(op !=10) {
			System.out.println("MENU:\n1)to add new depts \n2)To add new employees \n3)to search dept by id \n4)to search emp by id \n5)update emp\n6)to remove emp\n7)display all emps");
			op=input.nextInt();
			
			if(op==1) { //create depts
				System.out.println("Enter number of new depts to create:");
				int n=input.nextInt();
				
				for(int i=0;i<n;i++) {
					System.out.println("\nEnter New Department Name:");	
					String deptName=input.next();
					createDeptFunc(deptName);
				}
			}
			else if(op==2) { //create employees
				System.out.println("Enter number of new emps to create:");
				int n=input.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("\nEnter Employee Name:");	
					String empName=input.next();
					System.out.println("\nEnter Employee Dept id:");	
					int deptId=input.nextInt();
					Department dept=deptTable.get(deptId);
					
					
					createEmployeeFunc(empName,dept);
				}
			}
			else if(op==3) { //get dept by id
				System.out.print("Enter dept id to search:");
				int id=input.nextInt();
				getDept(id);
			}
			else if(op==4) { //get emp by id
				System.out.print("Enter emp id to search:");
				int id=input.nextInt();
				getEmp(id);
			}
			else if(op==5) {
				System.out.println("Enter employee details to update:");
				System.out.println("\nEnter Employee Id:");	
				int empId=input.nextInt();
				System.out.println("\nEnter New Employee Name:");	
				String empName=input.next();
				System.out.println("\nEnter Employee Dept id:");
				int deptId=input.nextInt();
				Department dept=deptTable.get(deptId);
				updateEmp(empId,empName,dept);
					
			}
			else if(op==6) {
				System.out.println("Enter Id of emp to remove:");	
				int empId=input.nextInt();
				removeEmp(empId);
			}
			else if(op==7) {
				System.out.println("Print all employee details");
				for(Employee emp: employeeTable.values() ) {
					System.out.println("Id:"+emp.getId()+" Name:"+emp.getName()+" Dept:"+emp.getDept().getName());
				}
			}
			
			else { //exit
				break;
			}		
		}
		
		
		input.close();
//		getEmp(1);

	}

	public static Department createDeptFunc(String deptarmentName) {
		Department dept = new Department(deptTable.size() + 1, deptarmentName);//adding id based on table size, adding name
		deptTable.put(dept.getId(), dept);
		return dept;
	}
	public static Employee createEmployeeFunc(String empName, Department dept) {
		Employee emp=new Employee(employeeTable.size()+1,empName, dept);
		employeeTable.put(emp.getId(), emp);
		return emp;
	}
	public static void getDept(int deptId) {  //getting deptname by id
		Department dept=deptTable.get(deptId);
		System.out.println(dept.getId()+" "+dept.getName());
	}
	public static void getEmp(int empId) {  //getting empname by id
		Employee emp=employeeTable.get(empId);
		System.out.println(emp.getId()+" "+emp.getName());
	}
	public static void updateEmp(int id, String name, Department dept) { //update emp details(obj)
		Employee emp2=new Employee(id,name,dept);	//getting emp object from table using id
		employeeTable.put(id,emp2);
	}
	public static void removeEmp(int id) {
		employeeTable.remove(id);
	}

}
//for(int empid: employeeTable.keySet()) {
//	Employee emp=employeeTable.get(empid);
//}
