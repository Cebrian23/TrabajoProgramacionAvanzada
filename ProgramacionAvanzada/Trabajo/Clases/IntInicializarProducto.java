package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Interfaz para dar de alta un producto y ponerlo a la venta
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class IntInicializarProducto extends JFrame implements ActionListener {
	/**
	 * Panel usado en la interfaz
	 */
	private JPanel panel;
	/**
	 * Etiqueta usada en la interfaz para el nombre del producto
	 */
	private JLabel nombre,
	/**
	 * Etiqueta usada en la interfaz para el precio del producto
	 */
	precio;
	/**
	 * Campo de texto usado en la interfaz para el nombre del producto
	 */
	private JTextField campo1;
	/**
	 * Variable que se usa para establecer el precio del producto
	 */
	private JSpinner spinner;
	/**
	 * Boton usado en la interfaz para aceptar el nuevo producto
	 */
	private JButton aceptar,
	/**
	 * Boton usado en la interfaz para volver al menu del gerente
	 */
	volver;
	/**
	 * ArrayList en la que se van a insertar los datos
	 */
	private ArrayList<Producto> Prod_aux;
	/**
	 * Gerente propietario de la tienda donde se va a insertar el producto
	 */
	private Gerente G_aux;
	/**
	 * ArrayList donde proviene el gerente
	 */
	private ArrayList<Persona> P_aux;
	
	/**
	 * Constructor para dar de alta un producto para que se pueda poner a la venta en la tienda
	 * @param prods Es el Array donde se va a almacenar el nuevo producto
	 * @param geren Es el gerente que va a insertar un nuevo producto en su tienda
	 * @param pers Es el ArrayList del que proviene el gerente
	 */
	public IntInicializarProducto(ArrayList<Producto> prods, Gerente geren, ArrayList<Persona> pers) {
		//Configuramos los parametros de la ventana
		setTitle("Inicializar Producto");
		setSize(380,200); //Eje x (1er numero)-> Ancho
						  //Eje y (2do numero)-> Largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Prod_aux = prods;
		G_aux = geren;
		P_aux = pers;
		
		//Creamos un panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,//nº filas
				   					   2, //nº columnas
				   					   2,
				   					   2
				   					   ));
		
		//Creamos la etiqueta para el nombre
		nombre = new JLabel("Escribe el nombre del producto: ");
		panel.add(nombre);
		
		//Creamos el campo para el nombre
		campo1 = new JTextField(15);
		panel.add(campo1);
		
		//Creamos la etiqueta para el precio
		precio = new JLabel("Escribe el precio del producto: ");
		panel.add(precio);
		
		//Creamos un campo para seleccionar el precio del producto
		SpinnerModel item = new SpinnerNumberModel(15.99, //Valor inicial
												   0.00, //Valor minimo
												   99.99, //Valor maximo
												   1.00 //En cuanto se aumenta o disminuye
												   );
		spinner = new JSpinner(item);
		spinner.setBounds(50,50,50,30);
		panel.add(spinner);
		
		//Creamos un boton para insertar el producto en la tienda
		aceptar = new JButton("Insertar producto");
		aceptar.addActionListener(this);
		panel.add(aceptar);
		
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
		//Variables auxiliares
		Producto prod;
		String nom;
		double prec;
		
		if(e.getSource() == aceptar) {
			nom = campo1.getText(); //Inicializamos la variable del nombre del producto
			
			if(nom.length() == 0) {
				// Mensaje de error: El campo esta vacio
				JOptionPane.showMessageDialog(this, "Error. El campo esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
				// Mostrar la ventana de registro nuevamente
				setVisible(true);
				//El return es para que no se abra el menu y se siga quedando en la de Inicializar Producto
				return;
			}
			else {
				prec = (double)spinner.getValue();
				
				prod = new Producto(nom,prec); //Inicializamos el producto
				
				G_aux.insertarProducto(prod);
				
				System.out.println("En la tienda hay " + Prod_aux.size() + " productos");
				
				setVisible(false);
				new IntMenuGerente(G_aux,P_aux);
			}
			
		}
		else if(e.getSource() == volver) {
			setVisible(false);
			new IntMenuGerente(G_aux,P_aux);
		}
	}
}
