package onboard.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import commons.exceptions.ServiceException;
import framework.service.Service;
import onboard.signup.beans.Seller;
import onboard.signup.dao.SignUpDAO;

@Component
public class SignUpService implements Service<Seller> {

	@Autowired
	SignUpDAO signUpDAO;

	@Override
	public boolean process(Seller seller) throws ServiceException {
		// Validate if user already exist in DB
		boolean isSellerRegistered = signUpDAO.isSellerRegistered(seller);
		if (isSellerRegistered) {
			throw new ServiceException("Record already exist in Databse");
		}
		// validate otp before adding seller
		try {
			signUpDAO.addSeller(seller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
