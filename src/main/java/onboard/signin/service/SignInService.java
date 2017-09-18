package onboard.signin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import framework.service.Service;
import onboard.signin.beans.UserCredential;
import onboard.signin.dao.SignInDAO;

@Component
public class SignInService implements Service<UserCredential> {

	@Autowired
	SignInDAO signInDAO;

	public boolean process(UserCredential credential) {
		try {
		return signInDAO.isUserRegistered(credential);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
