package customer;
import java.util.ArrayList;
import java.util.Collection;

import shared.IInformable;
import lockbox.Lockbox;


public class PrivateCustomer extends Customer implements IInformable{

	public static final int NUMBER_OF_LOCKBOXES = 10;
	
	private Collection<Lockbox> lockboxes;
	private String eMailAddress;
	
	public PrivateCustomer() {
		super();
		this.lockboxes = new ArrayList<Lockbox>();	
	}
	
	public PrivateCustomer (String lastName, String firstName){
		super (lastName, firstName);
		this.lockboxes = new ArrayList<Lockbox>();
	}
	
	public PrivateCustomer (String lastName, String firstName,
			String street, String streetNumber, String zipCode, String city, String eMailAddress){
		super(lastName, firstName, street, streetNumber, zipCode, city);
		this.lockboxes = new ArrayList<Lockbox>();
		this.eMailAddress = eMailAddress;
	}
	
	public void inform (String message) {
		System.out.println (
				"AN: " + this.eMailAddress +"\n" +
				"BETREFF: Wichtige Information der Bank Ihres Vertrauens\n" +
				message);
	}
	
	public Collection<Lockbox> getAllLockboxes() {
		return this.lockboxes;
	}
	
	public boolean registerLockbox(Lockbox aLockbox){
		return this.lockboxes.add(aLockbox);
	}
	
	public boolean deregisterLockbox(Lockbox aLockbox){
		if (this.lockboxes.contains(aLockbox) == false)
			return false;
		else {
			this.lockboxes.remove(aLockbox);
			return true;
		}
	}
	
	public String getCustomerLockboxInfo(){
		String info="Schließfachübersicht: ";
		for (Lockbox lockbox:this.lockboxes)
			if (lockbox != null)
				info+= lockbox.getBoxNumber()+" ";
		return info;
	}
	
	public String getSpecificCustomerInfo() {		
		return this.eMailAddress + "\n" + getCustomerLockboxInfo();
	}
}
