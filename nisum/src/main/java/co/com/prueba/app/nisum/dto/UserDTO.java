package co.com.prueba.app.nisum.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 * @author danielcamilo.correa
 *
 */
public class UserDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;
    
	@JsonProperty("email")	
	private String email;

	@JsonProperty("password")	
	private String password;

	@JsonProperty("phones")	
    private List<PhonesDTO> phones;
 
	@JsonProperty("created")	
    private Date created;	

	@JsonProperty("modified")	
    private Date modified;	
 
	@JsonProperty("lastLogin")	
    private Date lastLogin;	
  
	@JsonProperty("token")	
    private String token;	
 
	@JsonProperty("isActive")	
    private Boolean isActive;
	

	public UserDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhonesDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhonesDTO> phones) {
		this.phones = phones;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
