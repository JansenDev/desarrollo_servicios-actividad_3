package com.idat.desarrollo_servicio_actividad_3.controller;


import com.idat.desarrollo_servicio_actividad_3.model.Conyuge;
import com.idat.desarrollo_servicio_actividad_3.repository.ConyugeRepository;
import com.idat.desarrollo_servicio_actividad_3.service.ConyugeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conyuge")
public class ConyugeController {

    @Autowired
    private ConyugeService conyugeService;

    @GetMapping("/listar")
    public ResponseEntity<List<Conyuge>> listarTodo() {
        List<Conyuge> conyuges = conyugeService.findAll();

        return new ResponseEntity(conyuges, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> registrar(@RequestBody Conyuge conyuge) {
        conyugeService.insert(conyuge);

        return new ResponseEntity(true, HttpStatus.CREATED);
    }


    @GetMapping("/buscar/{id}")
    @ResponseBody
    public ResponseEntity<Conyuge> buscar(@PathVariable("id") Integer id) {

        Conyuge conyuge = conyugeService.findXId(id);
        if (conyuge != null) {
            return new ResponseEntity<>(conyuge, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Conyuge conyuge) {
        conyugeService.update(conyuge);

        return new ResponseEntity(true, HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        conyugeService.deletebyId(id);

        return new ResponseEntity(true, HttpStatus.CREATED);
    }

}
