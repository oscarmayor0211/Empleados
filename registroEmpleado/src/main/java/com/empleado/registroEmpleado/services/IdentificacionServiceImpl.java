package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.IdentificacionTipo;
import com.empleado.registroEmpleado.repository.IdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IdentificacionServiceImpl implements IdentificacionService{
    @Autowired
    IdentificacionRepository identificacionRepository;
    @Override
    public IdentificacionTipo createTipoIdentificacion(IdentificacionTipo identificacionTipo) {
        return identificacionRepository.save(identificacionTipo);
    }

    @Override
    public List<IdentificacionTipo> getAllIdentificacion() {
        return identificacionRepository.findAll();
    }
}
