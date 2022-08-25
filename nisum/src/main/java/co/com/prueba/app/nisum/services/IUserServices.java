package co.com.prueba.app.nisum.services;

import java.util.List;

import co.com.prueba.app.nisum.dto.UserDTO;
import co.com.prueba.app.nisum.entities.User;
import co.com.prueba.app.nisum.exeption.NisumExeption;

/**
 * 
 * @author danielcamilo.correa
 *
 */
public interface IUserServices {
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * @param jsonUser
	 * @return User
	 */
	public User saveUser(UserDTO userRequest) throws NisumExeption;
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * @param jsonUser
	 * @return List<User>
	 */
	public List<User> getUsers() throws NisumExeption;
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * @return
	 * @throws NisumExeption
	 */
	public Boolean deleteUser(Long id) throws NisumExeption;
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * @param jsonUser
	 * @return User
	 */
	public User getUsersById(Long id) throws NisumExeption;
	
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * @param email
	 * @return User
	 * @throws NisumExeption
	 */
	public void getUserByEmail(String email) throws NisumExeption;
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * @param email
	 * @return User
	 * @throws NisumExeption
	 */
	public User updateUserById(UserDTO userRequest, Long id) throws NisumExeption;

}
