package com.idat.desarrollo_servicio_actividad_3.service;

import com.idat.desarrollo_servicio_actividad_3.model.Conyuge;

import java.util.List;

public interface ConyugeService {

    abstract void insert(Conyuge conyuge);
    abstract void update(Conyuge conyuge);
    abstract List<Conyuge> findAll();
    abstract Conyuge findXId(Integer id);
    abstract void deletebyId(Integer id);

}
