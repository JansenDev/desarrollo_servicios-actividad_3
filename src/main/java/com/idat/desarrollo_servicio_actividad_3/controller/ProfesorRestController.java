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

import com.idat.desarrollo_servicio_actividad_3.model.Profesor;
import com.idat.desarrollo_servicio_actividad_3.service.ProfesorService;



@RestController
@RequestMapping("/profesor")
public class ProfesorRestController {
	@Autowired
	private ProfesorService profesorService;

	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Profesor> itemsProfesor = profesorService.findAll();
		return new ResponseEntity<>(itemsProfesor, HttpStatus.OK); // Http status code
	}

	@GetMapping("/buscar/{profesorId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer profesorId) {
		Profesor profesor = profesorService.findById(profesorId);
		if (profesor != null) {
			return new ResponseEntity<>(profesor, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Profesor profesor) {
		profesorService.insert(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{profesorId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer profesorId, @RequestBody Profesor newProfesor) {
		Profesor profesor = profesorService.findById(profesorId);
		if (profesor != null) {
			profesor.setNombre(newProfesor.getNombre());
			profesor.setApellidos(newProfesor.getApellidos());
			profesor.setEdad(newProfesor.getEdad());
			profesor.setEmail(newProfesor.getEmail());
			profesorService.update(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{profesorId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer profesorId) {
		Profesor profesor = profesorService.findById(profesorId);

		if (profesor != null) {
			profesorService.delete(profesorId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

}
