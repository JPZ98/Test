package customer;
import java.util.ArrayList;
import java.util.Collection;

import shared.Address;

import account.Account;


public abstract class Customer implements Comparable<Customer>{
	private static int nextNumber = 100;
	
	private final String cusNumber;
	private String lastName;
	private String firstName;
	private Address address;
	private Collection<Account> accounts;
	
	
	private static int nextNumber() {
		return nextNumber++;
	}
	
	public Customer(){
		this.cusNumber = "K" + nextNumber();
		this.accounts = new ArrayList<Account>();
	}
	
	public Customer (String lastName, String firstName){
		this ();
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public Customer ( 
			String lastName, String firstName,
			String street, String streetNumber, String zipCode, String city){
		this (lastName, firstName);
		this.address = new Address (street, streetNumber, zipCode, city);
	}
	
	public int compareTo(Customer customer) {
		return 
		(this.lastName+this.firstName).compareTo(customer.lastName+customer.firstName);
		
	}
	
	public boolean equals(Object customer) {
		return (this.lastName+this.firstName).equals(
		((Customer)customer).lastName+((Customer)customer).firstName);
	}
	public Collection<Account> getAllAccounts() {
		return this.accounts;
	}
	public boolean addAccount(Account aAccount){
		return accounts.add(aAccount);
	}
	
	public String getLastName (){
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	public String getCusNumber() {
		return this.cusNumber;
	}
	public void setAddress (String street, String streetNumber, String zipCode, String city){
		this.address = new Address (street, streetNumber, zipCode, city);
	}
	public String getAddress (){
		return this.address.toString();		
	}
	
	public String getCustomerAccountInfo() {
		String info="Kontoinformation:\n";
		for (Account account:this.accounts )
			if (account != null) 
				info += account.getAccountInfo();
		return info;
	}
	
	public String getCustomerInfo() {
		String result = "\nKundeninformation für \n";
		result += 
			this.getCusNumber() + ": " +
			this.getLastName() +", " + this.getFirstName() + "\n" +
			this.getAddress();
		result += "\n"+getSpecificCustomerInfo();
		result += "\n"+getCustomerAccountInfo();
		
		return result;
	}
	
	public abstract String getSpecificCustomerInfo();
	
	
	
}