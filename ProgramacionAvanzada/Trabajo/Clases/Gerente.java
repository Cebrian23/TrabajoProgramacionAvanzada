package Clases;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * La clase "Gerente_tienda" representa a la persona que dirige la tienda y que implementa los metodos de "Persona"
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class Gerente implements Persona {
	/**
	 * Nombre del gerente
	 */
	private String nombre;
	/**
	 * Apellidos del gerente
	 */
	private String apellidos;
	/**
	 * Correo del gerente
	 */
	private String correo;
	/**
	 * Password del gerente
	 */
	private String password;
	/**
	 * Tienda del gerente
	 */
	private Tienda shop;
	
	
	/**
	 * Constructor por defecto
	 */
	Gerente() {
		shop = new Tienda();
	}
	
	/**
	 * Constructor
	 * @param name Es el nombre de la tienda
	 */
	Gerente(String name) {
		shop = new Tienda(name);
	}
	
	/**
	 * Constructor
	 * @param name Es el nombre del gerente
	 * @param apellidos Son los apellidos del gerente
	 * @param correo Es el correo del gerente
	 * @param password Es el password del gerente
	 */
	Gerente(String name, String apellidos, String correo, String password){
		setNombre(name);
		setApellidos(apellidos);
		setCorreo(correo);
		setPassword(password);
		shop = new Tienda();
	}
	
	/**
	 * Constructor
	 * @param name1 Es el nombre del gerente
	 * @param apellidos Son los apellidos del gerente
	 * @param correo Es el correo del gerente
	 * @param password Es el password del gerente
	 * @param name2 Es el nombre de la tienda
	 * @param passwordT Es el password de la tienda
	 */
	Gerente(String name1, String apellidos, String correo, String password, String name2, String passwordT){
		setNombre(name1);
		setApellidos(apellidos);
		setCorreo(correo);
		setPassword(password);
		shop = new Tienda(name2, passwordT);
		shop.inicializar();
	}
	
	/**
	 * Constructor
	 * @param name1 Es el nombre del gerente
	 * @param apellidos Es el nombre del gerente
	 * @param correo Es el correo del gerente
	 * @param password Es el password del gerente
	 * @param tie Es la tienda del gerente
	 */
	Gerente(String name1, String apellidos, String correo, String password, Tienda tie){
		setNombre(name1);
		setApellidos(apellidos);
		setCorreo(correo);
		setPassword(password);
		shop = tie; //Apuntamos a la tienda
	}
	
	/**
	 * Constructor
	 * @param geren Es el contenedor auxiliar donde están los valores del gerente
	 */
	Gerente(Gerente geren){
		setNombre(geren.getNombre());
		setApellidos(geren.getApellidos());
		setCorreo(geren.getCorreo());
		setPassword(geren.getPassword());
		shop = geren.getShop();
	}
	
	/**
	 * Metodo para actualizar la informacion del gerente
	 * @param nombre Es el nombre del gerente
	 * @param apellidos Son los apellidos del gerente
	 * @param correo Es el correo del gerente
	 * @param password Es el password del gerente
	 * @param nTienda Es el nombre de la tienda del gerente
	 */
	@Override
	public void actualizarInfo(String nombre,String apellidos,String correo,String password,String nTienda) {
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setPassword(password);
		getShop().setNombre(nTienda);
	}
	
	/**
	 * Metodo para insertar un nuevo producto a la tienda
	 * @param product Es el producto que se va a insertar
	 */
	@Override
	public void insertarProducto(Producto product) {
		shop.insertarProducto(product);
	}
	
	/**
	 * Metodo para eliminar un producto
	 * @param pos Es la posicion del producto que se quiere eliminar
	 * @throws Exception Excepcion que se lanza si la posicion del producto a eliminar esta fuera de rango
	 */
	@Override
	public void eliminarProducto(int pos) throws Exception {
		shop.eliminarProducto(pos);
	}
	
	/**
	 * Metodo por el que se vacia toda la tienda
	 */
	public void vaciarTienda() {
		if(shop.getProductos().size() >= 1) {
			shop.vaciarTienda();
		}
	}
	
	/**
	 * Metodo para modificar el precio de un producto
	 * @param pos Es la posicion del producto al que se le va a cambiar el precio
	 * @param num Es el nuevo precio del producto
	 * @throws Exception Excepcion que se lanza si la variable "num" es un numero fuera de lo permitido
	 * @throws ProductoNoEncontradoException Excepcion que se lanza si el producto a eliminar no se ha encontrado
	 */
	public void modificarPrecio(int pos, double num) throws Exception, ProductoNoEncontradoException {
		shop.modificarPrecio(pos, num);
	}
	
	/**
	 * Metodo para rebajar el precio a todos los productos
	 * @param num Es el porcentaje por el que se van a rebajar los productos
	 * @throws Exception Es la excepcion que se lanza en el caso de que la variable "num" es menor que 1 o mayor que 100
	 */
	public void establecerRebajas(int num) throws Exception {
		shop.establecerRebajas(num);
	}
	
	/**
	 * Metodo Setter del nombre de la persona
	 * @param nombre Es el nombre de la persona
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo Getter del nombre de la persona
	 * @return Devuelve el nombre de la persona
	 */
	@Override
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo Setter de los apellidos de la persona
	 * @param apellidos Son los apellidos de la persona
	 */
	@Override
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Metodo Getter de los apellidos de la persona
	 * @return Devuelve los apellidos de la persona
	 */
	@Override
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Metodo Setter del correo de la persona
	 * @param correo Es el correo de la persona
	 */
	@Override
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Metodo Getter del correo de la persona
	 * @return Devuelve el correo de la persona
	 */
	@Override
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Metodo Setter del password de la persona
	 * @param password Es el password de la persona
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Método Getter del password de la persona
	 * @return Devuelve el password de la persona
	 */
	@Override
	public String getPassword() {
		return password;
	}
	
	/**
	 * Metodo Setter de la tienda
	 * @param tienda Es la tienda a la que vamos a apuntar
	 */
	public void setShop(Tienda tienda) {
		shop = tienda;
	}
	
	/**
	 * Metodo Getter de la tienda
	 * @return Devuelve la tienda del gerente con sus productos actuales
	 */
	public Tienda getShop() {
		return shop;
	}
	
	/**
	 * Metodo que devuelve el ID del gerente
	 * @return Devuelve un ID diciendo que es un gerente
	 */
	@Override
	public String ID() {
		return "Gerente";
	}
}
