package onboard.signin.validator;

import org.springframework.stereotype.Component;

import framework.validation.Validator;
import onboard.signin.beans.UserCredential;

@Component
public class SignInValidator implements Validator<UserCredential> {

	public boolean isValid(UserCredential credential) {

		// to do : input validation .

		return true;
	}

}
