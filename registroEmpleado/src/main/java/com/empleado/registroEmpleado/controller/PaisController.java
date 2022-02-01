package com.empleado.registroEmpleado.controller;

import com.empleado.registroEmpleado.exceptions.InvalidDataException;
import com.empleado.registroEmpleado.models.Pais;
import com.empleado.registroEmpleado.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pais")
public class PaisController {
    @Autowired
    PaisService paisService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> getAllArea(){
        return paisService.getAllPais();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createArea(@Valid @RequestBody Pais pais, BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return ResponseEntity.ok().body(paisService.createPais(pais));
    }
}
