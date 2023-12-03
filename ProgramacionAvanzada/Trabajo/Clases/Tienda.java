package Clases;

import java.util.ArrayList;

/**
 * La clase "Tienda" representa el lugar donde se mostraran los productos que se van a vender
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class Tienda {
	/**
	 * Nombre de la tienda
	 */
	private String nombre;
	/**
	 * Password de la tienda
	 */
	private String passwordT;
	/**
	 * ArrayList con los productos en venta
	 */
	private ArrayList<Producto> Productos;
	
	/**
	 * Constructor por defecto
	 */
	Tienda(){
		Productos = new ArrayList<Producto>(); 
	}
	
	/**
	 * Constructor
	 * @param nombre Es el nombre de la tienda
	 */
	Tienda(String nombre) {
		this.nombre = nombre;
		Productos = new ArrayList<Producto>(); 
	}
	
	/**
	 * Constructor
	 * @param nombre Es el nombre de la tienda
	 * @param password Es el password de la tienda
	 */
	Tienda(String nombre, String password){
		this.nombre = nombre;
		this.passwordT = password;
		Productos = new ArrayList<Producto>(); 
	}
	
	/**
	 * Metodo por el cual se va a insertar "por defecto" a la tienda unos productos
	 */
	public void inicializar() {
		/*
		 * Adultos
		 * Camisetas manga larga
		 */
		insertarProducto(new Producto("Camiseta Adulto Manga Larga Amarilla",13.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Larga Azul",13.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Larga Roja",13.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Larga Verde",14.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Larga Naranja",14.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Larga Morada",14.99));
		
		//Camisetas manga corta
		insertarProducto(new Producto("Camiseta Adulto Manga Corta Amarilla",15.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Corta Azul",15.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Corta Roja",15.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Corta Verde",16.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Corta Naranja",16.99));
		insertarProducto(new Producto("Camiseta Adulto Manga Corta Morada",16.99));
		
		//Sudaderas
		insertarProducto(new Producto("Sudadera Adulto Negra",27.99));
		insertarProducto(new Producto("Sudadera Adulto Blanca",27.99));
		
		/*
		 * Infantil
		 * Camisetas manga corta
		 */
		insertarProducto(new Producto("Camiseta Infantil Manga Corta Amarilla",7.99));
		insertarProducto(new Producto("Camiseta Infantil Manga Corta Azul",7.99));
		insertarProducto(new Producto("Camiseta Infantil Manga Corta Roja",7.99));
		insertarProducto(new Producto("Camiseta Infantil Manga Corta Verde",8.99));
		insertarProducto(new Producto("Camiseta Infantil Manga Corta Naranja",9.99));
		insertarProducto(new Producto("Camiseta Infantil Manga Corta Morada",9.99));
	}
	
	/**
	 * Metodo para añadir un producto a la lista
	 * @param product Es el producto que se va a insertar en la tienda
	 */
	public void insertarProducto(Producto product) {
		int new_ID;
		
		/*
		 * If-else para conseguir el ID del ultimo producto
		 * Se verifica si el Array con los productos estan vacios
		 */
		if(Productos.size() == 0) {
			product.setID(1);
		}
		else {
			//Se itera en el Array hasta encontrar el ultimo producto
			for(int x = 0;x < Productos.size();x++) {
				if(x == Productos.size()-1) {
					new_ID = Productos.get(x).getID()+1;
					product.setID(new_ID);
				}
			}
		}
		
		Productos.add(product);
	}
	
	/**
	 * Metodo para eliminar un producto de la lista
	 * @param pos Es la posicion del producto que se quiere eliminar
	 * @throws Exception Excepcion que se lanza si la posicion del producto es mayor al tamaño de la tienda
	 */
	public void eliminarProducto(int pos) throws Exception{
		if(pos > Productos.size() - 1) {
			throw new Exception("La posicion insertada esta fuera del rango de la tienda");
		}
		else {
			Productos.remove(pos);
		}
	}
	
	/**
	 * Metodo para vaciar la lista de productos
	 */
	public void vaciarTienda() {
		Productos.clear();
	}
	
	/**
	 * Metodo para modificar el precio de un producto
	 * @param posic Es la posicion del producto
	 * @param num Es el nuevo precio que tendra el producto
	 * @throws Exception Excepcion que se lanza si la variable "num" es un numero fuera de lo permitido
	 * @throws ProductoNoEncontradoException Excepcion que se lanza si el producto a eliminar no se ha encontrado
	 */
	public void modificarPrecio(int posic, double num) throws Exception,ProductoNoEncontradoException {
		//Se mira si el precio insertado en menor que 0 o mayor que 100
		if(num <= 0.0 || num >= 100.0) {
			throw new Exception("El nuevo precio establecido tiene que ser entre 0.1€ y 99.99€");
		}
		else {
			/*
			 * Se comprueba si el ID insertado es menor que 0 o 
			 * mayor que el ID del ultimo valor de la tienda
			 */
			if(posic <0 || posic > Productos.size() - 1)
			{
				throw new Exception("La posicion insertada esta fuera de lo permitido");
			}
			else {
				Productos.get(posic).setPrecio(num);
			}
		}
	}
	
	/**
	 * Metodo para rebajar el precio de un producto una cierta cantidad
	 * @param num Es el porcentaje por el que se va a rebajar los productos
	 * @throws Exception Es la excepcion que se lanza en el caso de que la variable "num" es menor que 1 o mayor que 100
	 */
	public void establecerRebajas(int num) throws Exception {
		
		if(num >= 1 && num <= 100) {
			double rebaja,new_precio;
			
			for(int x = 0;x < Productos.size(); x++) {
				rebaja = Productos.get(x).getPrecio()*((double)num/100);
				new_precio = Productos.get(x).getPrecio()-rebaja;
				
				Productos.get(x).setPrecio(new_precio);
			}
		}
		else {
			throw new Exception("La rebaja establecida debe de ser entre el 1% y el 100%");
		}
		
	}
	
	/**
	 * Metodo Setter del nombre
	 * @param nombre Es el nuevo nombre de la tienda
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo Getter del nombre
	 * @return Devuelve el nombre de la tienda
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo Setter del password para poder acceder a la tienda
	 * @param password Es el password para poder acceder a la tienda
	 */
	public void setPassword(String password) {
		this.passwordT = password;
	}
	
	/**
	 * Metodo Getter del password
	 * @return Devuelve el password de la tienda
	 */
	public String getPassword() {
		return passwordT;
	}
	
	/**
	 * Metodo Setter de los productos
	 * @param prod Es un Array con los productos que se venden en la tienda
	 */
	public void setProductos(ArrayList<Producto> prod) {
		Productos.clear();
		
		for(Producto x:prod) {
			Productos.add(x);
		}
	}
	
	/**
	 * Metodo Getter de los productos
	 * @return Devuelve la lista de los productos que se venden en la tienda
	 */
	public ArrayList<Producto> getProductos(){
		return Productos;
	}
}
