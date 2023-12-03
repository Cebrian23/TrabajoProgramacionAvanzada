package Clases;

import java.util.ArrayList;

/**
 * Clase que sirve como main final del trabajo
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class ProgramaFinal {
	
	/**
	 * Es el Main del trabajo
	 * @param args Son los argumentos del main
	 */
	public static void main(String[] args) {
		ArrayList<Persona> pers = new ArrayList<Persona>();
		IncArrayInicial Inicio = new IncArrayInicial();
		
		Inicio.inicializar(pers);
		
		new IntMenuGeneral(pers);
	}
	
}