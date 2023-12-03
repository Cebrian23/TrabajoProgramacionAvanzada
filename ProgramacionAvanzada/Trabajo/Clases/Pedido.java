package Clases;

import java.util.ArrayList;
import java.time.LocalDate; //Se importa un paquete para la gestión del tiempo

/**
 * La clase "Pedido" representa un lugar donde se guardan los productos que ya se han comprado
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class Pedido {
	/**
	 * ID del pedido
	 */
	private int ID;
	/**
	 * ArrayList con los productos comprados
	 */
	private ArrayList<Producto> Productos;
	/**
	 * Fecha de entrega del pedido
	 */
	private LocalDate Fecha_entrega;
	/**
	 * Importe del pedido
	 */
	private double coste;
	
	/**
	 * Constructor por defecto
	 */
	Pedido(){
		ID = 0;
		Productos = new ArrayList<Producto>();
		coste = 0.0;
		//Con esto se establece la fecha de entrega
		//Se establece la fecha a 14 días de la fecha actual
		Fecha_entrega = LocalDate.now().plusDays(14);
	}
	
	/**
	 * Constructor
	 * @param ID Es el ID del Pedido
	 */
	Pedido(int ID){
		this.ID = ID;
		Productos = new ArrayList<Producto>();
		coste = 0.0;
		//Con esto se establece la fecha de entrega
		//Se establece la fecha a 14 días de la fecha actual
		Fecha_entrega = LocalDate.now().plusDays(14);
	}
	
	
	/**
	 * Metodo para insertar productos a la lista
	 * @param produc Es el producto que se va a insertar en el pedido
	 */
	public void insertarProducto(Producto produc) {
		Productos.add(produc);
		if(Productos.size() >= 3) {
			Fecha_entrega = LocalDate.from(Fecha_entrega).plusDays(1);
		}
	}
	
	/**
	 * Metodo para insertar productos a la lista
	 * @param Prod Es un Array con los productos que se van a insertar en el pedido
	 */
	public void insertarProductos(ArrayList<Producto> Prod) {
		for(Producto x:Prod) {
			insertarProducto(x);
		}
	}
	
	/**
	 * Metodo Setter del ID
	 * @param ID Es el ID del pedido
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**
	 * Metodo Getter del ID del pedido
	 * @return Devuelve el ID del pedido
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Metodo Setter de los Productos del pedido
	 * @param prod Es la nueva lista de productos del pedido
	 */
	public void setProductos(ArrayList<Producto> prod) {
		Productos.clear();
		for(Producto x:prod) {
			Productos.add(x);
		}
	}
	
	/**
	 * Metodo Getter de los Productos del pedido
	 * @return Devuelve los Productos del pedido
	 */
	public ArrayList<Producto> getProductos(){
		return Productos;
	}
	
	
	/**
	 * Metodo Setter de la fecha de entrega del pedido
	 * @param Fecha Es la fecha en la que se entregara el producto
	 */
	public void setFecha(LocalDate Fecha) {
		Fecha_entrega = Fecha;
	}
	
	/**
	 * Metodo Getter de la fecha de entrega del pedido
	 * @return Devuelve la fecha de entrega del pedido
	 */
	public LocalDate getFecha() {
		return Fecha_entrega;
	}
	
	/**
	 * Metodo Setter del coste del pedido
	 * @param dinero Es el coste del pedido
	 */
	public void setCoste(double dinero) {
		coste = dinero;
	}
	
	/**
	 * Metodo Getter del coste del pedido
	 * @return Devuelve el coste del pedido
	 */
	public double getCoste() {
		return coste;
	}
}
