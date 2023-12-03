package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz que servira para insertar un producto al ArrayList del Cliente
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntInsertarProducto extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Lista que se usa para mostrar los productos que estan en venta
	 */
	private JList<String> lista;
	/**
	 * Panel de deslizamiento que sirve como contenedor de la lista
	 */
	private JScrollPane scrollLista;
	/**
	 * Etiqueta usada en la interfaz para mostrar un mensaje
	 */
	private JLabel mensaje,
	/**
	 * Etiqueta usada en la interfaz para el ID del producto
	 */
	id;
	/**
	 * Variable que se usa para establecer el ID del producto
	 */
	private JSpinner spinner;
	/**
	 * Es el Cliente al que se le pregunta que producto quiere insertar en su carrito
	 */
	private Cliente C_aux;
	/**
	 * Es el ArrayList del que proviene la persona
	 */
	private ArrayList<Persona> P_aux;
	/**
	 * Es la tienda de la que se quiere ver los productos
	 */
	private Tienda T_aux;
	/**
	 * Boton usado en la interfaz para aceptar la insercion del producto
	 */
	private JButton aceptar,
	/**
	 * Boton usado en la interfaz para volver a la interfaz del menu del cliente
	 */
	volver;
	
	/**
	 * Constructor para insertar un producto
	 * @param clie Es el cliente que quiere insertar un producto en su carrito
	 * @param pers Es el ArrayList del que proviene el ciente
	 */
	public IntInsertarProducto(Cliente clie, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Insertar Producto");
		setSize(560,275); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,//nº filas
						   		 1,//nº columnas
						   		 2,
						   		 2
						   		 )); 
		
		C_aux = clie;
		P_aux = pers;
		
		//Se busca si hay un gerente en la tienda
		for(Persona x:pers) {
			//Si lo hay apuntamos a la direccion en la que se aloja su tienda
			if(x.ID() == "Gerente") {
				Gerente g_aux = (Gerente) x;
				T_aux = g_aux.getShop();
			}
		}
		
		//Creamos la etiqueta para el ID
		mensaje = new JLabel("Los productos disponibles para comprar son los siguientes:");
		add(mensaje);
		
		String[] v_aux = new String[T_aux.getProductos().size()];
		
		//Se itera en la tienda para guardar el nombre del producto, su ID y su precio
		for(int x = 0; x < T_aux.getProductos().size(); x++) {
			//Guardamos los datos en un String auxiliar
			String aux = T_aux.getProductos().get(x).getNombre() + "(ID: " +
						 T_aux.getProductos().get(x).getID() +
						 "; PRECIO: " + T_aux.getProductos().get(x).getPrecio()+"€)";
			
			v_aux[x] = aux; //Guardamos el String Auxiliar en un vector
		}
		
		lista = new JList<String>(v_aux); //Inicializamos la lista
		scrollLista = new JScrollPane(lista); //Metemos la lista en un panel de desplazamiento
		add(scrollLista); //Insertamos el panel de deslizamiento en el JFrame
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,//nº filas
						   			   2, //nº columnas
						               2,
				                       2
				                       ));
		
		//Creamos la etiqueta para el ID
		id = new JLabel("Escribe el ID del producto que quieras insertar: ");
		panel.add(id);
		
		//Creamos un campo para seleccionar el ID del producto
		SpinnerModel item = new SpinnerNumberModel(T_aux.getProductos().size()/2, //Valor inicial
												   1, //Valor minimo
												   2000, //Valor maximo
												   1 //En cuanto se aumenta o disminuye
												   );
		spinner = new JSpinner(item);
		spinner.setBounds(50,50,50,30);
		panel.add(spinner);
		
		//Creamos un boton para aceptar la insercion del producto
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		panel.add(aceptar);
		
		//Creamos un boton para volver al menu del cliente
		volver = new JButton("Volver al menu");
		volver.addActionListener(this);
		panel.add(volver);
		
		//Agregamos los paneles al JFrame
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
		int ident;
		
		if(e.getSource() == aceptar) {
			ident = (int)spinner.getValue(); //Convertimos en entero el ID del producto
			
			if(ident < 1 || ident > T_aux.getProductos().size()){
				JOptionPane.showMessageDialog(this, "El producto no se ha encontrado",
					  	"Producto No Encontrado", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				C_aux.insertarProducto(T_aux.getProductos().get(ident-1));
				System.out.println("Productos en el carrito: " + C_aux.getCarrito().getCarrito().size() + " productos");
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
