package account;
import customer.Customer;


public class GiroAccount extends Account {

	private double overdraftLimit;
	
	public GiroAccount (Customer aCustomer, double overdraftLimit) {
		super(aCustomer);
		this.overdraftLimit = overdraftLimit; 
	}
	
	public boolean drawMoney(double amount) {
		if (amount <= this.getBalance()+overdraftLimit) {
			super.drawMoney(amount);
			return true;
		}
		else return false;
		
	}

	public String getSpecificAccountInfo() {
		return "Girokonto, Limit: "+this.overdraftLimit;
	}
}

