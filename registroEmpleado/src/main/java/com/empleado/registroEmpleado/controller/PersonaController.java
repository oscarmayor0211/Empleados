package com.empleado.registroEmpleado.controller;

import com.empleado.registroEmpleado.exceptions.InvalidDataException;
import com.empleado.registroEmpleado.models.Persona;
import com.empleado.registroEmpleado.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> getAllPersonas(){
        return personaService.getAllPersona();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createPersona(@Valid @RequestBody Persona persona, BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return ResponseEntity.ok().body(personaService.createPersona(persona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> deletePersona(@PathVariable long id){
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updatePersona(@Valid @PathVariable long id, @RequestBody Persona persona,  BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        persona.setId_empleado(id);
        return ResponseEntity.ok().body(personaService.updatePersona(persona));
    }
}
