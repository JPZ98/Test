package account;
import shared.IChargeable;
import customer.Customer;


public abstract class Account 
implements  Comparable<Account>, IChargeable {
	private static int nextNumber = 1000;
	
	private final int accountNr;
	private double balance;
	private Customer accountHolder;
	
	private static int nextNumber() {
		return nextNumber++;
	}
	
	public Account(Customer aCustomer) {
		this.accountNr = nextNumber();
		this.accountHolder = aCustomer;
		boolean ok = this.accountHolder.addAccount(this);
		if (!ok) {
			System.err.println("Konto kann nicht beim Kunden registiert werden!");
		}
	}
	
	public int compareTo (Account account) {
		if (this.accountNr > account.accountNr)
			return 1;
		else if ( this.accountNr < account.accountNr)
			return -1;
		else
			return 0;		
	}
	
	public double calculatePrice() {
		// sinnfreie Dummy-Implementierung
		return 10;
	}
	
	
	public Customer getAccountHolder(){
		return this.accountHolder;
	}
	public int getAccountNr(){
		return this.accountNr;
	}
	public double getBalance() {
		return this.balance;
	}
	
	public boolean drawMoney (double amount){
		this.balance -= amount;
		return true;
	}
	
	public void depositMoney (double amount){
		this.balance += amount;
	}

	public String getAccountInfo(){
		return
		this.accountNr+": "+ this.balance + "\n" +
		getSpecificAccountInfo();
	}
	
	public abstract String getSpecificAccountInfo();
	
	
	
}
