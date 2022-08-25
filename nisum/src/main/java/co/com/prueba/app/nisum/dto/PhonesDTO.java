package co.com.prueba.app.nisum.dto;

import java.io.Serializable;

/**
 * 
 * @author danielcamilo.correa
 *
 */
public class PhonesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String number;
	
	private String citycode;
	
	private String contrycode;
	
	public PhonesDTO() {
		super();
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getCitycode() {
		return citycode;
	}
	
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
	public String getContrycode() {
		return contrycode;
	}
	
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

}
