package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para mostrar datos, ya sea la informacion de un cliente, de sus pedidos, de su carrito
 * o de los productos que vende un gerente
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntMostrarDatos extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz imprimir un mensaje
	 */
	private JLabel mensaje,
	/**
	 * Etiqueta usada en la interfaz para el nombre del cliente o del gerente
	 */
	nombre1,
	/**
	 * Etiqueta usada en la interfaz para los apellidos del cliente o del gerente
	 */
	apellidos,
	/**
	 * Etiqueta usada en la interfaz para el correo del cliente o del gerente
	 */
	correo,
	/**
	 * Etiqueta usada en la interfaz para el saldo del cliente
	 */
	saldo,
	/**
	 * Etiqueta usada en la interfaz para la direccion del cliente
	 */
	direccion,
	/**
	 * Etiqueta usada en la interfaz para el nombre de la tienda o del gerente
	 */
	nTienda;
	/**
	 * Variable auxiliar de tipo "Cliente" que guarda los datos del cliente del que vamos a mostrar los datos
	 */
	private Cliente C_aux;
	/**
	 * Variable auxiliar de tipo "Carrito_compra" que guarda los datos del carrito del que vamos a mostrar los datos
	 */
	private Carrito Car_aux;
	/**
	 * ArrayList del que provienen tanto el cliente como el gerente que se pasan por parametros
	 */
	private ArrayList<Persona> P_aux;
	/**
	 * Variable auxiliar para mostrar los pedidos realizados por un cliente
	 */
	private ArrayList<Pedido> Ped_aux;
	/**
	 * Variable auxiliar de tipo "Gerente_tienda" que guarda los datos del cliente del que vamos a mostrar los datos
	 */
	private Gerente G_aux;
	/**
	 * Tienda de la que se van a mostrar los productos en venta
	 */
	private Tienda T_aux;
	/**
	 * Lista para mostrar los productos del carrito del cliente
	 */
	private JList<String> listaProdC,
	/**
	 * Lista para mostrar los pedidos del cliente
	 */
	listaPed,
	/**
	 * Lista para mostrar los productos que se venden 
	 */
	listaProdT;
	/**
	 * Panel de desplazamiento de la lista de los productos del carrito del cliente
	 */
	private JScrollPane scrollPC,
	/**
	 * Panel de desplazamiento de la lista de los pedidos del cliente
	 */
	scrollPed,
	/**
	 * Panel de desplazamiento de la lista de los productos de la tienda del gerente
	 */
	scrollPT;
	/**
	 * Boton usado en el programa para el cliente
	 */
	private JButton volverC,
	/**
	 * Boton usado en el programa para el gerente
	 */
	volverG;
	
	/**
	 * Constructor
	 * @param clie Es el cliente
	 * @param pers Es el ArrayList del que procede el cliente
	 */
	public IntMostrarDatos(Cliente clie, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Datos del usuario");
		setSize(450,225); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		C_aux = clie;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,//nº filas
									   1,//nº columnas
									   2,
									   2
									   ));
		
		//Creamos una etiqueta para el mensaje
		mensaje = new JLabel("Datos de " + C_aux.getNombre() + " " + C_aux.getApellidos() + ":");
		panel.add(mensaje);
		
		//Creamos una etiqueta para el nombre
		nombre1 = new JLabel("Nombre: " + C_aux.getNombre());
		panel.add(nombre1);
		
		//Creamos una etiqueta para el apellidos
		apellidos = new JLabel("Apellidos: " + C_aux.getApellidos());
		panel.add(apellidos);
				
		//Creamos una etiqueta para el correo
		correo = new JLabel("Correo: " + C_aux.getCorreo());
		panel.add(correo);
		
		double num_aux = Math.round(C_aux.getSaldo()*100.0)/100.0;
		
		//Creamos una etiqueta para el saldo
		saldo = new JLabel("Saldo: " + num_aux + "€");
		panel.add(saldo);
		
		//Creamos una etiqueta para el direccion
		direccion = new JLabel("Direccion: " + C_aux.getDireccion());
		panel.add(direccion);
		
		//Creamos un boton para volver al menu
		volverC = new JButton("Volver al menu");
		volverC.addActionListener(this);
		panel.add(volverC);
		
		//Agregamos el panel al JFrame
		getContentPane().add(panel);
				
		//Hacer visible la ventana
		setVisible(true);
	}
	
	/**
	 * Constructor
	 * @param prods Es carrito del cliente
	 * @param clie Es el cliente poseedor del carrito
	 * @param pers Es el ArrayList del que procede el cliente
	 */
	public IntMostrarDatos(Carrito prods,Cliente clie, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Datos del carrito de la compra");
		setSize(450,200); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		Car_aux = prods;
		C_aux = clie;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,//nº filas
								 	   1,//nº columnas
								 	   2,
								 	   2
									   ));
			
		if(Car_aux.getCarrito().size() == 0) {
			//Creamos una etiqueta para el mensaje
			mensaje = new JLabel("No productos en el carrito");
			panel.add(mensaje);
		}
		else {
			//Creamos una etiqueta para el mensaje
			mensaje = new JLabel("Los productos del carrito son los siguientes: ");
			panel.add(mensaje);
			
			String[] var_aux = new String[Car_aux.getCarrito().size()];
			
			/*
			 * Bucle "for()" para almacenar en un vector el nombre del producto, su ID y su precio
			 * para luego mostrarlos en un JList
			 */
			for(int x = 0; x < Car_aux.getCarrito().size(); x++) {	
				double num_aux = Math.round(Car_aux.getCarrito().get(x).getPrecio()*100.0)/100.0;
				
				String aux = Car_aux.getCarrito().get(x).getNombre() + " (ID:" +
						 	 Car_aux.getCarrito().get(x).getID() +
						 	 "; PRECIO: " + num_aux +"€)";
				
				var_aux[x] = aux;
			}
			
			listaProdC = new JList<String>(var_aux); //Inicializamos la lista
			scrollPC = new JScrollPane(listaProdC);
			panel.add(scrollPC);
		}
		
		//Creamos un boton para volver al menu
		volverC = new JButton("Volver al menu");
		volverC.addActionListener(this);
		panel.add(volverC);
				
		//Agregamos el panel al JFrame
		getContentPane().add(panel);
						
		//Hacer visible la ventana
		setVisible(true);
	}
	
	/**
	 * Constructor
	 * @param peds Es el ArrayList de los pedidos que ha hecho un cliente
	 * @param clie Es el cliente poseedor del ArrayList de pedidos
	 * @param pers Es el ArrayList del que procede el cliente
	 */
	public IntMostrarDatos(ArrayList<Pedido> peds, Cliente clie, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Datos de los pedidos");
		setSize(400,225); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Ped_aux = peds;
		C_aux = clie;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,//nº filas
			 	   					   1,//nº columnas
			 	   					   2,
			 	   					   2
				   					   ));
		
		if(Ped_aux.size() == 0) {
			//Creamos una etiqueta para el mensaje
			mensaje = new JLabel("Aun no se ha realizado ningun pedido");
			panel.add(mensaje);
		}
		else {
			//Creamos una etiqueta para el mensaje
			mensaje = new JLabel("Los pedidos realizados son los siguientes:");
			panel.add(mensaje);
			
			//Verificamos si algun pedido ha sido entregado para eliminarlo
			C_aux.verificarEntrega();
			
			String[] var_aux = new String[Ped_aux.size()];
			
			/*
			 * Bucle "for()" para almacenar en un vector el ID del pedido y su precio
			 * para luego mostrarlos en un JList
			 */
			for(int x = 0; x < Ped_aux.size(); x++) {
				//Redondeamos el importe del pedido
				double num_aux = Math.round(Ped_aux.get(x).getCoste()*100.0)/100.0;
				
				String aux = "Pedido nº" + Ped_aux.get(x).getID() +
							 " cuyo importe es de " + num_aux +
							 " y se entregará el " + Ped_aux.get(x).getFecha();
				
				var_aux[x] = aux;
			}
			
			listaPed = new JList<String>(var_aux); //Inicializamos la lista
			scrollPed = new JScrollPane(listaPed);
			panel.add(scrollPed);
		}
		
		
		//Creamos un boton para volver al menu
		volverC = new JButton("Volver al menu");
		volverC.addActionListener(this);
		panel.add(volverC);
			
		//Agregamos el panel al JFrame
		getContentPane().add(panel);
						
		//Hacer visible la ventana
		setVisible(true);
	}
	
	/**
	 * Constructor
	 * @param geren Es el gerente
	 * @param pers Es el ArrayList del que procede el gerente
	 */
	public IntMostrarDatos(Gerente geren, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Datos del usuario");
		setSize(325,200); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		G_aux = geren;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(6,//nº filas
									   1,//nº columnas
									   2,
									   2
				 					   ));
		
		//Creamos una etiqueta para el mensaje
		mensaje = new JLabel("Datos de " + G_aux.getNombre() + " " + G_aux.getApellidos() + ":");
		panel.add(mensaje);
		
		//Creamos una etiqueta para el nombre
		nombre1 = new JLabel("Nombre: " + G_aux.getNombre());
		panel.add(nombre1);
				
		//Creamos una etiqueta para el apellidos
		apellidos = new JLabel("Apellidos: " + G_aux.getApellidos());
		panel.add(apellidos);
						
		//Creamos una etiqueta para el correo
		correo = new JLabel("Correo: " + G_aux.getCorreo());
		panel.add(correo);
				
		//Creamos una etiqueta para el nombre de la tienda
		nTienda = new JLabel("Nombre de la tienda: " + G_aux.getShop().getNombre());
		panel.add(nTienda);		
		
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
	 * Constructor
	 * @param tien Es la tienda de la que se van a extraer los productos para mostrarlos
	 * @param geren Es el gerente de la tienda
	 * @param pers Es el ArrayList del que proviene el gerente
	 */
	public IntMostrarDatos(Tienda tien,Gerente geren, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Productos en venta");
		setSize(385,275); //Eje x (1er numero)-> Ancho
				  		  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		T_aux = tien;
		G_aux = geren;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,//nº filas
	   			   					   2, //nº columnas
	   			   					   2,
	   			   					   2
                   					   ));
		
		if(T_aux.getProductos().size() == 0) {
			//Creamos una etiqueta para el mensaje
			mensaje = new JLabel("No hay productos en venta");
			panel.add(mensaje);
		}
		else {
			//Creamos una etiqueta para el mensaje
			mensaje = new JLabel("Los productos en venta son los siguientes: ");
			panel.add(mensaje);
			
			String[] var_aux = new String[tien.getProductos().size()];
			
			for(int x = 0; x < G_aux.getShop().getProductos().size(); x++) {
				double num_aux = Math.round(G_aux.getShop().getProductos().get(x).getPrecio()*100.0)/100.0;
				
				String aux = G_aux.getShop().getProductos().get(x).getNombre() + " (ID:" +
						 	 G_aux.getShop().getProductos().get(x).getID() +
						 	 "; PRECIO: " + num_aux +"€)";
				
				var_aux[x] = aux;
			}
			
			listaProdT = new JList<String>(var_aux); //Inicializamos la lista
			scrollPT = new JScrollPane(listaProdT);
			panel.add(scrollPT);
		}
				
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
		
		if(e.getSource() == volverC) {
			setVisible(false);
			new IntMenuCliente(C_aux,P_aux);
		}
		else if(e.getSource() == volverG) {
			setVisible(false);
			new IntMenuGerente(G_aux,P_aux);	
		}
		
	}
	
}