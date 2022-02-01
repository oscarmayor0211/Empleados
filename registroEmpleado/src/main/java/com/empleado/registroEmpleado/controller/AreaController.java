package com.empleado.registroEmpleado.controller;

import com.empleado.registroEmpleado.exceptions.InvalidDataException;
import com.empleado.registroEmpleado.models.Area;
import com.empleado.registroEmpleado.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/area")
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Area> getAllArea(){
        return areaService.getAllArea();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createArea(@Valid @RequestBody Area area, BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        return ResponseEntity.ok().body(areaService.createArea(area));
    }
}
