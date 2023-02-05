package com.idat.desarrollo_servicio_actividad_3.service;

import java.util.Collection;

import com.idat.desarrollo_servicio_actividad_3.model.Alumnos;

public interface AlumnosService {
	public abstract void insert(Alumnos alumnos);
	public abstract void update(Alumnos alumnos);
	public abstract void delete(Integer alumnosId);
	public abstract Alumnos findById(Integer alumnosId);
	public abstract Collection<Alumnos> findAll();

}
