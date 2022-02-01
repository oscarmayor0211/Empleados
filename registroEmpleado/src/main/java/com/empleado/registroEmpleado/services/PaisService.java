package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.Pais;

import java.util.List;

public interface PaisService {
    Pais createPais(Pais pais);
    List<Pais> getAllPais();
}
