package com.idat.desarrollo_servicio_actividad_3.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.desarrollo_servicio_actividad_3.model.Alumnos;
import com.idat.desarrollo_servicio_actividad_3.service.AlumnosService;

@RestController
@RequestMapping("/alumnos")
public class AlumnosRestController {
	@Autowired
	private AlumnosService alumnosService;

	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Alumnos> itemsAlumnos = alumnosService.findAll();
		return new ResponseEntity<>(itemsAlumnos, HttpStatus.OK); // Http status code
	}

	@GetMapping("/buscar/{alumnosId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer alumnosId) {
		Alumnos alumnos = alumnosService.findById(alumnosId);
		if (alumnos != null) {
			return new ResponseEntity<>(alumnos, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Alumnos alumnos) {
		alumnosService.insert(alumnos);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{alumnosId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer alumnosId, @RequestBody Alumnos newAlumno) {
		Alumnos alumnos = alumnosService.findById(alumnosId);
		if (alumnos != null) {
			alumnos.setNombre(newAlumno.getNombre());
			alumnos.setApellidos(newAlumno.getApellidos());
			alumnos.setEdad(newAlumno.getEdad());
			alumnos.setCorreo(newAlumno.getCorreo());
			alumnosService.update(alumnos);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{alumnosId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer alumnosId) {
		Alumnos alumnos = alumnosService.findById(alumnosId);

		if (alumnos != null) {
			alumnosService.delete(alumnosId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}
}
