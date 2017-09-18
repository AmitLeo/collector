package onboard.signup.validator;

import org.springframework.stereotype.Component;

import framework.validation.Validator;
import onboard.signup.beans.Seller;

@Component
public class SignUpValidator implements Validator<Seller> {

	public boolean isValid(Seller seller) {
	// To do : Validation needs to be performed on all the fields  like below . 
		
		return true;
	}

}
