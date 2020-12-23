package employee;
import java.io.Serializable;

import shared.Address;
import shared.IInformable;


public class Employee implements IInformable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lastName;
	private String firstName;
	private Address address;
	private String eMailAddress;
	
	public Employee (String lastName, String firstName,
			String street, String streetNumber, String zipCode, String city,
			String eMailAddress){
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = new Address (street, streetNumber, zipCode, city);
		this.eMailAddress = eMailAddress;
	}
	
	public void inform (String message) {
		System.out.println (
				"AN: " + this.eMailAddress +"\n" +
				"BETREFF: Mitarbeiterinformation\n" +
				message);
	}
	
	public String toString() {
		return this.lastName + ", " + this.firstName + "\n" +
			this.address + "\n" +
			this.eMailAddress;
	}
	
}
