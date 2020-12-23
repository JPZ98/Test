package customer;

public class BusinessCustomer extends Customer {
	
	private String vatID;
	
	public BusinessCustomer(String vatID) {
		super();
		this.vatID = vatID;
	}
	public BusinessCustomer (String vatID, String lastName, String firstName){
		super (lastName, firstName);
		this.vatID = vatID;
	}
	public BusinessCustomer (String vatID, String lastName, String firstName,
			String street, String streetNumber, String zipCode, String city){
		super(lastName, firstName, street, streetNumber, zipCode, city);
		this.vatID = vatID;
	}
	public String getSpecificCustomerInfo(){
		return "Umsatzsteuernummer: " + this.vatID;
	}
}
