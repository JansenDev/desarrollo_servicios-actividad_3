package com.idat.desarrollo_servicio_actividad_3.service;

import java.util.Collection;

import com.idat.desarrollo_servicio_actividad_3.model.Aula;

public interface AulaService {
	
	public abstract void insert(Aula aula);
	public abstract void update(Aula aula);
	public abstract void delete(Integer aula_id);
	public abstract Aula findById(Integer aula_id);
	public abstract Collection<Aula> finAll();
}
