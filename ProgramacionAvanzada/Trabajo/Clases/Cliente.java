package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase "Cliente" representa la persona que compra en la tienda y que implementa los metodos de "Persona"
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class Cliente implements Persona {
	/**
	 * Nombre del cliente
	 */
	private String nombre;
	/**
	 * Apellidos del cliente
	 */
	private String apellidos;
	/**
	 * Correo del cliente
	 */
	private String correo;
	/**
	 * Password del cliente
	 */
	private String password;
	/**
	 * Direccion del cliente
	 */
	private String direccion;
	/**
	 * Saldo del cliente
	 */
	private double saldo;
	/**
	 * ArrayList con todos los pedidos que ha realizado el cliente
	 */
	private ArrayList<Pedido> pedidos;
	
	/**
	 * Constructor por defecto
	 */
	Cliente(){
		pedidos = new ArrayList<Pedido>();
		saldo = 350.0;
	}
	
	/**
	 * Constructor
	 * @param nombre Es el nombre del cliente
	 * @param apellidos Son los apellidos del cliente
	 * @param correo Es el correo del cliente
	 * @param password Es el password del cliente
	 * @param direccion Es el direccion del cliente
	 */
	Cliente(String nombre, String apellidos, String correo, String password, String direccion){
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setPassword(password);
		setDireccion(direccion);
		pedidos = new ArrayList<Pedido>();
		saldo = 350.0;
	}
	
	/**
	 * Constructor
	 * @param cliente Es el contenedor auxiliar donde están los valores del cliente
	 */
	Cliente(Cliente cliente){
		setNombre(cliente.getNombre());
		setApellidos(cliente.getApellidos());
		setCorreo(cliente.getCorreo());
		setPassword(cliente.getPassword());
		setCarrito(cliente.getCarrito());
		setPedidos(cliente.getPedidos());
	}
	
	/**
	 * Metodo sobreescrito para actualizar los datos del cliente
	 * @param nombre Es el nombre del cliente
	 * @param apellidos Son los apellidos del cliente
	 * @param correo Es el correo del cliente
	 * @param password Es el password del cliente
	 * @param direccion Es la direccion del cliente
	 */
	@Override
	public void actualizarInfo(String nombre,String apellidos,String correo,String password,String direccion) {
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setPassword(password);
		setDireccion(direccion);
	}
	
	/**
	 * Metodo para insertar un producto al carrito
	 * @param product Es el producto que se quiere insertar
	 */
	@Override
	public void insertarProducto(Producto product) {
		Carrito carrito = Carrito.obtenerInstancia();//Instancia de Singleton
		carrito.insertarProducto(product);
	}
	
	/**
	 * Metodo para eliminar un producto al carrito
	 * @param pos Es la posicion del producto que se quiere eliminar
	 * @throws Exception Excepcion que se lanza si la posicion del producto a eliminar esta fuera de rango
	 */
	@Override
	public void eliminarProducto(int pos) throws Exception {
		Carrito carrito = Carrito.obtenerInstancia();//Instancia de Singleton
		carrito.eliminarProducto(pos);
	}
	
	/**
	 * Método para vaciar el carrito de la compra
	 */
	public void vaciarCarrito() {
		Carrito carrito = Carrito.obtenerInstancia();//Instancia de Singleton
		carrito.vaciarCarrito();
	}
	
	/**
	 * Metodo para insertar pedidos
	 * @param ped Es el pedido que se quiere insertar
	 */
	public void insertarPedido(Pedido ped) {
		int lastPos;
		
		//Se establece el ID del pedido
		if(pedidos.size() == 0) {
			ped.setID(1);
		}
		else {
			lastPos = pedidos.size();
			ped.setID(pedidos.get(lastPos-1).getID()+1);
		}
		
		//Se inserta el pedido al Array
		pedidos.add(ped);
	}
	
	/**
	 * Metodo para cancelar un pedido
	 * @param pos Es la posicion del pedido que se va a cancelar
	 * @throws Exception Excepcion que se lanza si la posicion pasada por argumento esta fuera del rango del ArrayList de los pedidos
	 */
	public void cancelarPedido(int pos) throws Exception {
		//Verificamos si la posicion insertada esta dentro o fuera del rango del ArrayLis con los pedidos
		if(pos > pedidos.size()-1) {
			throw new Exception("La posicion insertada esta fuera del rango disponible del ArrayList");
		}
		else {
			saldo = saldo + pedidos.get(pos).getCoste(); //Devolvemos el importe del pedido
			pedidos.remove(pos); //Eliminamos el pedido
		}
		
	}
	
	/**
	 * Metodo para verificar si algún pedido ya ha sido entregado
	 */
	public void verificarEntrega() {
		//Se itera en el Array de los pedidos
		for(Pedido x:pedidos) {
			//Si la fecha del pedido es igual a la del dia de la verificacion, se elimina el pedido
			if(x.getFecha() == LocalDate.now()) {
				System.out.println("El pedido con el ID " + x.getID() + " se ha entregado correctamente");
				pedidos.remove(x);
			}
			//Si la fecha no es igual, se imprime un mensaje diciendo los dias que faltan para su entraga
			else {
				System.out.println("Al pedido con el ID " + x.getID()
				+ " le faltan " + LocalDate.now().until(x.getFecha()).getDays() + " dias");
			}
		}
	}
	
	/**
	 * Metodo para hacer la compra
	 */
	public void comprar() {
		Carrito carrito = Carrito.obtenerInstancia();//Instancia de Singleton
		
		Pedido Ped = new Pedido();
		
		if(saldo-carrito.getCoste() > 0) {
			//Se establece el precio del pedido
			Ped.setCoste(carrito.getCoste());
			
			//Se insertan los productos del carrito al pedido
			Ped.insertarProductos(carrito.getCarrito());
						
			//Se le quita el importe de la compra al saldo del cliente
			saldo = saldo-Ped.getCoste();
			
			//Se vacia el carrito
			carrito.vaciarCarrito();
			
			//Se inserta el pedido al Array
			insertarPedido(Ped);
			
			System.out.println("Compra hecha");
		}
		else {
			System.out.println("No tienes el dinero suficiente");
		}
	}
	
	/**
	 * Metodo para aumentar el saldo del cliente
	 * @param num Cantidad de dinero que se va a sumar al saldo actual
	 */
	public void insertarSaldo(double num) {
		saldo = saldo + num;
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
	 * Metodo Setter de la direccion
	 * @param direc Sirve para establecer la direccion del cliente
	 */
	public void setDireccion(String direc) {
		direccion = direc;
	}
	
	/**
	 * Metodo Getter de la dirección del cliente
	 * @return Devuelve la dirección del cliente
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Metodo Setter del saldo
	 * @param num Es el saldo que tendra el cliente
	 */
	public void setSaldo(double num) {
		saldo = num;
	}
	
	/**
	 * Metodo Getter del saldo
	 * @return Devuelve el saldo que tiene el cliente
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * Metodo Setter del carrito
	 * @param compra Es el carrito con los productos que el cliente ha agregado
	 */
	public void setCarrito(Carrito compra) {
		Carrito carrito = Carrito.obtenerInstancia(); //Instancia de Singleton
		carrito.getCarrito().clear();
		carrito.setCarrito(compra.getCarrito());
	}
	
	/**
	 * Metodo Getter del carrito
	 * @return Devuelve el carrito
	 */
	public Carrito getCarrito() {
		Carrito carrito = Carrito.obtenerInstancia(); //Instancia de Singleton
		return carrito;
	}
	
	/**
	 * Metodo Setter de los pedidos
	 * @param Ped Es el Array donde se almacenan todos los pedidos que ha hecho el cliente
	 */
	public void setPedidos(ArrayList<Pedido> Ped) {
		pedidos.clear();
		
		for(Pedido x:Ped) {
			pedidos.add(x);
		}
	}
	
	/**
	 * Metodo Getter de los pedidos
	 * @return Devuelve el Array con todos los pedidos 
	 */
	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}
	
	/**
	 * Metodo que devuelve el ID del cliente
	 * @return Devuelve un ID diciendo que es un cliente
	 */
	@Override
	public String ID() {
		return "Cliente";
	}
}
