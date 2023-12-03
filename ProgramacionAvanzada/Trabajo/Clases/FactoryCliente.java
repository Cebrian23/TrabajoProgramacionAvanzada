package Clases;

/**
 * Clase "FactoryCliente" que crea instancias de la clase "Cliente"
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class FactoryCliente extends Factory {
	
	/**
	 * Funcion de la clase "FactoryCliente" para crear y devolver un cliente
	 * @param s1 Sera el nombre del cliente
	 * @param s2 Seran los apellidos del cliente
	 * @param s3 Sera el correo del cliente
	 * @param s4 Sera el password del cliente
	 * @param s5 Sera la direccion del cliente
	 * @return Devuelve al cliente con sus valores ya inicializados
	 */
	@Override
	public Persona crearPersona(String s1,String s2,String s3,String s4,String s5) {		
		return new Cliente(s1,s2,s3,s4,s5);
	}
	
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
	@Override
	public Persona CrearYMostrar(String s1,String s2,String s3,String s4,String s5,Tienda tienda) {
		Persona fact = crearPersona(s1, s2, s3, s4, s5);
		System.out.println(fact.ID() + " Inicializado");
		
		return fact;
	}
}
