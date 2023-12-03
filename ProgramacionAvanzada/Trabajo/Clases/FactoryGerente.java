package Clases;

/**
 * Clase "FactoryGerente" que crea instancias de la clase "Gerente"
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class FactoryGerente extends Factory {
	
	/**
	 * Funcion de la clase "FactoryCliente" para crear y devolver un gerente
	 * @param s1 Sera el nombre del gerente
	 * @param s2 Seran los apellidos del gerente
	 * @param s3 Sera el correo del gerente
	 * @param s4 Sera el password del gerente
	 * @param s5 No se llega a usar
	 * @return Devuelve al gerente con sus valores ya inicializados
	 */
	@Override
	public Persona crearPersona(String s1,String s2,String s3,String s4,String s5) {
		return new Gerente(s1,s2,s3,s4);
	}
	
	/**
	 * Metodo para inicializar a una persona y saber de que tipo es
	 * @param s1 String para el nombre de la persona
	 * @param s2 String para los apellidos de la persona
	 * @param s3 String para el correo de la persona
	 * @param s4 String para el password de la persona
	 * @param s5 String para la direccion, si es cliente, y si es gerente, no lo usa
	 * @param t1 Es la tienda que gestionara el gerente
	 * @return Devuelve a la persona con sus valores ya inicializados
	 */
	@Override
	public Persona CrearYMostrar(String s1,String s2,String s3,String s4,String s5,Tienda t1) {
		Persona fact = crearPersona(s1, s2, s3, s4,s5);
		System.out.println(fact.ID() + " Inicializado");
		
		Gerente aux = (Gerente) fact;
		aux.setShop(t1);
		
		return aux;
	}
}
