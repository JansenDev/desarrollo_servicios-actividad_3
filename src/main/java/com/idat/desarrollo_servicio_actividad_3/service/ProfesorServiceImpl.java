package com.idat.desarrollo_servicio_actividad_3.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.desarrollo_servicio_actividad_3.model.Profesor;
import com.idat.desarrollo_servicio_actividad_3.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	private ProfesorRepository repository;
	
	
	@Override
	@Transactional
	public void insert(Profesor profesor) {
		repository.save(profesor);
	}

	@Override
	@Transactional
	public void update(Profesor profesor) {
		repository.save(profesor);
	}

	@Override
	@Transactional
	public void delete(Integer profesor_id) {
		repository.deleteById(profesor_id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Profesor findById(Integer profesor_id) {
		return repository.findById(profesor_id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Profesor> finAll() {
		return (Collection<Profesor>)repository.findAll();
	}

}
