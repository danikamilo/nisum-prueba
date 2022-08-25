package co.com.prueba.app.nisum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author danielcamilo.correa
 *
 */
@Entity
@Immutable
@Table(name = "tb_users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("name")
    @Column(name="name")
	private String name;
    
	@JsonProperty("email")	
    @Column(name="email")
	private String email;

	@JsonProperty("password")	
    @Column(name="password")
	private String password;

	@JsonProperty("phones")	
    @Column(name="phones")
    private String phones;
 
	@JsonProperty("created")	
    @Column(name="created")
    private Date created;	

	@JsonProperty("modified")	
    @Column(name="modified")
    private Date modified;	
 
	@JsonProperty("lastLogin")	
    @Column(name="last_login")
    private Date lastLogin;	
  
	@JsonProperty("token")	
    @Column(name="token")
    private String token;	
 
	@JsonProperty("isActive")	
    @Column(name="isactive")
    private Boolean isActive;

	public User() {
		super();
	}

	public User(Long id, Date created, Date modified, Date lastLogin, String token, Boolean isActive) {
		super();
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phones="
				+ phones + "]";
	}
	
	public Boolean isEmptyUser() {
		if(this.email == null && this.name == null && this.id == null && this.phones == null && this.phones == null)
			return true;
		
		return false;
	}
	
}
