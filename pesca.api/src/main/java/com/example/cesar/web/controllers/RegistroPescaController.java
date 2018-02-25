package com.example.cesar.web.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.cesar.core.model.RegistroPesca;
import com.example.cesar.core.services.RegistroPescaService;
import com.example.cesar.util.ErrorDTO;

@CrossOrigin(origins= "*", maxAge =3600)
@RestController
@RequestMapping("/registro-pesca")
public class RegistroPescaController {
public static final Logger logger = LoggerFactory.getLogger(RegistroPescaController.class);

@Autowired
private RegistroPescaService registroPescaService;

//================ RECUPERAMOS TODOS LOS PERFILES ================
@SuppressWarnings("rawtypes")
@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> listarRegistros() {
	List<RegistroPesca> registros = registroPescaService.listarTodos();
	if (registros.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		// podríamos retornar también HttpStatus.NOT_FOUND
	}
	return new ResponseEntity<List<RegistroPesca>>(registros, HttpStatus.OK);
}

//================ RECUPERAMOS UN PERFILES A PARTIR DE SU ID ================ 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRegistroPesca(@PathVariable("id") long id) {
		logger.info("Vamos a obtener el registro con id {}.", id);
		RegistroPesca registros =  registroPescaService.getById(id);
		if (registros == null) {
			logger.error("No se encontró ningún registros con id {}.", id);
			return new ResponseEntity<ErrorDTO>(new ErrorDTO(
					"No se encontró ningún Peril con id " + id), HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<RegistroPesca>(registros, HttpStatus.OK);

	}
	
	// ================ CREAMOS UN PERFIL ================
		@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> crearRegistroPesca(@RequestBody RegistroPesca registro, UriComponentsBuilder ucBuilder) {
		logger.info("Creando el RegistroPesca : {}", registro);
		if (registroPescaService.isExisteRegistroPesca(registro)) {
			logger.error("Inserción fallida. Ya existe un registro con el nombre de responsable {}", registro.getNombre_responsable());
			return new ResponseEntity<ErrorDTO>(
					new ErrorDTO("Inserción Fallida. Ya existe un registro con el perfil " + registro.getNombre_responsable()),
					HttpStatus.CONFLICT);

		}
		registroPescaService.guardarRegistroPesca(registro);
			 HttpHeaders headers = new HttpHeaders();
			 headers.setLocation(ucBuilder.path("/registro-pesca/{id}").buildAndExpand(registro.getId()).toUri());
			 return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
		
		// ================ ACTUALIZAMOS LOS DATOS DE UN PERFIL ================ 
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> actualizarRegistroPesca(@PathVariable("id") long id, @RequestBody RegistroPesca registro) {
			logger.info("Actualizando el Perfil con id {}", id);
			RegistroPesca registroBD = registroPescaService.getById(id);
			if (registroBD == null) {
				 logger.error("Actualización fallida. No existe el registro con el id {}.", id);
				 return new ResponseEntity<ErrorDTO>(
						 new ErrorDTO("Actualización fallida. No existe el registro con el id " + id), HttpStatus.NOT_FOUND);

			}
			registroBD.setId_tipo_pesca(registro.getId_tipo_pesca());
			registroBD.setCant_personas(registro.getCant_personas());
			registroBD.setCant_horas_planificadas(registro.getCant_horas_planificadas());
			registroBD.setCantidad_horas_reales(registro.getCantidad_horas_reales());
			registroBD.setMonto_horas_reales(registro.getMonto_horas_reales());
			registroBD.setNombre_responsable(registro.getNombre_responsable());
			registroBD.setEstado(registro.getEstado());
			registroBD.setCantidad_horas_reales(registro.getCantidad_horas_reales());
			
			registroPescaService.guardarRegistroPesca(registroBD);
			 return new ResponseEntity<RegistroPesca>(registroBD, HttpStatus.OK);

		}
		
		// ================ ELIMINAMOS UN PERFIL ================ 
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> eliminarRegistroPesca(@PathVariable("id") int id) {
			logger.info("Obteniendo y eliminando el Registro con id {}", id);
			RegistroPesca pesca = registroPescaService.getById(id);
			if (pesca == null) {
				logger.error("Eliminación fallida. No existe el RegistroPesca con el id {}", id);
				return new ResponseEntity<ErrorDTO>(new ErrorDTO("No existe el RegistroPesca con el id " + id),
						HttpStatus.NOT_FOUND);

			}
			registroPescaService.eliminarRegistroPescaById(id);
			return new ResponseEntity<RegistroPesca>(HttpStatus.NO_CONTENT);
		}
		
		// ================ ELIMINAMOS TODOS LOS USUARIOS ================
		@RequestMapping(value = "/", method = RequestMethod.DELETE)
		public ResponseEntity<RegistroPesca> eliminarPerfiles () {
			logger.info("Borrando todos los perfiles");
			registroPescaService.eliminarTodos();
			return new ResponseEntity<RegistroPesca>(HttpStatus.NO_CONTENT);
		}

}