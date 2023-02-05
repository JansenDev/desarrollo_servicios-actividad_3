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

import com.idat.desarrollo_servicio_actividad_3.model.Aula;
import com.idat.desarrollo_servicio_actividad_3.service.AulaService;


@RestController
@RequestMapping("/aulas")
public class AulaRestController {
	
	@Autowired
	private AulaService aulaService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Aula> itemAulas=aulaService.finAll();
		return new ResponseEntity<>(itemAulas,HttpStatus.OK);
	}
	
	
	@PostMapping("/agregar")
	public  ResponseEntity<?> agregar(@RequestBody Aula aula){
		aulaService.insert(aula);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{aula_id}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer aula_id) {
		Aula aula=aulaService.findById(aula_id);		
		if(aula!=null) {
			return new ResponseEntity<>(aula,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PutMapping("/editar/{aula_id}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer aula_id,
                                        @RequestBody Aula newAlula) {		
		Aula aula=aulaService.findById(aula_id);		
		if(aula!=null) {
			aula.setGrado(newAlula.getGrado());
			aula.setSeccion(newAlula.getSeccion());
			aula.setForo(newAlula.getForo());		
			aulaService.update(aula);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	
}


























