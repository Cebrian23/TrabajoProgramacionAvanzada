package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para actualizar la informacion
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntActInfo extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiquetas usadas en la interfaz para el nombre de la persona
	 */
	private JLabel nombre,
	/**
	 * Etiquetas usadas en la interfaz para los apellidos de la persona
	 */
	apellidos,
	/**
	 * Etiquetas usadas en la interfaz para el correo de la persona
	 */
	correo,
	/**
	 * Etiquetas usadas en la interfaz para el password de la persona
	 */
	password,
	/**
	 * Etiquetas usadas en la interfaz para la direccion del cliente
	 */
	direccion,
	/**
	 * Etiquetas usadas en la interfaz para el nombre de la tienda del gerente
	 */
	tiendaN;
	/**
	 * Campos de texto usados en la interfaz para el nombre de la persona
	 */
	private JTextField campo1,
	/**
	 * Campos de texto usados en la interfaz para los apellidos de la persona
	 */
	campo2,
	/**
	 * Campos de texto usados en la interfaz para el correo de la persona
	 */
	campo3,
	/**
	 * Campos de texto usados en la interfaz para la direccion del cliente
	 */
	campo5,
	/**
	 * Campos de texto usados en la interfaz para el nombre de la tienda del gerente
	 */
	campo6;
	/**
	 * Campo de password usado en la interfaz para el password de la persona
	 */
	private JPasswordField campo4;
	/**
	 * Boton usado en la interfaz para aceptar los cambios en el perfil de la persona
	 */
	private JButton aceptar,
	/**
	 * Boton usado en la interfaz para volver al menu del cliente
	 */
	volverC,
	/**
	 * Boton usado en la interfaz para volver al menu del gerente
	 */
	volverG;
	/**
	 * Cliente al que se le van a modificar sus datos
	 */
	private Cliente C_aux;
	/**
	 * Gerente al que se le van a modificar sus datos
	 */
	private Gerente G_aux;
	/**
	 * Es el ArrayList del que provienen el cliente y el gerente
	 */
	private ArrayList<Persona> P_aux;
	/**
	 * String usado para almacenar el ID de la persona insertada en el constructor
	 */
	private String ID;
	
	/**
	 * Constructor de la interfaz
	 * @param cliente Se le pasa por argumento el cliente al que se le van a modificar sus atributos
	 * @param pers Es el ArrayList del que proviene el cliente
	 */
	public IntActInfo(Cliente cliente, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Actualizar Informacion Cliente");
		setSize(410,200); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ID = cliente.ID(); //Establecemos como ID el ID del gerente
		C_aux = cliente;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(6,//nº filas
				   					   2,//nº columnas
				   					   2,
				   					   2
									   ));
		
		//Creamos la etiqueta para el nombre
		nombre = new JLabel("Escribe tu nuevo nombre: ");
		panel.add(nombre);
		
		//Creamos el campo para escribir el nombre
		campo1 = new JTextField(C_aux.getNombre());
		panel.add(campo1);
		
		//Creamos la etiqueta para los apellidos
		apellidos = new JLabel("Escribe tus nuevos apellidos: ");
		panel.add(apellidos);
		
		//Creamos el campo para escribir los apellidos
		campo2 = new JTextField(C_aux.getApellidos());
		panel.add(campo2);
		
		//Creamos la etiqueta para el correo
		correo = new JLabel("Escribe tu nuevo correo: ");
		panel.add(correo);
		
		//Creamos el campo para escribir el correo
		campo3 = new JTextField(C_aux.getCorreo());
		panel.add(campo3);
		
		//Creamos la etiqueta para el password
		password = new JLabel("Escribe tu nuevo password: ");
		panel.add(password);
		
		//Creamos el campo para escribir el password
		campo4 = new JPasswordField(C_aux.getPassword());
		panel.add(campo4);
		
		//Creamos la etiqueta para la direccion
		direccion = new JLabel("Escribe tu nueva direccion: ");
		panel.add(direccion);
		
		//Creamos el campo para escribir la direccion
		campo5 = new JTextField(C_aux.getDireccion());
		panel.add(campo5);
		
		//Creamos un boton para aceptar los cambios
		aceptar = new JButton("Aceptar cambios");
		aceptar.addActionListener(this);
		panel.add(aceptar);
		
		//Creamos un boton para volver al menu sin hacer cambios
		volverC = new JButton("Volver al menu");
		volverC.addActionListener(this);
		panel.add(volverC);
		
		//Agregamos el panel al JFrame
		getContentPane().add(panel);
										
		//Hacer visible la ventana
		setVisible(true);
	}
	
	/**
	 * Constructor de la interfaz
	 * @param gerente Se le pasa por argumento el cliente al que se le van a modificar sus atributos
	 * @param pers Es el ArrayList del que proviene el gerente
	 */
	public IntActInfo(Gerente gerente, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Actualizar Informacion Gerente");
		setSize(460,200); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ID = gerente.ID(); //Establecemos como ID el ID del gerente
		G_aux = gerente;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();		
		panel.setLayout(new GridLayout(6,//nº filas
				   					   2,//nº columnas
				   					   2,
				   					   2
				   					   ));
		
		//Creamos la etiqueta para el nombre
		nombre = new JLabel("Escribe tu nuevo nombre: ");
		panel.add(nombre);
		
		//Creamos el campo para escribir el nombre
		campo1 = new JTextField(G_aux.getNombre());
		panel.add(campo1);
		
		//Creamos la etiqueta para los apellidos
		apellidos = new JLabel("Escribe tus nuevos apellidos: ");
		panel.add(apellidos);
		
		//Creamos el campo para escribir los apellidos
		campo2 = new JTextField(G_aux.getApellidos());
		panel.add(campo2);
		
		//Creamos la etiqueta para el correo
		correo = new JLabel("Escribe tu nuevo correo: ");
		panel.add(correo);
		
		//Creamos el campo para escribir el correo
		campo3 = new JTextField(G_aux.getCorreo());
		panel.add(campo3);
		
		//Creamos la etiqueta para el password
		password = new JLabel("Escribe tu nuevo password: ");
		panel.add(password);
		
		//Creamos el campo para escribir el password
		campo4 = new JPasswordField(G_aux.getPassword());
		panel.add(campo4);
		
		//Creamos la etiqueta para el nombre de la tienda
		tiendaN = new JLabel("Escribe el nuevo nombre de tu tienda: ");
		panel.add(tiendaN);
		
		//Creamos el campo para escribir el nombre de la tienda
		campo6 = new JTextField(G_aux.getShop().getNombre());
		panel.add(campo6);
		
		//Creamos un boton para aceptar los cambios
		aceptar = new JButton("Aceptar cambios");
		aceptar.addActionListener(this);
		panel.add(aceptar);
		
		//Creamos un boton para volver al menu
		volverG = new JButton("Volver al menu");
		volverG.addActionListener(this);
		panel.add(volverG);
		
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
		String nom,apel,cor,pas;
		String dire,tien;
		
		if(e.getSource() == aceptar) {			
			nom = campo1.getText(); //Inicializamos la variable del nombre de la persona
			apel = campo2.getText(); //Inicializamos la variable de los apellidos de la persona
			cor = campo3.getText(); //Inicializamos la variable del correo de la persona
			pas = new String(campo4.getPassword()); //Inicializamos la variable del password de la persona
			
			if(nom.length() == 0 || apel.length() == 0 || cor.length() == 0 || pas.length() == 0) {
				// Mensaje de error: Las variables estan vacias
				JOptionPane.showMessageDialog(this, "Error. Alguno de los campos esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
				// Mostrar la ventana de registro nuevamente
				setVisible(true);
				//El return es para que no se abra el menu y se siga quedando en la de Actualizar Info
				return;
			}
			else {
				if(ID == "Cliente") {				
					dire = campo5.getText(); //Inicializamos la variable de la direccion del cliente
					
					if(dire.length() == 0) {
						// Mensaje de error: La variable esta vacia
						JOptionPane.showMessageDialog(this, "Error. Alguno de los campos esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
						// Mostrar la ventana de registro nuevamente
						setVisible(true);
						//El return es para que no se abra el menu y se siga quedando en la de Actualizar Info
						return;
					}
					else {
						C_aux.actualizarInfo(nom, apel, cor, pas, dire);
						
						setVisible(false);
						new IntMenuCliente(C_aux,P_aux);
					}
				}
				else if(ID == "Gerente"){				
					tien = campo6.getText(); //Inicializamos la variable del nombre de la tienda del gerente
					
					if(tien.length() == 0) {
						// Mensaje de error: La variable esta vacia
						JOptionPane.showMessageDialog(this, "Error. Alguno de los campos esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
						// Mostrar la ventana de registro nuevamente
						setVisible(true);
						//El return es para que no se abra el menu y se siga quedando en la de Login
						return;
					}
					else {
						G_aux.actualizarInfo(nom, apel, cor, pas, tien);
						
						setVisible(false);
						new IntMenuGerente(G_aux,P_aux);
					}
				}
			}
		}
		else if(e.getSource() == volverC) {
			setVisible(false);
			new IntMenuCliente(C_aux,P_aux);
		}
		else if(e.getSource() == volverG) {
			setVisible(false);
			new IntMenuGerente(G_aux,P_aux);
		}
	}
}
