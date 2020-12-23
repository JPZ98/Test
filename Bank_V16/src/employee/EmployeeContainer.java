package employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class EmployeeContainer {
	
	Collection<Employee> employees;
	
	public EmployeeContainer () {
		this.employees = new ArrayList<Employee>();
	}
	
	public void readEmployeesFromFile(){
		FileReader file = null;
		Scanner sc = null;
		try {
			file = new FileReader("Employee.txt");
			sc = new Scanner (file).useDelimiter(";");
		} catch (FileNotFoundException e) {
			System.err.println("Datei nicht gefunden");}
		this.employees.clear();
		while (sc.hasNext()) {
			this.employees.add( 
					new Employee (
						sc.next(), // lastName;
						sc.next(), // firstName;
						sc.next(), // street;
						sc.next(), // streetNr;
						sc.next(), // zipCode;
						sc.next(), // city;
						sc.next()  // eMail
						)
					); 
		}
		try {
			file.close();
		} catch (IOException e) {
			System.err.println("Datei nicht gefunden");}
	}
	
	
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public Collection<Employee> getAllEmployees(){
		return employees;
	}
}
