package Clases;

import java.util.ArrayList;

/**
 * Clase que sirve para insertarle datos a un Array de personas
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IncArrayInicial {
	/**
	 * Constructor por defecto
	 */
	public IncArrayInicial() {}	
	
	/**
	 * Metodo para meterle datos a un ArrayList de Persona
	 * @param pers Es el ArrayList al que hay que darle datos
	 */
	public void inicializar(ArrayList<Persona> pers) {
		Tienda tien = new Tienda("Flash Shop","6F1S6"); //Creamos la tienda que vamos a estar utilizando en programa
		tien.inicializar();
		
		Factory fact = new FactoryCliente();
		
		//Con el metodo CrearYMostrar creamos dos clientes
		pers.add(fact.CrearYMostrar("Miguel","Cebrian","MA5CF@gmail.com",
					 "TheBeast616"," C/ Sta. Cruz de Marcenado, 23",tien));
		pers.add(fact.CrearYMostrar("Jorge","Sanchez","jor02@gmail.com","Jorge1234"," C/ Mayor, 7",tien));
		
		fact = new FactoryGerente();
		
		//Con el metodo CrearYMostrar creamos dos gerentes
		pers.add(fact.CrearYMostrar("Miguel Angel","Cebrian Fernandez","MA@gmail.com","TheBeast666"," ",tien));
		pers.add(fact.CrearYMostrar("Jorge","Sanchez Lopez","jor@gmail.com","JamonYork"," ", tien));		
		
		//Mostramos el numero de personas registradas
		System.out.println("Numero de personas registradas: " + pers.size() + " personas");
	}
	
}
