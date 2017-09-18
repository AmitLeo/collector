package onboard.signin.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import onboard.common.exceptions.InvalidInputException;
import onboard.signin.beans.UserCredential;
import onboard.signin.constants.SignInConstants;
import onboard.signin.service.SignInService;
import onboard.signin.validator.SignInValidator;


@Path("/signin")
public class SignInController {

	
	SignInValidator signInValidator=new SignInValidator();
	SignInService signInService=new SignInService();
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String signIn(UserCredential credential) throws InvalidInputException{
		
		if(!signInValidator.isValid(credential))
			throw new InvalidInputException("Input provided is invalid");
		boolean isAuthorized = signInService.process(credential);
		
		return isAuthorized?SignInConstants.AUTHORIZED:SignInConstants.UNAUTHORIZED;
		
	}
	
	

}
