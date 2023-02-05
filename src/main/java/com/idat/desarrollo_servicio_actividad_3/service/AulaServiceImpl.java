package com.idat.desarrollo_servicio_actividad_3.service;

import java.util.Collection;

import com.idat.desarrollo_servicio_actividad_3.model.Aula;
import com.idat.desarrollo_servicio_actividad_3.repository.AulaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AulaServiceImpl implements AulaService{

	@Autowired
	private AulaRepository repository;
	
	
	@Override
	@Transactional
	public void insert(Aula aula) {
		repository.save(aula);
	}

	@Override
	@Transactional
	public void update(Aula aula) {
		repository.save(aula);			
	}

	@Override
	@Transactional
	public void delete(Integer aula_id) {
		repository.deleteById(aula_id);		
	}

	@Override
	@Transactional(readOnly=true)
	public Aula findById(Integer aula_id) {
		return repository.findById(aula_id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Aula> finAll() {
		return (Collection<Aula>)repository.findAll();
	}
	
}
