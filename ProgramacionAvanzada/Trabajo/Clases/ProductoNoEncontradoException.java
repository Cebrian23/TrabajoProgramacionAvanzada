package Clases;

/**
 * Excepcion para comprobar si un numero insertado es o no es valido
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class ProductoNoEncontradoException extends Exception {
	
	/**
	 * Constructor
	 */
	public ProductoNoEncontradoException(){
		super("El ID que se ha insertado no se ha encontrado");
	}
}