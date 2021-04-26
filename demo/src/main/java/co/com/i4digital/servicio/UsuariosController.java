/**
 * Copyright (c) 2021 i4digital
 * <br><A HREF="http://www.i4digital.com>"</br>
 * Todos los derechos reservados.
 */
package co.com.i4digital.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import co.com.i4digital.modelo.Foto;
import co.com.i4digital.modelo.Publicaciones;
import co.com.i4digital.modelo.Usuario;
import co.com.i4digital.modelo.TransaccionesUsuarios;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Clase que se encarga de proveer los servicios rest para el frontend de los
 * usuarios de aplicacion
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 24/04/2021 <br>
 *         <b>Fecha de modificación : </b> 00/00/0000
 */

@RestController
@RequestMapping("v1")
public class UsuariosController {

	private final Logger LOOGER = LoggerFactory.getLogger(UsuariosController.class);
	private ConsumidorServicioUsuarioRest consumidorServicioUsuarioRest = null;

	@Autowired
	ServicioTransaccionesUsuarios servicioTransaccionesUsuarios;

	/**
	 * Metodo que se encarga de guardar el log de usuarios
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 24/04/2021 <br>
	 *         <b>Fecha de modificación : </b> 00/00/0000
	 * 
	 * 
	 */
	@GetMapping("/usuarios")
	@ResponseBody
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = null;
		String resultado = "";
		try {
			// Se consume la api servicio web externa usuarios
			consumidorServicioUsuarioRest = new ConsumidorServicioUsuarioRest();
			resultado = consumidorServicioUsuarioRest
					.consumidorServicioUsuarioRest(ConstantesServicioUsuarios.CONST_URL_USUARIO);

			// Se guarda la transacion en base de datos
			TransaccionesUsuarios transaccionesUsuarios = new TransaccionesUsuarios();
			transaccionesUsuarios.setIdTransaccionUsuario(0);
			transaccionesUsuarios.setResultado(resultado);
			transaccionesUsuarios.setFecha(transaccionesUsuarios.getFecha());
			transaccionesUsuarios.setServicio(ConstantesServicioUsuarios.CONST_LOG_USUARIO);
			servicioTransaccionesUsuarios.guardarUsuarios(transaccionesUsuarios);

			// Se mapea los datos json a objetos usuarios
			Gson gson = new Gson();
			Type tipoListaUsuarios = new TypeToken<List<Usuario>>() {
			}.getType();
			usuarios = gson.fromJson(resultado, tipoListaUsuarios);
		} catch (IOException e) {
			LOOGER.error("Error Metodo listarUsuarios: " + e.getMessage());
		}
		return usuarios;
	}

	/**
	 * Metodo que se encarga de guardar el log de publicaciones
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 25/04/2021 <br>
	 *         <b>Fecha de modificación : </b> 00/00/0000
	 * 
	 * @param userId objeto de int
	 */
	@GetMapping("/publicaciones/{id}")
	@ResponseBody
	public List<Publicaciones> listarPublicacionesUsuarios(@PathVariable("id") int userId) {
		List<Publicaciones> publicaciones = null;
		String resultado = "";
		try {
			// Se consume la api servicio web externa publicaciones
			consumidorServicioUsuarioRest = new ConsumidorServicioUsuarioRest();
			resultado = consumidorServicioUsuarioRest
					.consumidorServicioUsuarioRest(ConstantesServicioUsuarios.CONST_URL_PUBLICACION + "" + userId);

			// Se guarda la transacion en base de datos
			TransaccionesUsuarios transaccionesUsuarios = new TransaccionesUsuarios();
			transaccionesUsuarios.setIdTransaccionUsuario(0);
			transaccionesUsuarios.setResultado(resultado);
			transaccionesUsuarios.setFecha(transaccionesUsuarios.getFecha());
			transaccionesUsuarios.setServicio(ConstantesServicioUsuarios.CONST_LOG_PUBLICACIONES);
			servicioTransaccionesUsuarios.guardarUsuarios(transaccionesUsuarios);

			// Se mapea los datos json a objetos publicaciones
			Gson gson = new Gson();
			Type tipoListaPublicaciones = new TypeToken<List<Publicaciones>>() {
			}.getType();
			publicaciones = gson.fromJson(resultado, tipoListaPublicaciones);
		} catch (IOException e) {
			LOOGER.error("Error Metodo listarPublicacionesUsuarios: " + e.getMessage());
		}
		return publicaciones;
	}

	/**
	 * Metodo que se encarga de mostrar el logs
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 25/04/2021 <br>
	 *         <b>Fecha de modificación : </b> 00/00/0000
	 * 
	 * @param userId objeto de int
	 */
	@GetMapping("/logs")
	@ResponseBody
	public List<TransaccionesUsuarios> getTransaccionesUsuarios() {
		List<TransaccionesUsuarios> transaccionesUsuarios = null;
		try {
			transaccionesUsuarios = servicioTransaccionesUsuarios.obtenerTransaccionesUsuarios();
		} catch (Exception e) {
			LOOGER.error("Error Metodo getTransaccionesUsuarios: " + e.getMessage());
		}
		return transaccionesUsuarios;
	}

	// https://jsonplaceholder.typicode.com/photos/2
	/**
	 * Metodo que se encarga de obtener foto
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 25/04/2021 <br>
	 *         <b>Fecha de modificación : </b> 00/00/0000
	 * 
	 * @param userId objeto de int
	 */
	@GetMapping("/fotos/{id}")
	@ResponseBody
	public Foto getFoto(@PathVariable("id") int userId) {
		Foto foto = null;
		String resultado = "";
		try {
			// Se consume la api servicio web externa
			consumidorServicioUsuarioRest = new ConsumidorServicioUsuarioRest();
			resultado = consumidorServicioUsuarioRest
					.consumidorServicioUsuarioRest(ConstantesServicioUsuarios.CONST_URL_FOTO + "" + userId);

			// Se guarda la transacion en base de datos
			TransaccionesUsuarios transaccionesUsuarios = new TransaccionesUsuarios();
			transaccionesUsuarios.setIdTransaccionUsuario(0);
			transaccionesUsuarios.setResultado(resultado);
			transaccionesUsuarios.setFecha(transaccionesUsuarios.getFecha());
			transaccionesUsuarios.setServicio(ConstantesServicioUsuarios.CONST_LOG_FOTOS);
			servicioTransaccionesUsuarios.guardarUsuarios(transaccionesUsuarios);

			// Se mapea los datos json a objetos fotos
			Gson gson = new Gson();
			Type tipoFoto = new TypeToken<Foto>() {
			}.getType();
			foto = gson.fromJson(resultado, tipoFoto);
		} catch (IOException e) {
			LOOGER.error("Error Metodo getFoto: " + e.getMessage());
		}
		return foto;
	}

}
