package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para mostrar un menu al cliente
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntMenuCliente extends JFrame implements ActionListener{
	/**
	 * Paneles usados en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz
	 */
	private JLabel menu;
	/**
	 * Boton usado en la interfaz para insertar un producto al carrito
	 */
	private JButton insertarProd,
	/**
	 * Boton usado en la interfaz para eliminar un producto del carrito
	 */
	eliminarProd,
	/**
	 * Boton usado en la interfaz para vaciar el carrito
	 */
	vaciarCar,
	/**
	 * Boton usado en la interfaz para comprar un producto al carrito
	 */
	comprar,
	/**
	 * Boton usado en la interfaz para cancelar un pedido
	 */
	cancelarPed,
	/**
	 * Boton usado en la interfaz para mostrar algunos datos del usuario,
	 * como su nombre, su correo o su direccion
	 */
	mostrarInfo,
	/**
	 * Boton usado en la interfaz para actualizar los datos del usuario,
	 */
	actualizarInfo,
	/**
	 * Boton usado en la interfaz para mostrar los productos del carrito
	 */
	mostrarCar,
	/**
	 * Boton usado en la interfaz para mostrar los pedidos pendiente del usuario
	 */
	mostrarPed,
	/**
	 * Boton usado en la interfaz para cerrar sesion
	 */
	cerrarSes;
	/**
	 * Array del que procede el cliente
	 */
	private ArrayList<Persona> A_aux;
	/**
	 * Cliente al que se le esta mostrando el menu
	 */
	private Cliente C_aux;	
	
	/**
	 *  Constructor de la clase para mostrar un menu para el gerente
	 * @param cliente Es el cliente al que se le va a mostrar el menu
	 * @param pers Es el ArrayList del que proviene el cliente
	 */
	public IntMenuCliente(Cliente cliente,ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Menu Cliente");
		setSize(375,315); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		C_aux = cliente; //Apuntamos a la direccion del cliente de entrada
		A_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(11,//nº filas
									   1, //nº columnas
									   2,
									   2
									   ));
		
		//Creamos una etiqueta
		menu = new JLabel("Bienvenido " + C_aux.getNombre() + " " + C_aux.getApellidos() + " que deseas hacer: ");
		panel.add(menu);
		
		//Creamos un boton para insertar un producto al carrito
		insertarProd = new JButton("Insertar un producto al carrito");
		insertarProd.addActionListener(this);
		panel.add(insertarProd);
				
		//Creamos un boton para eliminar un producto al carrito
		eliminarProd = new JButton("Eliminar un producto al carrito");
		eliminarProd.addActionListener(this);
		panel.add(eliminarProd);
		
		//Creamos un boton para vaciar el carrito
		vaciarCar = new JButton("Vaciar el carrito");
		vaciarCar.addActionListener(this);
		panel.add(vaciarCar);
		
		//Creamos un boton para eliminar un producto al carrito
		comprar = new JButton("Comprar productos del carrito");
		comprar.addActionListener(this);
		panel.add(comprar);
		
		//Creamos un boton para eliminar un producto al carrito
		cancelarPed = new JButton("Cancelar pedido");
		cancelarPed.addActionListener(this);
		panel.add(cancelarPed);
		
		//Creamos un boton para mostrar la info del cliente
		mostrarInfo = new JButton("Ver datos del cliente");
		mostrarInfo.addActionListener(this);
		panel.add(mostrarInfo);
		
		//Creamos un boton para mostrar la info del carrito del cliente
		actualizarInfo = new JButton("Actualizar Informacion");
		actualizarInfo.addActionListener(this);
		panel.add(actualizarInfo);
		
		//Creamos un boton para mostrar la info del carrito del cliente
		mostrarCar = new JButton("Mostrar el contenido del carrito");
		mostrarCar.addActionListener(this);
		panel.add(mostrarCar);
		
		//Creamos un boton para mostrar los pedidos del cliente
		mostrarPed = new JButton("Mostrar todos los pedidos");
		mostrarPed.addActionListener(this);
		panel.add(mostrarPed);
		
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
		if(e.getSource() == insertarProd) {
			setVisible(false);
			new IntInsertarProducto(C_aux,A_aux);
		}
		else if(e.getSource() == eliminarProd) {
			setVisible(false);
			new IntEliminarProducto(C_aux.getCarrito(),C_aux,A_aux);
		}
		else if(e.getSource() == vaciarCar) {
			//Mostramos una ventana
			int confirmacion = JOptionPane.showConfirmDialog(this,
		            "¿Estás seguro de que deseas vaciar el carrito?",
		            "Confirmar Vaciar Carrito", JOptionPane.YES_NO_OPTION);

		    if (confirmacion == JOptionPane.YES_OPTION) {
		    	//Comprobamos si el carrito tiene algun producto
		        if(C_aux.getCarrito().getCarrito().size() == 0) {
		        	JOptionPane.showMessageDialog(this, "El carrito ya estaba vacio",
							  					  "Carrito Ya Vaciado", JOptionPane.INFORMATION_MESSAGE);
		        }
		        else {
		        	//Vaciar el carrito
		        	JOptionPane.showMessageDialog(this, "El carrito ha sido vaciado",
		        								  "Carrito Vaciado", JOptionPane.INFORMATION_MESSAGE);
		        	C_aux.vaciarCarrito();
		        	
		        	System.out.println(C_aux.getCarrito().getCarrito().size());
		        }
		    }
		}
		else if(e.getSource() == comprar) {
			setVisible(false);
			new IntComprar(C_aux,A_aux);
		}
		else if(e.getSource() == cancelarPed) {
			setVisible(false);
			new IntCancelarPedido(C_aux,A_aux);
		}
		else if(e.getSource() == mostrarInfo) {
			setVisible(false);
			new IntMostrarDatos(C_aux,A_aux);
		}
		else if(e.getSource() == actualizarInfo) {
			setVisible(false);
			new IntActInfo(C_aux,A_aux);
		}
		else if(e.getSource() == mostrarCar) {
			setVisible(false);
			new IntMostrarDatos(C_aux.getCarrito(),C_aux,A_aux);
		}
		else if(e.getSource() == mostrarPed) {
			setVisible(false);
			new IntMostrarDatos(C_aux.getPedidos(),C_aux,A_aux);
		}
		else if(e.getSource() == cerrarSes) {
			setVisible(false);
			new IntMenuGeneral(A_aux);
		}
	}
}
