package com.idat.desarrollo_servicio_actividad_3.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.desarrollo_servicio_actividad_3.model.Alumnos;
import com.idat.desarrollo_servicio_actividad_3.repository.AlumnosRepository;

@Service
public class AlumnosServiceImpl implements AlumnosService{
	@Autowired
	private AlumnosRepository repository;
	
	@Override
	@Transactional
	public void insert(Alumnos alumnos) {
		repository.save(alumnos);
	}

	@Override
	@Transactional
	public void update(Alumnos alumnos) {
		repository.save(alumnos);		
	}

	@Override
	@Transactional
	public void delete(Integer alumnosId) {
		repository.deleteById(alumnosId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Alumnos findById(Integer alumnosId) {
		return repository.findById(alumnosId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Alumnos> findAll() {
		return (Collection<Alumnos>)repository.findAll();
	}	
}
