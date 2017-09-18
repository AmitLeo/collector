package onboard.signup.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Seller {

	private String name;
	private String emailId;
	private String phoneNumber;
	private String password;
	
	//CHANGE PASSWORD SHOULD ALSO BE ADDED AND STORED IN DATABASE TO RELOGIN

	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
