package onboard.signup.service;

import onboard.common.beans.Service;
import onboard.common.exceptions.DuplicateRecordException;
import onboard.signup.beans.Seller;
import onboard.signup.dao.SignUpDAO;

public class SignUpService implements Service<Seller> {

	SignUpDAO signUpDAO = new SignUpDAO();

	@Override
	public boolean process(Seller seller) throws DuplicateRecordException {
		
			//Validate if user already exist in DB
			boolean isSellerRegistered = signUpDAO.isSellerRegistered(seller);
			if(isSellerRegistered)
			{
				throw new DuplicateRecordException("Record already exist in Databse");
			}
				
			// validate otp before adding seller
			try {
				signUpDAO.addSeller(seller);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return true;
	}

}
