package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz que servira como menu de inicio
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntMenuGeneral extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz para el mensaje del menu
	 */
	private JLabel menu;
	/**
	 * Boton usado en la interfaz para registrarse
	 */
	private JButton registrarse,
	/**
	 * Boton usado en la interfaz para hacer login
	 */
	login,
	/**
	 * Boton usado en la interfaz para salir del programa
	 */
	salir;
	/**
	 * Array con las personas registradas hasta el momento
	 */
	private ArrayList<Persona> Aux;
	
	/**
	 * Constructor de la clase para mostrar un breve menu
	 * @param personas Es un ArrayList con todas las personas dadas de alta hasta el momento
	 */
	public IntMenuGeneral(ArrayList<Persona> personas) {
		//Configuramos los parametros de la ventana
		setTitle("Menu");
		setSize(220,140); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Aux = personas; //Apuntamos a la direccion de al array de entrada
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,//nº filas
									   1,//nº columnas
									   2,//espacios horizontales
									   2 //espacios verticales
									   ));
		
		//Creamos una etiqueta
		menu = new JLabel("Que accion deseas realizar: ");
		menu.setAlignmentY(CENTER_ALIGNMENT);
		panel.add(menu);
		
		//Creamos un boton para registrarse
		registrarse = new JButton("Registrarse");
		registrarse.addActionListener(this);
		panel.add(registrarse);
		
		//Creamos un boton para logearse
		login = new JButton("Login");
		login.addActionListener(this);
		panel.add(login);
		
		//Creamos un boton para salir del programa
		salir = new JButton("Salir");
		salir.addActionListener(this);
		panel.add(salir);		
		
		//Agregamos el panel al JFrame
		getContentPane().add(panel);
												
		//Hacer visible la ventana
		setVisible(true);
	}
	
	/**
	 * Metodo sobreescrito de la interfaz ActionListener
	 * En el gestionamos los eventos generados por los botones
	 * @param e Es el evento generado por los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registrarse) {
			setVisible(false);
			new IntSelecPersona(Aux); //Se lanza la interfaz para seleccionar si se va a registrar un cliente o un gerente
		}
		else if(e.getSource() == login) {
			setVisible(false);
			new IntLogin(Aux); //Se lanza la interfaza para loguearse
		}
		else if(e.getSource() == salir){
			System.exit(0); //Se sale del programa
		}
	}
	
}
