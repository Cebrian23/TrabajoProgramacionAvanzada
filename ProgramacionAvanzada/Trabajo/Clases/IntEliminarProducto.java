package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz que servira para eliminar un producto de cualquier ArrayList
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntEliminarProducto extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Es la lista en la que se almacena el nombre de los productos del carrito
	 */
	private JList<String> listaC,
	/**
	 * Es la lista en la que se almacena el nombre de los productos de la tienda
	 */
	listaT;
	/**
	 * Es el panel de desplazamiento que contiene la lista del carrito de la compra del cliente
	 */
	private JScrollPane scrollC,
	/**
	 * Es el panel de desplazamiento que contiene la lista de la tienda del gerente
	 */
	scrollT;
	/**
	 * Etiqueta usada en la interfaz para imprimir un mensaje
	 */
	private JLabel mensaje,
	/**
	 * Etiqueta usada en la interfaz la posicion del producto que se quiere eliminar
	 */
	posic;
	/**
	 * Variable que se usa para establecer la posicion del producto que se quiere eliminar
	 */
	private JSpinner spinner;
	/**
	 * Boton usado en la interfaz para aceptar la eliminacion del producto del carrito del cliente
	 */
	private JButton aceptarC,
	/**
	 * Boton usado en la interfaz para aceptar la eliminacion del producto de la tienda del gerente
	 */
	aceptarG,
	/**
	 * Boton usado en la interfaz para volver al menu del cliente
	 */
	volverC,
	/**
	 * Boton usado en la interfaz para volver al menu del gerente
	 */
	volverG;
	/**
	 * Es el cliente propietario del carrito del que se va a eliminar el producto
	 */
	private Cliente C_aux;
	/**
	 * Es el carrito del que se va a eliminar el producto
	 */
	private Carrito Car_aux;
	/**
	 * Es el gerente de la tienda de la que se va a eliminar el producto
	 */
	private Gerente G_aux;
	/**
	 * Es la tienda de la que se va a eliminar el producto
	 */
	private Tienda T_aux;
	/**
	 * Es el ArrayList del que provienen tanto el gerente como el cliente
	 */
	private ArrayList<Persona> P_aux;

	/**
	 * Constructor para eliminar un producto del carrito
	 * @param carr Es el carrito del que se va a eliminar el producto
	 * @param cliente Es el cliente propietario del carrito
	 * @param pers Es el ArrayList del que procede el gerente
	 */
	public IntEliminarProducto(Carrito carr,Cliente cliente,ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Eliminar Producto del Carrito");
		setSize(450,350); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,//nº filas
								 1, //nº columnas
								 2,
								 2
				   				 ));
		
		Car_aux = carr;
		C_aux = cliente;
		P_aux = pers;		
		
		//Creamos un boton para volver al menu del cliente
		volverC = new JButton("Volver al menu");
		volverC.addActionListener(this);
		
		if(Car_aux.getCarrito().size() == 0) {
			//Creamos la etiqueta para el mensaje
			mensaje = new JLabel("No hay ningun producto que eliminar");
			add(mensaje);
			
			add(volverC);
		}
		else {
			//Creamos la etiqueta para el mensaje
			mensaje = new JLabel("En el carrito estan los siguientes productos:");
			add(mensaje);
			
			String[] V_aux = new String[Car_aux.getCarrito().size()];
			
			/*
			 * Se itera con un bucle "for()" en el carrito para poder extraer
			 * el nombre, el ID y el precio del producto del carrito
			 */
			for(int x = 0; x < Car_aux.getCarrito().size(); x++) {
				String aux = (x+1) + ". " + Car_aux.getCarrito().get(x).getNombre();
				V_aux[x] = aux; 
			}
			
			listaC = new JList<String>(V_aux); //Inicializamos la lista
			scrollC = new JScrollPane(listaC);
			add(scrollC);
					
			//Creamos un panel
			panel = new JPanel();
			panel.setLayout(new GridLayout(2,//nº filas
										   2, //nº columnas
										   2,
										   2
										   ));
			
			//Creamos la etiqueta para el id
			posic = new JLabel("Escribe la posicion del producto que quieras eliminar: ");
			panel.add(posic);
			
			//Creamos un campo para seleccionar el precio del producto
			SpinnerModel item = new SpinnerNumberModel(1, //Valor inicial
													   1, //Valor minimo
													   1000, //Valor maximo
													   1 //En cuanto se aumenta o disminuye
													   );
			spinner = new JSpinner(item);
			spinner.setBounds(50,50,50,30);
			panel.add(spinner);
			
			//Creamos un boton para aceptar la eliminacion del producto
			aceptarC = new JButton("Aceptar");
			aceptarC.addActionListener(this);
			panel.add(aceptarC);
			
			panel.add(volverC);
			
			//Agregamos el panel al JFrame
			getContentPane().add(panel);
		}
										
		//Hacer visible la ventana
		setVisible(true);
	}
	
	/**
	 * Constructor para eliminar un producto de la tienda
	 * @param tien Es la tienda de la que se va a eliminar el producto
	 * @param geren Es el gerente de la tienda
	 * @param pers Es el ArrayList del que procede el gerente
	 */
	public IntEliminarProducto(Tienda tien,Gerente geren,ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Eliminar Producto de la Tienda");
		setSize(450,250); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,//nº filas
				   				 1,//nº columnas
				   				 2,
				   				 2
				   				 ));
		
		T_aux = tien;
		G_aux = geren;
		P_aux = pers;
		
		//Creamos un boton para volver al menu del cliente
		volverG = new JButton("Volver al menu");
		volverG.addActionListener(this);
		
		if(T_aux.getProductos().size() == 0) {
			//Creamos la etiqueta para el mensaje
			mensaje = new JLabel("No hay ningun producto que eliminar");
			add(mensaje);
			
			add(volverG);
		}
		else {
			//Creamos la etiqueta para el mensaje
			mensaje = new JLabel("No hay ningun producto que eliminar");
			add(mensaje);
			
			String[] V_aux = new String[T_aux.getProductos().size()];
		
			/*
		 	* Se itera con un bucle "for()" en el carrito para poder extraer
		 	* el nombre, el ID y el precio del producto de la tienda
		 	*/
			for(int x = 0; x < T_aux.getProductos().size(); x++) {
				String aux = (x+1) + ". " + T_aux.getProductos().get(x).getNombre();
				
				V_aux[x] = aux; 
			}
		
			listaT = new JList<String>(V_aux); //Inicializamos la lista
			scrollT = new JScrollPane(listaT);
			add(scrollT);
		
			//Creamos un panel
			panel = new JPanel();
			panel.setLayout(new GridLayout(2,//nº filas
				   					   	   2,//nº columnas
				   					   	   2,
				   					   	   2
				   					   	   ));
		
			//Creamos la etiqueta para la posicion del producto
			posic = new JLabel("Escribe la posicion del producto que quieras eliminar: ");
			panel.add(posic);
		
			//Creamos un campo para seleccionar la posicion del producto
			SpinnerModel item = new SpinnerNumberModel(1, //Valor inicial
												   	   1, //Valor minimo
												   	   1000, //Valor maximo
												   	   1 //En cuanto se aumenta o disminuye
												   	   );
			spinner = new JSpinner(item);
			spinner.setBounds(50,50,50,30);
			panel.add(spinner);
				
			//Creamos un boton para aceptar la eliminacion del producto
			aceptarG = new JButton("Aceptar");
			aceptarG.addActionListener(this);
			panel.add(aceptarG);
			
			panel.add(volverG);
				
			//Agregamos el panel al JFrame
			getContentPane().add(panel);
		}
		
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
		int pos;
		
		if(e.getSource() == aceptarC) {
			pos = (int)spinner.getValue(); //Convertimos en entero el ID del producto
			
			try {
				C_aux.eliminarProducto(pos-1); //Usamos la funcion para eliminar el producto
			} catch (Exception ex1) {
				JOptionPane.showMessageDialog(this, ex1.getMessage(),
						"Eliminacion Fallida", JOptionPane.INFORMATION_MESSAGE);
				System.out.println(ex1.getMessage());
			} 
			
			setVisible(false);
			new IntMenuCliente(C_aux,P_aux);
		}
		else if(e.getSource() == aceptarG) {
			pos = (int)spinner.getValue(); //Convertimos en entero el ID del producto
			
			try {
				G_aux.eliminarProducto(pos-1);
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(this, ex2.getMessage(),
						"Eliminacion Fallida", JOptionPane.INFORMATION_MESSAGE);
				System.out.println(ex2.getMessage());
			}
			
			setVisible(false);
			new IntMenuGerente(G_aux,P_aux);
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
