package co.com.prueba.app.nisum.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import co.com.prueba.app.nisum.dto.UserDTO;
import co.com.prueba.app.nisum.exeption.NisumExeption;

/**
 * 
 * @author danielcamilo.correa
 *
 */
public class ValidateRequestUser {
	
	@Autowired
	private Environment properties;
	
	public void validarUser(UserDTO userRequest) throws NisumExeption {
		
		if(userRequest.getEmail().isEmpty() || userRequest.getEmail() == null) {
			throw new NisumExeption(properties.getProperty("msg.validate.request.email"));
		}
		if(userRequest.getName().isEmpty() || userRequest.getName() == null) {
			throw new NisumExeption(properties.getProperty("msg.validate.request.name"));			
		}
		if(userRequest.getPassword().isEmpty() || userRequest.getPassword() == null) {
			throw new NisumExeption(properties.getProperty("msg.validate.request.password"));			
		}
		if(userRequest.getPhones().isEmpty() || userRequest.getPhones() == null) {
			throw new NisumExeption(properties.getProperty("msg.validate.request.phones"));			
		}
		
	}

}
