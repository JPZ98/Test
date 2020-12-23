package shared;

import java.io.Serializable;

public class Address implements Serializable{
	
	private static final long serialVersionUID = -5100079919113168902L;
	
	
	private String street;
	private String streetNumber;
	private String zipCode;
	private String city;
	
	public Address (String street, String streetNumber, String zipCode, String city){
		this.street = street;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.city = city;
	}
	public String toString (){
		return this.street + " " + this.streetNumber + "\n"
		+ this.zipCode + " " + this.city;		
	}

}
