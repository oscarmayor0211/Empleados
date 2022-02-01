package com.empleado.registroEmpleado.controller;

import com.empleado.registroEmpleado.exceptions.InvalidDataException;
import com.empleado.registroEmpleado.models.IdentificacionTipo;
import com.empleado.registroEmpleado.services.IdentificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/identificacion")
public class IdentificacionController {
    @Autowired
    IdentificacionService identificacionService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IdentificacionTipo> getAllArea(){
        return identificacionService.getAllIdentificacion();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createArea(@Valid @RequestBody IdentificacionTipo identificacionTipo, BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return ResponseEntity.ok().body(identificacionService.createTipoIdentificacion(identificacionTipo));
    }
}
