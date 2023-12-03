package Clases;

/**
 * Clase abstracta que define el "Factory Method" para una persona
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

abstract class Factory {
	/**
	 * Metodo abstracto de la clase "FactoryPersona"
	 * @param s1 String para el nombre de la persona
	 * @param s2 String para los apellidos de la persona
	 * @param s3 String para el correo de la persona
	 * @param s4 String para el password de la persona
	 * @param s5 String para la direccion, si es cliente, y si es gerente, no lo usa
	 * @return Devuelve a la persona con sus valores ya inicializados
	 */
	public abstract Persona crearPersona(String s1,String s2,String s3,String s4,String s5);
	
	/**
	 * Metodo para inicializar a una persona y saber de que tipo es
	 * @param s1 String para el nombre de la persona
	 * @param s2 String para los apellidos de la persona
	 * @param s3 String para el correo de la persona
	 * @param s4 String para el password de la persona
	 * @param s5 String para la direccion, si es cliente, y si es gerente, no lo usa
	 * @param tienda Es la tienda que gestionara el gerente
	 * @return Devuelve a la persona con sus valores ya inicializados
	 */
	public abstract Persona CrearYMostrar(String s1,String s2,String s3,String s4,String s5,Tienda tienda);
}
