package co.com.prueba.app.nisum.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import co.com.prueba.app.nisum.dto.UserDTO;
import co.com.prueba.app.nisum.entities.User;
import co.com.prueba.app.nisum.exeption.NisumExeption;
import co.com.prueba.app.nisum.services.IUserServices;

/**
 * 
 * @author danielcamilo.correa
 *
 */
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UsersRestController {
	
	@Autowired
	private Environment properties;
	
	@Autowired
	private IUserServices userServ;
	
	private final Logger LOG = LoggerFactory.getLogger(UsersRestController.class);
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * 
	 * @param userRequest
	 * @return ResponseEntity<String>
	 */
	@PostMapping(path = "/save-users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveUser(@RequestBody UserDTO userRequest) {
		User user = null;
		try {
			user = userServ.saveUser(userRequest);
		} catch (NisumExeption e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(generateMessages(e.getMessage()).toString());
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new Gson().toJson(user));		
	}
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * 
	 * @return ResponseEntity<String>
	 */
	@GetMapping("/get-users")
	public ResponseEntity<String> getUsers(){
		try {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new Gson().toJson(userServ.getUsers()));		
		} catch (NisumExeption e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(generateMessages(e.getMessage()).toString());
		}
			
	}
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * 
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@GetMapping("/get-user/{id}")
	public ResponseEntity<String> getUsersById(@PathVariable(value = "id") Long id){
		try {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new Gson().toJson(userServ.getUsersById(id)));		
		} catch (NisumExeption e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(generateMessages(e.getMessage()).toString());
		}
			
	}
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * 
	 * @return ResponseEntity<String>
	 */
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id){
		try {
			userServ.deleteUser(id);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(generateMessages(properties.getProperty("msg.delete.user.ok")).toString());

		} catch (NisumExeption e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(generateMessages(e.getMessage()).toString());
		}
	}
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * 
	 * @param userRequest
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@PutMapping("/update-user/{id}")
	public ResponseEntity<String> updateUserBy(@RequestBody UserDTO userRequest, @PathVariable(value = "id") Long id) {
		User user = null;
		try {
			user = userServ.updateUserById(userRequest, id);
		} catch (NisumExeption e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(generateMessages(e.getMessage()).toString());
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new Gson().toJson(user));		
	}
	
	/**
	 * @author danielcamilo.correa
	 * 
	 * @param message
	 * @return JsonObject
	 */
	private JsonObject generateMessages(String message) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("mensaje", message);
		return jsonObject;
	}
	
}
