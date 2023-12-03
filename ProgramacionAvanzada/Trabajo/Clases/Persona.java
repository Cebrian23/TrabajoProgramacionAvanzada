package Clases;

/**
 * Interfaz persona que define algunas funcionalidades de los usuarios
 * 
 * @author Miguel Angel Cebrian
 * @author Ivan Garcia-Diego
 * @author Jorge Sanchez
 */

public interface Persona {
	/**
	 * Metodo para actualizar la informacion de la persona
	 * @param s1 String para el nombre
	 * @param s2 String para los apellidos
	 * @param s3 String para el correo
	 * @param s4 String para el password
	 * @param s5 String para la direccion (solo para el cliente) o el nombre de la tienda (solo para el gerente)
	 */
	public void actualizarInfo(String s1,String s2, String s3, String s4, String s5);
	
	/**
	 * Metodo para insertar un producto a un carrito  o a la tienda
	 * @param product Es el producto que se va a insertar
	 */
	public void insertarProducto(Producto product);
	
	/**
	 * Metodo para eliminar un producto
	 * @param pos Posicion del producto que se va a eliminar
	 * @throws Exception Excepcion que se lanza si la posicion del producto a eliminar esta fuera de rango
	 */
	public void eliminarProducto(int pos) throws Exception;
	
	/**
	 * Metodo Setter del nombre de la persona
	 * @param nombre Es el nombre de la persona
	 */
	public void setNombre(String nombre);
	
	/**
	 * Metodo Getter del nombre de la persona
	 * @return Devuelve el nombre de la persona
	 */
	public String getNombre();
	
	/**
	 * Metodo Setter de los apellidos de la persona
	 * @param apellidos Son los apellidos de la persona
	 */
	public void setApellidos(String apellidos);
	
	/**
	 * Metodo Getter de los apellidos de la persona
	 * @return Devuelve los apellidos de la persona
	 */
	public String getApellidos();
	
	/**
	 * Metodo Setter del correo de la persona
	 * @param correo Es el correo de la persona
	 */
	public void setCorreo(String correo);
	
	/**
	 * Metodo Getter del correo de la persona
	 * @return Devuelve el correo de la persona
	 */
	public String getCorreo();
	
	/**
	 * Metodo Setter del password de la persona
	 * @param password Es el password de la persona
	 */
	public void setPassword(String password);
	
	/**
	 * Método Getter del password de la persona
	 * @return Devuelve el password de la persona
	 */
	public String getPassword();
	
	/**
	 * Metodo que devuelve el ID del usuario
	 * @return Devuelve el ID del usuario
	 */
	public String ID();
}
