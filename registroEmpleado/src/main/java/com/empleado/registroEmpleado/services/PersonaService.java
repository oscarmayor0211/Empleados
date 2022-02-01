package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.Persona;

import java.util.List;

public interface PersonaService {

    Persona createPersona(Persona persona);

    Object updatePersona(Persona persona);

    List<Persona> getAllPersona();

    void deletePersona(long id);

    boolean existsByCedula(String cedula);

}
