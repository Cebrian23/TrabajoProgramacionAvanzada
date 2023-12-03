package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz que se usara para modificar el precio de un producto o rebajar el precio de todos los productos
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntModificarPrecio extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Spinner usado en la interfaz para la seleccion de la posicion del producto
	 */
	private JSpinner spinnerPos,
	/**
	 * Spinner usado en la interfaz para la seleccion del nuevo precio del producto
	 */
	spinnerNPrec,
	/**
	 * Spinner usado en la interfaz para establecer la rebaja de los productos
	 */
	spinnerDesc;
	/**
	 * Etiqueta usada en la interfaz para la posicion del producto
	 */
	private JLabel pos,
	/**
	 * Etiqueta usada en la interfaz para el nuevo del producto
	 */
	precio,
	/**
	 * Etiqueta usada en la interfaz para la rebaja de los productos
	 */
	rebaja,
	/**
	 * Etiqueta usada en la interfaz para mostrar un mensaje
	 */
	mensaje;
	/**
	 * Boton usado en la interfaz para que se efectue el cambio
	 */
	private JButton aceptar,
	/**
	 * Boton usado en la interfaz para volver al menu
	 */
	volver;
	/**
	 * String que sirve para saber, dependiendo del numero insertado por argumento, si se va a modificar el precio de un producto(0) o a establecer una rebaja global
	 */
	private String t_modif;
	/**
	 * Lista en la que se almacenaran los datos de los productos en venta
	 */
	private JList<String> lista;
	/**
	 * Panel de desplazamiento en el que se guarda la lista de los productos
	 */
	private JScrollPane scroll;
	/**
	 * Gerente que va a hacer la modificacion de precios
	 */
	private Gerente G_aux;
	/**
	 * ArrayList del que procede el gerente que va a hacer la modificacion de precio
	 */
	private ArrayList<Persona> P_aux;
	
	
	/**
	 * Constructor de la clase para modificar el precio de los productos
	 * @param num Es un numero que sirve para saber si se está modificando el precio de un producto (0) o establecer rebajas (1)
	 * @param geren Es el gerente propietario de los productos sobre los que se va a operar
	 * @param pers Es el ArrayList del que procede el gerente
	 */
	public IntModificarPrecio(int num, Gerente geren, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		if(num == 0) {
			setTitle("Modificar Precio");
			t_modif = "Modificar";
		}
		else if(num == 1) {
			setTitle("Establecer Rebajas");
			t_modif = "Rebajar";
		}
		setSize(650,375); //Eje x (1er numero)-> Ancho
		  				  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,//nº filas
				   				 1,//nº columnas
				   				 2,
				   				 2
								 ));
		
		G_aux = geren;
		P_aux = pers;
		
		//Creamos un boton para volver al menu
		volver = new JButton("Volver al menu");
		volver.addActionListener(this);
		
		//Se comprueba que la tienda tiene productos
		if(G_aux.getShop().getProductos().size() == 0) {
			//Creamos la etiqueta para el mensaje que se va a imprimir
			mensaje = new JLabel("No hay productos disponibles");
			add(mensaje);
			
			add(volver);
		}
		else {
			//Creamos la etiqueta para el mensaje que se va a imprimir
			mensaje = new JLabel("Los productos disponibles son:");
			add(mensaje);
			
			String[] variable = new String[G_aux.getShop().getProductos().size()];
			
			for(int x = 0; x < G_aux.getShop().getProductos().size(); x++) {
				String aux = (x+1) + ". " + G_aux.getShop().getProductos().get(x).getNombre() +
							 " (ID: " + G_aux.getShop().getProductos().get(x).getID() +
							 "; PRECIO: " + G_aux.getShop().getProductos().get(x).getPrecio() + "€)";
				
				variable[x] = aux;
			}
			
			lista = new JList<String>(variable); //Inicializamos la lista
			scroll = new JScrollPane(lista);
			add(scroll);
			
			//Creamos un panel
			panel = new JPanel();
			panel.setLayout(new GridLayout(2,//nº filas
					   					   2, //nº columnas
					   					   2,
					   					   2
										   ));
			
			if(num == 0) {
				//Creamos la etiqueta para el ID del producto del que se quiere modificar
				pos = new JLabel("Escribe la posicion del producto del que quieras modificar su precio: ");
				panel.add(pos);
				
				//Creamos un campo para seleccionar el ID del producto
				SpinnerModel item1 = new SpinnerNumberModel(1, //Valor inicial
														   1, //Valor minimo
														   2000, //Valor maximo
														   1 //En cuanto se aumenta o disminuye
														   );
				spinnerPos = new JSpinner(item1);
				spinnerPos.setBounds(50,50,50,30);
				panel.add(spinnerPos);
				
				//Creamos la etiqueta para el precio del producto del que se quiere modificar
				precio = new JLabel("Escribe el nuevo precio del producto: ");
				panel.add(precio);
				
				//Creamos un campo para seleccionar el nuevo precio del producto
				SpinnerModel item2 = new SpinnerNumberModel(5.00, //Valor inicial
														   0.10, //Valor minimo
														   99.99, //Valor maximo
														   1.00 //En cuanto se aumenta o disminuye
														   );
				spinnerNPrec = new JSpinner(item2);
				spinnerNPrec.setBounds(50,50,50,30);
				panel.add(spinnerNPrec);
			}
			else if(num == 1) {
				//Creamos la etiqueta para el id del producto del que se quiere modificar
				rebaja = new JLabel("Escribe por cuanto se van a rebajar los productos: ");
				panel.add(rebaja);
				
				//Creamos un campo para seleccionar el porcentaje por el que se rebajara el producto
				SpinnerModel item3 = new SpinnerNumberModel(50, //Valor inicial
														   1, //Valor minimo
														   1000, //Valor maximo
														   1 //En cuanto se aumenta o disminuye
														   );
				spinnerDesc = new JSpinner(item3);
				spinnerDesc.setBounds(50,50,50,30);
				panel.add(spinnerDesc);		
			}
			
			//Agregamos el panel al JFrame
			getContentPane().add(panel);
			
			//Creamos un boton para aceptar la modificacion
			aceptar = new JButton("Aceptar");
			aceptar.addActionListener(this);
			add(aceptar);
			
			add(volver);
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
		//Variables auxiliares
		int posic,rebaja;
		double nPrecio;	
		
		if(e.getSource() == aceptar) {
			//Verificamos si lo que hay que hacer es modificar el precio de un producto
			if(t_modif == "Modificar") {
				posic = (int)spinnerPos.getValue(); //Convertimos un String en un Double
				nPrecio = (double)spinnerNPrec.getValue(); //Convertimos un String en un Double
				
				try {
					G_aux.modificarPrecio(posic-1, nPrecio);
					JOptionPane.showMessageDialog(this,
												  "Precio del producto modificado correctamente.",
												  "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (ProductoNoEncontradoException ex1) {
					JOptionPane.showMessageDialog(this, ex1.getMessage(),
							"Error", JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex1.getMessage());
				} catch (Exception ex2) {
					JOptionPane.showMessageDialog(this, ex2.getMessage(),
							"Error", JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex2.getMessage());
				}
				
			}
			//Si no, se verifica si lo que hay que hacer es rebajar el precio a todos los productos
			else if(t_modif == "Rebajar") {
				rebaja = (int)spinnerDesc.getValue();
				
				try {
					G_aux.establecerRebajas(rebaja);
					JOptionPane.showMessageDialog(this,
												 "Rebajas establecidas correctamente en todos los productos.",
												 "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex3) {
					JOptionPane.showMessageDialog(this, ex3.getMessage(),
							"Error", JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex3.getMessage());
				}
			}
			setVisible(false);
			new IntMenuGerente(G_aux,P_aux);
		}
		else if(e.getSource() == volver) {
			setVisible(false);
			new IntMenuGerente(G_aux,P_aux);
		}
	}
	
}
