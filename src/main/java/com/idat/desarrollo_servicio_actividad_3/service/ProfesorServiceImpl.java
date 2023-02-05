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
	public void delete(Integer profesorId) {
		repository.deleteById(profesorId);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Integer profesorId) {
		return repository.findById(profesorId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Profesor> findAll() {
		return (Collection<Profesor>) repository.findAll();
	}

}
