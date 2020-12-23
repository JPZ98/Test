package customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CustomerContainer {
	
	private Collection<Customer> customers;
	
	public CustomerContainer() {
		this.customers = new ArrayList<Customer>();
	}
	
	public void addCustomer (Customer customer) {
		this.customers.add(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		this.customers.remove(customer);
	}

	public Customer findCustomerByNr(String nr) {
		Iterator<Customer> it = customers.iterator();
		while (it.hasNext()) {
			Customer customer = it.next();
			if (customer.getCusNumber().equals(nr) )
				return customer;
		}
		return null;
	}
	
	public Collection<Customer> findCustomerByName(String name) {
		Collection<Customer>  result = new ArrayList<Customer>();
		Iterator<Customer> it = customers.iterator();
		while (it.hasNext()) {
			Customer customer = it.next();
			if (customer.getLastName().equals(name) )
				result.add(customer);
		}
		return result;
	}
	
	public Collection<Customer> getAllCustomers() {
		return this.customers;
	}
	
}
