package com.idat.desarrollo_servicio_actividad_3.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Profesor> itemProfesors=profesorService.finAll();
		return new ResponseEntity<>(itemProfesors,HttpStatus.OK);
	}
	
	
	@PostMapping("/agregar")
	public  ResponseEntity<?> agregar(@RequestBody Profesor profesor){
		profesorService.insert(profesor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{profesor_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer profesor_id) {
		Profesor profesor=profesorService.findById(profesor_id);		
		if(profesor!=null) {
			return new ResponseEntity<>(profesor,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PutMapping("/editar/{profesor_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer profesor_id,
                                        @RequestBody Profesor newProfesor) {		
		Profesor profesor=profesorService.findById(profesor_id);		
		if(profesor!=null) {
			profesor.setNombre(newProfesor.getNombre());
			profesor.setApellidos(newProfesor.getApellidos());
			profesor.setEdad(newProfesor.getEdad());
			profesor.setEmail(newProfesor.getEmail());		
			profesorService.update(profesor);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
}



