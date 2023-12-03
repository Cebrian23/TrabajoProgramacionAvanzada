package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz que servira para eliminar un pedido
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntCancelarPedido extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Es una lista con todos los pedidos que ha realizado el cliente
	 */
	private JList<String> lista;
	/**
	 * Es el panel de desplazamiento que contiene la lista de pedidos
	 */
	private JScrollPane scroll;
	/**
	 * Etiqueta usada en la interfaz para la posicion del pedido que se va a cancelar
	 */
	private JLabel pos,
	/**
	 * Etiqueta usada en la interfaz para mostrar un mensaje
	 */
	mensaje;
	/**
	 * Variable que se usa para establecer la posicion del pedido que se va a cancelar
	 */
	private JSpinner spinner;
	/**
	 * Boton usado en la interfaz para aceptar la cancelacion del pedido
	 */
	private JButton aceptar,
	/**
	 * Boton usado en la interfaz para volver al menu del cliente
	 */
	volver;
	/**
	 * Es el cliente poseedor de los pedidos
	 */
	private Cliente C_aux;
	/**
	 * Es el ArrayList del que proviene el cliente
	 */
	private ArrayList<Persona> P_aux;
	
	/**
	 * Constructor para eliminar un pedido
	 * @param clien Es el cliente que quiere cancelar un pedido
	 * @param pers Es el ArrayList del que proviene el cliente
	 */
	public IntCancelarPedido(Cliente clien,ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Eliminar Pedido");
		setSize(850,350); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,//nº filas
				   				 1, //nº columnas
				   				 2,
				   				 2
				   				 ));
		
		C_aux = clien;
		P_aux = pers;
		
		//Creamos un boton para volver al menu del cliente
		volver = new JButton("Volver al menu");
		volver.addActionListener(this);
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,//nº filas
				   					   2, //nº columnas
				   					   2,
				   					   2
									   ));
		
		if(C_aux.getPedidos().size() == 0) {
			//Creamos la etiqueta para el mensaje
			mensaje = new JLabel("Aun no se ha realizado ningun pedido");
			add(mensaje);
			
			add(volver);
		}
		else {
			//Creamos la etiqueta para el mensaje
			mensaje = new JLabel("Los pedidos realizados hasta el momento son los siguientes:");
			add(mensaje);
			
			String[] var_aux = new String[C_aux.getPedidos().size()];
			
			/*
			 * Bucle "for()" para almacenar en un vector el nombre del producto, su ID y su precio
			 * para luego mostrarlos en un JList
			 */
			for(int x = 0; x < C_aux.getPedidos().size(); x++) {	
				//Redondeamos el precio del Pedido a dos decimales
				double num_aux = Math.round(C_aux.getPedidos().get(x).getCoste()*100.0)/100.0;
				
				String aux = (x+1) +". Pedido con ID " + C_aux.getPedidos().get(x).getID() + 
						 	 " y un precio de " + num_aux + "€";
				
				var_aux[x] = aux;
			}
			
			lista = new JList<String>(var_aux); //Inicializamos la lista
			scroll = new JScrollPane(lista);
			add(scroll);
			
			//Creamos la etiqueta para la posicion del pedido
			pos = new JLabel("Escribe la posicion del pedido que quieras eliminar: ");
			panel.add(pos);
			
			//Creamos un campo para seleccionar el precio del producto
			SpinnerModel item = new SpinnerNumberModel(1, //Valor inicial
													   1, //Valor minimo
													   1000, //Valor maximo
													   1 //En cuanto se aumenta o disminuye
													   );
			spinner = new JSpinner(item);
			spinner.setBounds(50,50,50,30);
			panel.add(spinner);
			
			//Creamos un boton para aceptar la cancelacion
			aceptar = new JButton("Aceptar");
			aceptar.addActionListener(this);
			panel.add(aceptar);
			
			panel.add(volver);
		}
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
		int posic;
		
		if(e.getSource() == aceptar) {
			posic = (int)spinner.getValue(); //Convertimos en entero la posicion del pedido
			
			try {
				
				
				try {
					C_aux.cancelarPedido(posic-1);
					JOptionPane.showMessageDialog(this, "El pedido ha sido cancelado correctamente",
							"Cancelacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
					
					System.out.println("Quedan " + C_aux.getPedidos().size() + " pedidos");
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this, ex.getMessage(),
							"Cancelacion Fallida", JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex.getMessage());
				}
				
				setVisible(false);
				new IntMenuCliente(C_aux,P_aux);
			} catch (Exception ex1) {
				System.out.println(ex1.getMessage());
			}
		}
		else if(e.getSource() == volver) {
			setVisible(false);
			new IntMenuCliente(C_aux,P_aux);
		}
	}
}
