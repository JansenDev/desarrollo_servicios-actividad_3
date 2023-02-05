package com.idat.desarrollo_servicio_actividad_3.repository;

import com.idat.desarrollo_servicio_actividad_3.model.Conyuge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ConyugeRepository extends CrudRepository<Conyuge, Integer> {
}
