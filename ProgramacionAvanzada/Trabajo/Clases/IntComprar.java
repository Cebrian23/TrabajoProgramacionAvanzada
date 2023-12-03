package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para poder comprar
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntComprar extends JFrame implements ActionListener  {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz para mostrar un mensaje
	 */
	private JLabel etiqueta,
	/**
	 * Etiqueta usada en la interfaz para el precio de la compra
	 */
	precio;
	/**
	 * Boton usado en la interfaz para comprar
	 */
	private JButton aceptar,
	/**
	 * Boton usado en la interfaz para volver al menu sin comprar
	 */
	volver;
	/**
	 * Lista usada para mostrar todos los productos
	 */
	private JList<String> lista;
	/**
	 * Panel de desplazamiento que contiene a la lista
	 */
	private JScrollPane scroll;
	/**
	 * Es el cliente propietario del carrito
	 */
	private Cliente C_aux;
	/**
	 * Array del que proviene el cliente
	 */
	private ArrayList<Persona> P_aux;
	
	/**
	 * Constructor
	 * @param clie Es el usuario propietario del carrito
	 * @param pers Es el ArrayList del que procede el cliente
	 */
	public IntComprar(Cliente clie, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Comprar");
		setSize(850,250); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		C_aux = clie;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,//nº filas
						   			   1, //nº columnas
						   			   2,
						   			   2
									   ));
		
		//Creamos un boton para volver sin comprar
		volver = new JButton("Volver sin comprar");
		volver.addActionListener(this);
		
		if(C_aux.getCarrito().getCarrito().size() == 0) {
			//Creamos una etiqueta
			etiqueta = new JLabel("El carrito esta vacio");
			panel.add(etiqueta);
			
			panel.add(volver);
		}
		else {
			//Creamos una etiqueta
			etiqueta = new JLabel("¿Desea comprar los siguientes productos?: ");
			panel.add(etiqueta);
			
			//Variable auxiliar que servira para inicializar el JList y almacenar los nombre de los productos a comprar
			String[] variable = new String[C_aux.getCarrito().getCarrito().size()];
			
			//Iteramos en el bucle para extraer el nombre del producto que se va a comprar
			for(int x = 0; x < C_aux.getCarrito().getCarrito().size(); x++) {
				String aux = (x+1)+". "+C_aux.getCarrito().getCarrito().get(x).getNombre();
				
				variable[x] = aux;
			}
			
			lista = new JList<String>(variable); //Inicializamos la lista
			scroll = new JScrollPane(lista);
			panel.add(scroll);
			
			//Redondeamos el importe del pedido
			double num_aux = Math.round(C_aux.getCarrito().getCoste()*100.0)/100.0;
			
			//Creamos la etiqueta para mostrar el precio de la compra
			precio = new JLabel("El importe de la compra es: " + num_aux + "€");
			panel.add(precio);
			
			//Creamos un boton para comprar
			aceptar = new JButton("Comprar");
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
		if(e.getSource() == aceptar) {
			/* 
			 * COMPROBAR
			 * Se comprueba si se puede hacer la compra
			 */
			if(C_aux.getSaldo() > C_aux.getCarrito().getCoste()) {
				C_aux.comprar();
				
				System.out.println("Pedidos pendientes: " + C_aux.getPedidos().size() + " pedidos");
				
				JOptionPane.showMessageDialog(this, "La compra se ha efectuado correctamente",
					  "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "La compra NO se ha efectuado correctamente. Dinero en la cuenta insuficiente",
						  "Compra Fallida", JOptionPane.INFORMATION_MESSAGE);
			}
			setVisible(false);
			new IntMenuCliente(C_aux,P_aux);
		}
		else if(e.getSource() == volver) {
			setVisible(false);
			new IntMenuCliente(C_aux,P_aux);
		}
	}
	
}
