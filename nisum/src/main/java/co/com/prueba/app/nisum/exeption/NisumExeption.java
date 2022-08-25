package co.com.prueba.app.nisum.exeption;

import java.io.Serializable;

/**
 * 
 * @author danielcamilo.correa
 *
 */
public class NisumExeption extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;  
	
	public NisumExeption() {
		super();
	}	
	
	/**
	 * 
	 * @param mensaje
	 */
	public NisumExeption(String mensaje) {
		super(mensaje);
	}
	
	/**
	 * 
	 * @param mensaje
	 * @param cause
	 */
	public NisumExeption(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}
	
	
	/**
	 * 
	 * @param cause
	 */
	public NisumExeption(Throwable cause) {
		super(cause);
	}

}
