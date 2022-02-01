package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.Area;
import com.empleado.registroEmpleado.models.IdentificacionTipo;
import com.empleado.registroEmpleado.models.Persona;

import java.util.List;

public interface IdentificacionService {
    IdentificacionTipo createTipoIdentificacion(IdentificacionTipo identificacionTipo);
    List<IdentificacionTipo> getAllIdentificacion();
}
