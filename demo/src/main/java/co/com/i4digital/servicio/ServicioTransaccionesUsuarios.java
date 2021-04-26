/**
 * Copyright (c) 2021 i4digital
 * <br><A HREF="http://www.i4digital.com>"</br>
 * Todos los derechos reservados.
 */
package co.com.i4digital.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.i4digital.modelo.TransaccionesUsuarios;
import co.com.i4digital.repositorio.RepositorioTransaccionesUsuarios;

/**
 * Clase servicio que se encarga de guardar los datos de log de ejecucion usuarios
 *
 * @version
 * @author juanpbeltran
 * <br><b>Fecha de desarrollo : </b> 24/04/2021
 * <br><b>Fecha de modificación : </b> 00/00/0000
 */

@Service
@Component
@Configuration
@ComponentScan(value = "co.com.i4digital")
public class ServicioTransaccionesUsuarios {
	
	@Autowired
	RepositorioTransaccionesUsuarios repositorioTransaccionesUsuarios;
	
	public ServicioTransaccionesUsuarios() {
	}
	/**
	 * Metodo que se encarga de guardar registros de log de ejecución usuarios
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 24/04/2021 <br>
	 *         <b>Fecha de modificación : </b>  00/00/0000
	 * 
	 * @param auditoriaTransacciones objeto de tipo AuditoriaTransacciones
	 * 
	 */
	public void guardarUsuarios(TransaccionesUsuarios transaccionesUsuarios) {
		repositorioTransaccionesUsuarios.save(transaccionesUsuarios);
	}	
	
	/**
	 * Metodo que se encarga de listar logs de ejecución usuarios
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 25/04/2021 <br>
	 *         <b>Fecha de modificación : </b>  00/00/0000
	 * 
	 * @param auditoriaTransacciones objeto de tipo AuditoriaTransacciones
	 * 
	 */
	public List<TransaccionesUsuarios> obtenerTransaccionesUsuarios() {
		return repositorioTransaccionesUsuarios.findAll();
	}	
}
