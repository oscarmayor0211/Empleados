package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.Pais;
import com.empleado.registroEmpleado.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaisServiceImpl implements PaisService{
    @Autowired
    PaisRepository paisRepository;
    @Override
    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public List<Pais> getAllPais() {
        return paisRepository.findAll();
    }
}
