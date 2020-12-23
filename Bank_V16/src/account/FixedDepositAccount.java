package account;
import customer.Customer;


public class FixedDepositAccount extends Account {
	private double interestRate;
	private boolean isCancelled;
	
	public FixedDepositAccount (Customer aCustomer, double interestRate) {
		super (aCustomer);
		this.interestRate = interestRate;
		this.isCancelled = false;
	}
	public boolean drawMoney(double amount) {
		if ( (this.isCancelled == true) 
				&& (this.getBalance() >= amount)) {
			super.drawMoney(amount);
			return (true);
		}
		else return (false);
	}
	
	public void cancel() {
		this.isCancelled = true;
	}
	
	public String getSpecificAccountInfo() {
		return "Festgeldkonto, Zinssatz: "+this.interestRate;
	}
}