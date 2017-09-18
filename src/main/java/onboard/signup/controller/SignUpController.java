package onboard.signup.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import onboard.common.exceptions.DuplicateRecordException;
import onboard.common.exceptions.InvalidInputException;
import onboard.signup.beans.Seller;
import onboard.signup.beans.SignUpResponse;
import onboard.signup.service.SignUpService;
import onboard.signup.validator.SignUpValidator;

@Path("/signup")
public class SignUpController {

	SignUpValidator signUpValidator = new SignUpValidator();
	SignUpService signUpService = new SignUpService();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public SignUpResponse signUp(Seller seller) throws InvalidInputException {

		SignUpResponse response = new SignUpResponse();
		if (!signUpValidator.isValid(seller))
			throw new InvalidInputException("Entered details are incorrect.");
		try {
			signUpService.process(seller);
		} catch (DuplicateRecordException ex) {
			response.setStatus("alreadyRegistered");
			return response;
		}
		response.setStatus("Registered");

		return response;

	}

}
