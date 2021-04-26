/**
 * Copyright (c) 2021 i4digital
 * <br><A HREF="http://www.i4digital.com>"</br>
 * Todos los derechos reservados.
 */
package co.com.i4digital.modelo;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


/**
 * Clase modelo que se encarga de persistir la informacion de la trazabilidad 
 * de cada ejecucion por el cliente de la aplicacion
 *
 * @version
 * @author juanpbeltran
 * <br><b>Fecha de desarrollo : </b> 24/04/2021
 * <br><b>Fecha de modificación : </b> 00/00/0000
 */

@Entity
@Table(name="LOGSUSUARIOS")
public class TransaccionesUsuarios {
	
	@Id
	@Column(name="id_transaccionusuario")
	private Integer idTransaccionUsuario;	
	
	@Column(name="resultado")
	private String resultado;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="servicio")
	private String servicio;	
	
	public TransaccionesUsuarios() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		this.fecha = LocalDate.now().toString() + dateFormat.format(date); 		
	}
	
	public String getResultado() {
		return resultado;
	}
	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Integer getIdTransaccionUsuario() {
		return idTransaccionUsuario;
	}
	/**
	 * @param idTransaccionUsuario the idTransaccionUsuario to set
	 */
	public void setIdTransaccionUsuario(Integer idTransaccionUsuario) {
		this.idTransaccionUsuario = idTransaccionUsuario;
	}	
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}	

}
