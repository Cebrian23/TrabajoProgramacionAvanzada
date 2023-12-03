package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para registrar a una Persona
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntRegistrarse extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada para el nombre de la persona
	 */
	private JLabel nombre,
	/**
	 * Etiqueta usada para el apellido de la persona
	 */
	apellidos,
	/**
	 * Etiqueta usada para el correo de la persona
	 */
	correo,
	/**
	 * Etiqueta usada para el password de la persona
	 */
	password1,
	/**
	 * Etiqueta usada para la verificacion del password de la persona
	 */
	password2,
	/**
	 * Etiqueta usada para la direccion del cliente
	 */
	direccion,
	/**
	 * Etiqueta usada para el password de la tienda
	 */
	passwordT;
	/**
	 * Campo de texto usado para el nombre de la persona
	 */
	private JTextField campo1,
	/**
	 * Campo de texto usado para los apellidos de la persona
	 */
	campo2,
	/**
	 * Campo de texto usado para el correo de la persona
	 */
	campo3,
	/**
	 * Campo de texto usado para la direccion del cliente
	 */
	campo6;
	/**
	 * Campo de password usado para el password
	 */
	private JPasswordField campo4,
	/**
	 * Campo de password usado para la verificacion del password
	 */
	campo5,
	/**
	 * Campo de password usado para el password de la tienda
	 */
	campo7;
	/**
	 * Boton usado para registrar al cliente o al gerente
	 */
	private JButton aceptar,
	/**
	 * Boton usado para volver a la interfaz de seleccion de la persona que se va a registrar
	 */
	volver;
	/**
	 * Es un String que sirve para identificar si la persona que se va a registrar es un cliente o un gerente
	 */
	private String aux_ID;
	/**
	 * Array con las personas registradas hasta el momento y en el que se insertara la nueva persona
	 */
	private ArrayList<Persona> Aux;
	/**
	 * Es la tienda que se le asignara al nuevo gerente
	 */
	private Tienda T_aux;
	/**
	 * Sirve para la creacion del cliente y el gerente
	 */
	private Factory fact;
	
	/**
	 * Constructor de la Interfaz para registrar a una Persona
	 * @param num Es un numero que sirve para saber si se está registrando un cliente (1) o un gerente (0)
	 * @param personas Es un array con todas las personas que hay y al que se le va a insertar el nuevo cliente o gerente
	 */
	public IntRegistrarse(int num, ArrayList<Persona> personas) {
		/*
		 * Configuramos los parametros de la ventana
		 * Si la variable "num" es 1, la persona es un cliente
		 */
		if(num == 1) {
			setTitle("Registrar Cliente");
			aux_ID = "Cliente";
		}
		//Si la variable "num" es 0, la persona es un gerente
		else {
			setTitle("Registrar Gerente");
			aux_ID = "Gerente";
		}
		setSize(400,275); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Aux = personas; //Apuntamos a la direccion de al array de entrada
		//N_Aux = num; //Guardamos en una variable auxiliar si la persona que vamos a registrar es un cliente o un gerente
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,//nº filas
				   					   2,//nº columnas
				   					   2,//espacios horizontales
				   					   2 //espacios verticales
				   					   ));
		
		
		//Comprobamos si hay un gerente y si lo hay, apuntamos a su tienda
		for(Persona x:Aux) {
			if(x.ID() == "Gerente") {
				Gerente geren = (Gerente) x;
				T_aux = geren.getShop();
			}
		}
		
		//Creamos la etiqueta para el nombre de la persona
		nombre = new JLabel("Escribe tu nombre: ");
		panel.add(nombre);
		
		//Creamos el campo para el nombre de la persona
		campo1 = new JTextField(15);
		panel.add(campo1);
		
		//Creamos la etiqueta para los apellidos de la persona
		apellidos = new JLabel("Escribe tus apellidos: ");
		panel.add(apellidos);
		
		//Creamos el campo para los apellidos de la persona
		campo2 = new JTextField(15);
		panel.add(campo2);
		
		//Creamos la etiqueta para el correo de la persona
		correo = new JLabel("Escribe tu correo: ");
		panel.add(correo);
		
		//Creamos el campo para el correo de la persona
		campo3 = new JTextField(15);
		panel.add(campo3);
		
		//Creamos la etiqueta para el password de la persona
		password1 = new JLabel("Escribe tu password: ");
		panel.add(password1);
		
		//Creamos el campo para el password de la persona
		campo4 = new JPasswordField(15);
		panel.add(campo4);
		
		//Creamos la etiqueta para verificar el password de la persona
		password2 = new JLabel("Vuelve a escribir el password: ");
		panel.add(password2);
		
		//Creamos el campo para la verificacion del password de la persona
		campo5 = new JPasswordField(15);
		panel.add(campo5);
		
		//Creamos un boton para aceptar los cambios realizados
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		
		//Creamos un boton para volver a la seleccion de persona
		volver = new JButton("Volver a la seleccion");
		volver.addActionListener(this);
		
		//Creamos los elementos para escribir la direccion, en caso de que sea un cliente
		if(num == 1) {
			direccion = new JLabel("Escribe tu direccion: ");
			panel.add(direccion);
			
			campo6 = new JTextField(15);
			panel.add(campo6);
		}
		//Se agregan los elementos para escribir el nombre de la tienda, en caso de que sea un gerente
		else {
			passwordT = new JLabel("Escribe el password de la tienda: ");
			panel.add(passwordT);
			
			campo7 = new JPasswordField(15);
			panel.add(campo7);
		}
		
		panel.add(aceptar);
		panel.add(volver);
		
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
		//Variables auxiliares
		String nom,apel,cor,pass,pass2,direc,passt;
		
		if(e.getSource() == aceptar) {
			nom = campo1.getText(); //Inicializamos la variable del nombre de la persona
			apel = campo2.getText(); //Inicializamos la variable de los apellidos de la persona
			cor = campo3.getText(); //Inicializamos la variable del correo de la persona
			pass = new String(campo4.getPassword()); // Inicializamos la variable de la contraseña de la persona
			pass2 = new String(campo5.getPassword()); //Inicializamos la variable de la comprobacion de la contrasela de la persona
			
			//Verificamos si todos los campos estan vacios
			if(nom.length() == 0 || apel.length() == 0 || cor.length() == 0 || pass.length() == 0 || pass2.length() == 0) {
				// Mensaje de error: Las variables estan vacias
				JOptionPane.showMessageDialog(this, "Error. Alguno de los campos esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
				// Mostrar la ventana de registro nuevamente
				setVisible(true);
				//El return es para que no se abra el menu y se siga quedando en la de Registro
				return;
			}
			//En caso de que todos tengan algun caracter
			else {
				//Comprobamos si la persona es un cliente
				if(aux_ID == "Cliente") {
					fact = new FactoryCliente();
					Cliente cliente;
					
					//Comprobamos la contraseña y su verificacion son iguales
					if(pass.equals(pass2)) {
						direc = campo6.getText(); //Inicializamos la variable de la direccion del cliente
						
						//Compobamos si el campo de la direccion del cliente esta vacia
						if(direc.length() == 0) {
							// Mensaje de error: El campo esta vacio
							JOptionPane.showMessageDialog(this, "Error. El campo esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
							// Mostrar la ventana de registro nuevamente
							setVisible(true);
							//El return es para que no se abra el menu y se siga quedando en la de Registro
							return;
						}
						else {
							cliente = new Cliente((Cliente)fact.CrearYMostrar(nom, apel, cor, pass, direc, T_aux));
						
							Aux.add(cliente);
							System.out.println("Numero de personas registradas: " + Aux.size() + " personas");
							
							setVisible(false);
							new IntMenuCliente(cliente,Aux);
						}
					}
					else {
						// Mensaje de error: Contraseña y su verificación no son iguales
						JOptionPane.showMessageDialog(this, "Error. Las password no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
						// Mostrar la ventana de registro nuevamente
						setVisible(true);
						//El return es para que no se abra el menu y se siga quedando en la de Registro
						return;
					}
				}
				//Si no es un cliente, comprobamos si es un gerente
				else if (aux_ID == "Gerente"){
					fact = new FactoryGerente();
					Gerente gerente;
					
					//Comprobamos que el correo y su verificacion son iguales
					if(pass.equals(pass2)) {
						passt = new String (campo7.getPassword());
						
						if(passt.length() == 0) {
							// Mensaje de error: Contraseña y su verificación no son iguales
							JOptionPane.showMessageDialog(this, "Error. El campo esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
							// Mostrar la ventana de registro nuevamente
							setVisible(true);
							//El return es para que no se abra el menu y se siga quedando en la de Registro
							return;
						}
						else {
							//Comprobamos que el campo del password de la tienda sea igual al de de la tienda
							if(passt.equals(T_aux.getPassword())) {
								gerente = new Gerente((Gerente)fact.CrearYMostrar(nom, apel, cor, pass, " ", T_aux));
								gerente.setShop(T_aux);
								
								Aux.add(gerente);
								System.out.println("Numero de personas registradas: " + Aux.size() + " personas");
								
								setVisible(false);
								new IntMenuGerente(gerente,Aux);
							}
							else {
								// Mensaje de error: Contraseña y su verificación no son iguales
								JOptionPane.showMessageDialog(this, "Error. Parece que el password de la tienda es otra", "Error", JOptionPane.ERROR_MESSAGE);
								// Mostrar la ventana de registro nuevamente
								setVisible(true);
								//El return es para que no se abra el menu y se siga quedando en la de Registro
								return;
							}
						}
					}
					else {
						// Mensaje de error: Contraseña y su verificación no son iguales
						JOptionPane.showMessageDialog(this, "Error. Las password no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
						// Mostrar la ventana de registro nuevamente
						setVisible(true);
						//El return es para que no se abra el menu y se siga quedando en la de Registro
						return;
					}
				}
			}
		}
		else if(e.getSource() == volver) {
			setVisible(false);
			new IntSelecPersona(Aux); //Volvemos al menu
		}
	}
	
}
