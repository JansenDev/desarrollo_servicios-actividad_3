package com.idat.desarrollo_servicio_actividad_3.service;

import java.util.Collection;

import com.idat.desarrollo_servicio_actividad_3.model.Profesor;

public interface ProfesorService {
	public abstract void insert(Profesor profesor);

	public abstract void update(Profesor profesor);

	public abstract void delete(Integer profesorId);

	public abstract Profesor findById(Integer profesorId);

	public abstract Collection<Profesor> findAll();
}
