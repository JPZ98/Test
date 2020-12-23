package test;

import employee.Employee;
import employee.EmployeeContainer;

public class Test {
	public static void main (String Args[]){
		
		EmployeeContainer ec = new EmployeeContainer();
		
		
		ec.readEmployeesFromFile();
		
		System.out.println("\nFolgende Mitarbeiterdaten sind in der Datei gespeichert:");
		for (Employee employee:ec.getAllEmployees())
			System.out.println(employee);
		
				


	}
	
}
