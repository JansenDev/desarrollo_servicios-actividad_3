package com.idat.desarrollo_servicio_actividad_3.service;

import com.idat.desarrollo_servicio_actividad_3.model.Conyuge;
import com.idat.desarrollo_servicio_actividad_3.repository.ConyugeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ConyugeServiceImpl implements ConyugeService {

    @Autowired
    private ConyugeRepository conyugeRepository;

    @Override
    public void insert(Conyuge conyuge) {
        conyugeRepository.save(conyuge);
    }

    @Override
    public void update(Conyuge conyuge) {
        conyugeRepository.save(conyuge);
    }

    @Override
    public List<Conyuge> findAll() {
        return (List<Conyuge>) conyugeRepository.findAll();
    }

    @Override
    public Conyuge findXId(Integer id) {
        try {
            return conyugeRepository.findById(id).get();
        } catch (Exception e ) {
            return null;
        }
    }

    @Override
    public void deletebyId(Integer id) {
        conyugeRepository.deleteById(id);
    }


}
