package co.com.prueba.app.nisum.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import co.com.prueba.app.nisum.dto.UserDTO;
import co.com.prueba.app.nisum.entities.User;
import co.com.prueba.app.nisum.exeption.NisumExeption;
import co.com.prueba.app.nisum.repositories.IUsersModel;
import co.com.prueba.app.nisum.services.IUserServices;

@Service
public class UserServicesImpl implements IUserServices {

	@Autowired
	private IUsersModel userModel;

	@Autowired
	private Environment properties;

	@Override
	public User saveUser(UserDTO userRequest) throws NisumExeption  {
		try {
			User user = getUserFromJson(userRequest);
			getUserByEmail(user.getEmail());
			user = userModel.save(user);
			return new User(user.getId(), user.getCreated(), user.getModified(), 
					user.getLastLogin(), user.getToken(), user.getIsActive());			
		} catch (NisumExeption e) {
			throw new NisumExeption(e.getMessage());
		}

	}

	@Override
	public void getUserByEmail(String email) throws NisumExeption {
		List<User> user = userModel.findByEmail(email);
		if (!user.isEmpty())
			throw new NisumExeption(properties.getProperty("msg.email.already.exist.in.bd"));

	}
	
	@Override
	public List<User> getUsers() throws NisumExeption {
		return userModel.findAll();
	}
	
	@Override
	public User getUsersById(Long id) throws NisumExeption {
		 Optional<User> user = userModel.findById(id);
		 if(!user.isPresent())
			 throw new NisumExeption(properties.getProperty("msg.user.not.found.in.bd"));
		 
		 return user.get();
	}
	
	@Override
	public Boolean deleteUser(Long id) throws NisumExeption {
		userModel.deleteById(id);
		return Boolean.TRUE;
	}

	private User getUserFromJson(UserDTO userRequest) throws NisumExeption {
		
		User user = new User();
		Pattern pattern;
		Matcher matcher;
		
		pattern = Pattern.compile(properties.getProperty("validate.input.email.user.nisum"));
	    matcher = pattern.matcher(userRequest.getEmail());
	    
	    if (matcher.find() != true) {
	    	 throw new NisumExeption(properties.getProperty("msg.email.format.not.valid"));
	    }
	    
	    pattern = Pattern.compile(properties.getProperty("validate.input.password.user.nisum"));
	    matcher = pattern.matcher(userRequest.getPassword());
	    
	    if(matcher.find() != true) {
	    	throw new NisumExeption(properties.getProperty("msg.password.format.not.valid"));
	    }
	    
		user.setEmail(userRequest.getEmail());
		user.setName(userRequest.getName());
		user.setPassword(userRequest.getPassword());
		
		JsonArray jsonArrayPhones = (JsonArray) new Gson().toJsonTree(userRequest.getPhones(), 
				new TypeToken<List<UserDTO>>() {}.getType());
		
		user.setPhones(jsonArrayPhones.toString());
		user.setModified(new Date());
		user.setLastLogin(new Date());
		user.setCreated(new Date());
		user.setToken(UUID.randomUUID().toString());
		user.setIsActive(true);
		return user;
	}

	@Override
	public User updateUserById(UserDTO userRequest, Long id) throws NisumExeption {
		Optional<User> userOpt = userModel.findById(id);
		 if(!userOpt.isPresent())
			throw new NisumExeption(properties.getProperty("msg.user.not.found.in.bd"));
		 
		User user = getUserFromJson(userRequest);
		user.setId(id);
		user = userModel.save(user);
		return user;
	}
}
