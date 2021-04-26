/**
 * Copyright (c) 2021 i4digital
 * <br><A HREF="http://www.i4digital.com>"</br>
 * Todos los derechos reservados.
 */
package co.com.i4digital.servicio;
/**
 * Clase que define constantes urls de 
 * la api del servicio rest externo 
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 25/04/2021 <br>
 *         <b>Fecha de modificación : </b> 00/00/0000
 */
public class ConstantesServicioUsuarios {
	public static final String CONST_URL_USUARIO = "https://jsonplaceholder.typicode.com/users";
	public static final String CONST_URL_PUBLICACION = "https://jsonplaceholder.typicode.com/posts?userId=";
	public static final String CONST_URL_FOTO = "https://jsonplaceholder.typicode.com/photos/";
	public static final String CONST_METODO_HTTP = "GET";
	public static final String CONST_ACCEPT = "Accept";
	public static final String CONST_JSON =  "application/json";
	public static final String CONST_LOG_USUARIO= "USUARIOS";
	public static final String CONST_LOG_PUBLICACIONES = "PUBLICACIONES";
	public static final String CONST_LOG_FOTOS = "FOTOS";
}
