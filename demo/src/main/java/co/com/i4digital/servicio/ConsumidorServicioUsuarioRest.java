/**
 * Copyright (c) 2021 i4digital
 * <br><A HREF="http://www.i4digital.com>"</br>
 * Todos los derechos reservados.
 */
package co.com.i4digital.servicio;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase que se encarga de consumir 
 * la api del servicio rest externo 
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 25/04/2021 <br>
 *         <b>Fecha de modificación : </b> 00/00/0000
 */
public class ConsumidorServicioUsuarioRest {
	
	/**
	 * Metodo que se encarga de devorlver el json de 
	 * la api del servicio rest externo 
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 25/04/2021 <br>
	 *         <b>Fecha de modificación : </b> 00/00/0000
	 * 
	 * @param urlServicio objeto de String 
	 */		
	public String consumidorServicioUsuarioRest(String urlServicio) throws IOException {
	//url apuntando al servicio
	URL url = new URL( urlServicio );
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	//indico el metodo HTTP a utilizar
	conn.setRequestMethod( ConstantesServicioUsuarios.CONST_METODO_HTTP );
	
	//indico el tipo de contenido espero recibir
	conn.setRequestProperty(ConstantesServicioUsuarios.CONST_ACCEPT, ConstantesServicioUsuarios.CONST_JSON);
	BufferedReader br = new BufferedReader(
			new InputStreamReader(
					conn.getInputStream()));
	
	//recibo el contenido
	String salida;
	String resultado="";
	while((salida = br.readLine())!=null) {
		resultado = resultado + salida;
	}
	
		return resultado;
	}

}
