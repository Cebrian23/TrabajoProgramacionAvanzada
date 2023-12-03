package Clases;

/**
 * La clase "Producto" representa un objeto que se va a comprar en la tienda
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class Producto {
	/**
	 * Nombre del producto
	 */
	private String nombre;
	/**
	 * ID del producto
	 */
	private int ID;
	/**
	 * Precio del producto
	 */
	private double precio;
	
	/**
	 * Constructor por defecto
	 */
	Producto(){
		precio = 0.0;
	}
	
	/**
	 * Constructor
	 * @param name Es el nombre del producto
	 */
	Producto(String name){
		nombre = name;
		precio = 0.0;
	}
	
	/**
	 * Constructor
	 * @param name Es el nombre del producto
	 * @param price Es el precio del producto
	 */
	Producto(String name, double price){
		nombre = name;
		precio = price;
	}
	
	/**
	 * Constructor
	 * @param name Es el nombre del producto
	 * @param ID Es el ID del producto
	 * @param price Es el precio del producto
	 */
	Producto(String name, int ID, double price){
		nombre = name;
		this.ID = ID;
		precio = price;
	}
	
	/**
	 * Constructor
	 * @param prod Es el producto con el que vamos a inicializar los datos de este producto
	 */
	Producto(Producto prod){
		nombre = prod.getNombre();
		ID = prod.getID();
		precio = prod.getPrecio();
	}
	
	/**
	 * Metodo Setter del nombre del producto
	 * @param nom Es el nombre del producto
	 */
	public void setNombre(String nom) {
		nombre = nom;
	}
		
	/**
	 * Metodo Getter del nombre del producto
	 * @return Devuelve el nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo Setter del ID del producto
	 * @param ID Es el ID del producto
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**
	 * Metodo Getter del ID del producto
	 * @return Devuelve el ID del producto
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Metodo Setter del precio del producto
	 * @param num Es el precio del producto
	 */
	public void setPrecio(double num){
		precio = num;
	}
	
	/**
	 * Metodo Getter del precio del producto
	 * @return Devuelve el precio del producto
	 */
	public double getPrecio() {
		return precio;
	}
}
