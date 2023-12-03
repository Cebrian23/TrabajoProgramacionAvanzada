package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para hacer login
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntLogin extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz para el correo
	 */
	private JLabel correo,
	/**
	 * Etiqueta usada en la interfaz para el password
	 */
	password1;
	/**
	 * Campo de texto usado en la interfaz para el correo
	 */
	private JTextField campo1;
	/**
	 * Campo de password usado en la interfaz para el password
	 */
	private JPasswordField campo2;
	/**
	 * Boton usado en la interfaz para continuar con el logueo
	 */
	private JButton continuar,
	/**
	 * Boton usado en la interfaz para volver al menu general
	 */
	volver;
	/**
	 * Array con todas las personas registradas en la "base de datos" hasta el momento
	 */
	private ArrayList<Persona> Aux;

	
	/**
	 * Método de la interfaz para logearse
	 * @param personas Es un ArrayList con todas las personas dadas de alta hasta el momento
	 */
	public IntLogin(ArrayList<Persona> personas) {
		//Configuramos los parametros de la ventana
		setTitle("Login");
		setSize(375,125); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Aux = personas; //Apuntamos a la direccion de al array de entrada
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,//nº filas
									   2, //nº columnas
									   2,
									   2
									   ));
		
		//Creamos una etiqueta para el correo
		correo = new JLabel("Escribe tu correo: ");
		panel.add(correo);
		
		//Creamos un campo para escribir el correo
		campo1 = new JTextField(5);
		panel.add(campo1);
		
		//Creamos una etiqueta para el password
		password1 = new JLabel("Escribe tu password: ");
		panel.add(password1);
		
		//Creamos un campo para escribir el password
		campo2 = new JPasswordField(15);
		panel.add(campo2);
		
		//Creamos un boton para loguearse
		continuar = new JButton("Aceptar");
		continuar.addActionListener(this);
		panel.add(continuar);
		
		//Creamos un boton para volver al menu
		volver = new JButton("Volver al menu");
		volver.addActionListener(this);
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
		//Variable auxiliar
		String cor,pass;
		
		if(e.getSource() == continuar) {
			cor = campo1.getText(); //Inicializamos la variable del correo 
			pass = new String (campo2.getPassword()); //Inicializamos la variable del password
			
			//Se verifica si las variables del correo y/o del password estan vacias
			if(cor.length() == 0 || pass.length() == 0) {
				// Mensaje de error: Las variables estan vacias
				JOptionPane.showMessageDialog(this, "Error. Alguno de los campos esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
				// Mostrar la ventana de registro nuevamente
				setVisible(true);
				//El return es para que no se abra el menu y se siga quedando en la de Login
				return;
			}
			else {
				/*
				 * En caso de que ambos tengan caracteres, se itera con un bucle en el ArrayList
				 * para encontrar a la persona deseada
				 */
				for(int x=0;x<Aux.size();x++) {
					/*
					 * Si hay una coincidencia de ambas variables,
					 * se crea una variable del tipo que sea la persona que se ha logueado
					 */
					if(Aux.get(x).getCorreo().equals(cor) && Aux.get(x).getPassword().equals(pass)) {
						setVisible(false);
						//Se verifica si es un cliente y se lanza la interfaz del menu para el cliente
						if(Aux.get(x).ID() == "Cliente") {
							Cliente aux1 = (Cliente) Aux.get(x);
							new IntMenuCliente(aux1,Aux);
						}
						//En caso de que sea un gerente, se hace lo mismo, pero para el gerente
						else if(Aux.get(x).ID() == "Gerente") {
							
							Gerente aux2 =(Gerente) Aux.get(x);
							new IntMenuGerente(aux2,Aux);
						}
						break;
					}
					//En caso de que se llegue al ultimo elemento y no sea y no sea el apropiado se vuelve a lanzar la interfaz
					else {
						if(x == Aux.size()-1) {
							// Mensaje de error: No se ha encontrado a la persona buscada
							JOptionPane.showMessageDialog(this, "Error. Parece que la persona buscada no existe"
														  + ", el correo o el password pueden ser los incorrectos",
														  "Error", JOptionPane.ERROR_MESSAGE);
							// Mostrar la ventana de registro nuevamente
							setVisible(true);
							//El return es para que no se abra el menu y se siga quedando en la de Login
							return;
						}
					}
				}
			}
		}
		else if(e.getSource() == volver) {
			setVisible(false);
			new IntMenuGeneral(Aux);
		}
	}
}
