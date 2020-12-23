package lockbox;
import shared.IChargeable;
import customer.PrivateCustomer;


public class Lockbox implements Comparable<Lockbox>,IChargeable{
	
	private int boxNumber;
	private double length;
	private double width;
	private PrivateCustomer hirer;
	
	public Lockbox (int boxNumber, double length, double width){
		this.boxNumber = boxNumber;
		this.length = length;
		this.width = width;
		this.hirer = null;
	}
	
	public int compareTo(Lockbox lockbox) {
		if (this.boxNumber > lockbox.boxNumber)
			return 1;
		else if (this.boxNumber < lockbox.boxNumber)
			return -1;
		else return 0;
			
	}
	
	public double calculatePrice() {
		// weitgehend sinnfreie Dummy-Implementierung
		return this.getSize()*0.01;
	}

	
	public boolean isHired(){
		return this.hirer != null;
	}
	
	public boolean setHirer(PrivateCustomer hirer){
		if (this.isHired() == false){
			this.hirer = hirer;
			hirer.registerLockbox(this);
			return true;
			}
		else return false;
	}
	public void cancel (){
		if ( this.hirer.deregisterLockbox(this) != true )
			System.err.println("Probleme beim Deregistrieren der Lockbox");
		else
			this.hirer = null;
	}
	
	public int getBoxNumber() {
		return this.boxNumber;
	}
		
	public double getSize() {
		return this.length * this.width;
	}
	
}
