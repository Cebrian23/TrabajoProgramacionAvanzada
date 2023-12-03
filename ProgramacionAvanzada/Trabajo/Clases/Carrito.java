package Clases;

import java.util.ArrayList;

/**
 * La clase "Carrito_compra" representa el lugar donde almacenar los productos que se van a comprar
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public class Carrito {
	/**
	 * Atributo unico para Singleton
	 */
	private static Carrito instancia;
	/**
	 * ArrayList con los productos que el cliente comprara
	 */
	private ArrayList<Producto> carrito;
	/**
	 * Importe del carrito
	 */
	private double coste;
	
	/**
	 * Constructor por defecto
	 */
	public Carrito() {
		carrito = new ArrayList<Producto>();
		coste = 0.0;
	}
	
	/**
	 * Metodo para obtener la unica instancia de la clase.
	 * @return Devuelve una instancia de Singleton
	 */
	public static synchronized Carrito obtenerInstancia() {
        if (instancia == null) {
            instancia = new Carrito();
        }
        return instancia;
    }
	
	/**
	 * Metodo para insertar un producto al carrito
	 * @param product Es el producto que se va a insertar en el carrito
	 */
	public void insertarProducto(Producto product) {
		carrito.add(product);
		coste = coste + product.getPrecio();
	}
	
	/**
	 * Metodo para eliminar un producto del carrito
	 * @param pos Es la posicion del producto que se va a eliminar del carrito
	 * @throws Exception Excepcion que se lanza si la posicion del producto es mayor al tamaño del carrito
	 */
	public void eliminarProducto(int pos) throws Exception{
		if(pos > carrito.size() - 1) {
			throw new Exception("La posicion insertada esta fuera del rango del carrito");
		}
		else {
			coste = coste - carrito.get(pos).getPrecio();
			carrito.remove(pos);
		}
	}
	
	/**
	 * Metodo para vaciar el carrito y resetear la variable coste
	 */
	public void vaciarCarrito() {
		carrito.clear();
		setCoste(0.0);
	}
	
	/**
	 * Metodo Setter del carrito de la compra
	 * @param product Es un Array con los producto que tendra el carrito
	 */
	public void setCarrito(ArrayList<Producto> product) {
		carrito.clear();
		
		for(Producto x:product) {
			carrito.add(x);
		}
	}
	
	/**
	 * Metodo Getter del carrito de la compra
	 * @return Devuelve el Array con los productos que estan en el carrito
	 */
	public ArrayList<Producto> getCarrito() {
		return carrito;
	}
	
	/**
	 * Metodo Setter del importe del carrito
	 * @param num Es el importe que tiene el carrito
	 */
	public void setCoste(double num) {
		coste = num;
	}
	
	/**
	 * Metodo Getter del importe del carrito
	 * @return Devuelve el importe del carrito
	 */
	public double getCoste() {
		return coste;
	}
}
