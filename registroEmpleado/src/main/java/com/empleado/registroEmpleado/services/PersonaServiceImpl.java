package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.Persona;
import com.empleado.registroEmpleado.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public Persona createPersona(Persona persona) {
        if (this.existsByCedula(persona.getCedula())) {
            throw new DuplicateKeyException("Error ya existe la persona  con cedula: " + persona.getCedula());
        }
        else if(persona.getPrimerApellido().equals(persona.getPrimerApellido().toUpperCase())==false){
            throw new IllegalArgumentException( "Los nombres y apellidos deben ser digitados en Mayusculas");
        }
        else if(persona.getSegundoApellido().equals(persona.getSegundoApellido().toUpperCase())==false){
            throw new IllegalArgumentException( "Los nombres y apellidos deben ser digitados en Mayusculas");
        }
        else if(persona.getPrimerNombre().equals(persona.getPrimerNombre().toUpperCase())==false) {
            throw new IllegalArgumentException("Los nombres y apellidos deben ser digitados en Mayusculas");
        }
        persona.construirCorreo();
        return personaRepository.save(persona);
    }

    @Override
    public Object updatePersona(Persona persona) {
        Persona personaUpdate = personaRepository.findById(persona.getId_empleado()).orElseThrow(() -> new ResourceAccessException("No se encontro la persona con el id = " + persona.getId_empleado()));
        personaUpdate.setCorreo(persona.getCorreo());
        personaUpdate.setArea(persona.getArea());
        personaUpdate.setCedula(persona.getCedula());
        personaUpdate.setEstado(persona.getEstado());
        personaUpdate.setFechaIngreso(persona.getFechaIngreso());
        personaUpdate.setId_empleado(persona.getId_empleado());
        personaUpdate.setIdPais(persona.getIdPais());
        personaUpdate.setPrimerApellido(persona.getPrimerApellido());
        personaUpdate.setPrimerNombre(persona.getPrimerNombre());
        personaUpdate.setSegundoApellido(persona.getSegundoApellido());
        personaUpdate.setSegundoNombre(persona.getSegundoNombre());
        personaUpdate.setIdIdentificacionTipo(persona.getIdIdentificacionTipo());
        personaRepository.save(persona);
        return personaUpdate;
    }

    @Override
    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    @Override
    public void deletePersona(long id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new ResourceAccessException("No se encontro la persona con el id = " + id));
        personaRepository.delete(persona);
    }

    @Override
    public boolean existsByCedula(String cedula) {
        return personaRepository.existsByCedula(cedula);
    }
}
