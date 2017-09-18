package onboard.signup.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SignUpResponse {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
