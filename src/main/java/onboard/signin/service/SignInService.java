package onboard.signin.service;

import onboard.common.beans.Service;
import onboard.signin.beans.UserCredential;
import onboard.signin.dao.SignInDAO;

public class SignInService implements Service<UserCredential> {

	SignInDAO signInDAO = new SignInDAO();

	public boolean process(UserCredential credential) {
		try {
		return signInDAO.isUserRegistered(credential);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
