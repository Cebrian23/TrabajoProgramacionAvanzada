package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Object;

/**
 * Interfaz para seleccionar si se va a registrar un Cliente o un Gerente
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntSelecPersona extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz para preguntar que tipo de persona se va a registrar
	 */
	private JLabel etiqueta;
	/**
	 * Boton usado en la interfaz para saber que se va a registrar un cliente
	 */
	private JButton clie,
	/**
	 * Boton usado en la interfaz para saber que se va a registrar un gerente
	 */
	geren,
	/**
	 * Boton usado en la interfaz para volver al menu
	 */
	volver;
	/**
	 * Array con las personas registradas hasta el momento y en el que se insertara la nueva persona
	 */
	private ArrayList<Persona> Aux;
	
	/**
	 * Constructor de la clase para seleccionar si tu rol va a ser el de cliente o el de gerente
	 * @param personas Es un ArrayList con todas las personas dadas de alta hasta el momento
	 */
	public IntSelecPersona(ArrayList<Persona> personas) {
		//Configuramos los parametros de la ventana
		setTitle("Seleccion Persona");
		setSize(315,175); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Aux = personas; //Apuntamos a la direccion de al array de entrada
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//Creamos la etiqueta para la pregunta
		etiqueta  = new JLabel("¿Eres cliente o gerente?");
		panel.add(etiqueta,BorderLayout.CENTER);
		
		//Creamos un boton para el cliente
		clie = new JButton("Cliente");
		clie.addActionListener(this);
		panel.add(clie,BorderLayout.WEST);
		
		//Creamos un boton para el gerente
		geren = new JButton("Gerente");
		geren.addActionListener(this);
		panel.add(geren,BorderLayout.EAST);
		
		//Creamos un boton para volver al menu
		volver = new JButton("Volver al menu");
		volver.addActionListener(this);
		panel.add(volver,BorderLayout.SOUTH);
		
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
		
		if(e.getSource() == clie) {
			setVisible(false);
			new IntRegistrarse(1, Aux); //Se lanza la interfaz para registrarse indicando que se va a registrar un cliente
		}
		else if(e.getSource() == geren) {
			setVisible(false);
			new IntRegistrarse(0, Aux); //Se lanza la interfaz para registrarse indicando que se va a registrar un gerente
		}
		else if(e.getSource() == volver) {
			setVisible(false);
			new IntMenuGeneral(Aux);
		}
		
	}
}
