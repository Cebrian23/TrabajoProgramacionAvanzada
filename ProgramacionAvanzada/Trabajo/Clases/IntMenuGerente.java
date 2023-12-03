package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para mostrar un menu al gerente
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntMenuGerente extends JFrame implements ActionListener{
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz
	 */
	private JLabel menu;
	/**
	 * Boton usado en la interfaz para mostrar los datos del gerente
	 */
	private JButton mostrarInfo,
	/**
	 * Boton usado en la interfaz para actualizar los datos del gerente
	 */
	actualizarInfo,
	/**
	 * Boton usado en la interfaz para mostrar los productos que vende del gerente
	 */
	mostrarProd,
	/**
	 * Boton usado en la interfaz para insertar un nuevo producto
	 */
	insertarNProd,
	/**
	 * Boton usado en la interfaz para eliminar un producto
	 */
	eliminarProd,
	/**
	 * Boton usado en la interfaz para vaciar la tienda
	 */
	vaciarTie,
	/**
	 * Boton usado en la interfaz para cambiarle el precio a un producto
	 */
	cambiarPrecio,
	/**
	 * Boton usado en la interfaz para establecer rebajas en todos los productos
	 */
	rebajas,
	/**
	 * Boton usado en la interfaz para cerrar sesion
	 */
	cerrarSes;
	/**
	 * Array del que procede el cliente
	 */
	private ArrayList<Persona> A_aux;
	/**
	 * Gerente al que se le esta mostrando el menu
	 */
	private Gerente G_aux;
		
	/**
	 * Constructor de la clase para mostrar un menu para el gerente
	 * @param gerente Es el gerente al que se le va a mostrar el menu
	 * @param pers Es el ArrayList del que procede el gerente
	 */
	public IntMenuGerente(Gerente gerente, ArrayList<Persona> pers){
		//Configuramos los parametros de la ventana
		setTitle("Menu Gerente");
		setSize(375,290); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		A_aux = pers; //Apuntamos a la direcci
		G_aux = gerente; //Apuntamos a la direccion del gerente de entrada
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(10,//nº filas
				   					   1, //nº columnas
				   					   2,
				   					   2
									   ));
		
		//Creamos una etiqueta
		menu = new JLabel("Bienvenido "+G_aux.getNombre()+" "+G_aux.getApellidos()+" que deseas hacer: ");
		panel.add(menu);
		
		//Creamos un boton para mostrar los datos del gerente
		mostrarInfo = new JButton("Ver datos del gerente");
		mostrarInfo.addActionListener(this);
		panel.add(mostrarInfo);
		
		//Creamos un boton para mostrar los datos del gerente
		actualizarInfo = new JButton("Actualizar los datos del gerente");
		actualizarInfo.addActionListener(this);
		panel.add(actualizarInfo);
		
		//Creamos un boton para mostrar los productos que vende el gerente
		mostrarProd = new JButton("Ver productos en venta");
		mostrarProd.addActionListener(this);
		panel.add(mostrarProd);
		
		//Creamos un boton para insertar un nuevo producto a la tienda
		insertarNProd = new JButton("Insertar un nuevo producto a la tienda");
		insertarNProd.addActionListener(this);
		panel.add(insertarNProd);
		
		//Creamos un boton para eliminar un producto de la tienda
		eliminarProd = new JButton("Eliminar un producto de la tienda");
		eliminarProd.addActionListener(this);
		panel.add(eliminarProd);
		
		//Creamos un boton para vaciar la tienda
		vaciarTie = new JButton("Vaciar la tienda");
		vaciarTie.addActionListener(this);
		panel.add(vaciarTie);
		
		//Creamos un boton para cambiar el precio de un producto
		cambiarPrecio = new JButton("Cambiar el precio de un producto");
		cambiarPrecio.addActionListener(this);
		panel.add(cambiarPrecio);
		
		//Creamos un boton para rebajar todos los productos
		rebajas = new JButton("Establecer rebajas en todos los productos");
		rebajas.addActionListener(this);
		panel.add(rebajas);
		
		//Creamos un boton para cerrar sesion
		cerrarSes = new JButton("Cerrar Sesion");
		cerrarSes.addActionListener(this);
		panel.add(cerrarSes);
		
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
		if(e.getSource() == mostrarInfo) {
			setVisible(false);
			new IntMostrarDatos(G_aux,A_aux);
		}
		else if(e.getSource() == actualizarInfo) {
			setVisible(false);
			new IntActInfo(G_aux,A_aux);
		}
		else if(e.getSource() == mostrarProd){
			setVisible(false);
			new IntMostrarDatos(G_aux.getShop(),G_aux,A_aux);
		}
		else if(e.getSource() == insertarNProd) {
			setVisible(false);
			new IntInicializarProducto(G_aux.getShop().getProductos(),G_aux,A_aux);
		}
		else if(e.getSource() == eliminarProd) {
			setVisible(false);
			new IntEliminarProducto(G_aux.getShop(),G_aux,A_aux);
		}
		else if(e.getSource() == vaciarTie) {
			//Mostramos una ventana
			int confirmacion = JOptionPane.showConfirmDialog(this,
		            "¿Estás seguro de que deseas vaciar la tienda?",
		            "Confirmar Vaciar Tienda", JOptionPane.YES_NO_OPTION);

		    if (confirmacion == JOptionPane.YES_OPTION) {
		    	//Comprobamos si la tienda tiene algun producto
		        if(G_aux.getShop().getProductos().size() == 0) {
		        	JOptionPane.showMessageDialog(this, "La tienda ya estaba vacia",
							  					  "Tienda Ya Vaciada", JOptionPane.INFORMATION_MESSAGE);
		        }
		        else {
		        	//Vaciar la tienda
		        	JOptionPane.showMessageDialog(this, "La tienda ha sido vaciada",
		        								  "Tienda Vaciada", JOptionPane.INFORMATION_MESSAGE);
		        	G_aux.vaciarTienda();
		        	System.out.println("Productos en la tienda: " +
		        						G_aux.getShop().getProductos().size() + " productos");
		        }
		    	
		    }
		}
		else if(e.getSource() == cambiarPrecio) {
			setVisible(false);
			new IntModificarPrecio(0,G_aux,A_aux);
		}
		else if(e.getSource() == rebajas) {
			setVisible(false);
			new IntModificarPrecio(1,G_aux,A_aux);
		}
		else if(e.getSource() == cerrarSes) {
			setVisible(false);
			new IntMenuGeneral(A_aux);
		}
	}
}
