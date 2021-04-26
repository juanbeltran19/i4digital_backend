/**
 * Copyright (c) 2021 i4digital
 * <br><A HREF="http://www.i4digital.com>"</br>
 * Todos los derechos reservados.
 */
package co.com.i4digital.repositorio;


import co.com.i4digital.modelo.TransaccionesUsuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * interface que implementa el registro de log de ejecucion del usuario
 *
 * @version
 * @author juanpbeltran
 * <br><b>Fecha de desarrollo : </b> 24/04/2021
 * <br><b>Fecha de modificación : </b> 00/00/0000
 */
@SuppressWarnings("rawtypes")
@Repository
public interface RepositorioTransaccionesUsuarios extends JpaRepository<TransaccionesUsuarios, Integer> {
}
