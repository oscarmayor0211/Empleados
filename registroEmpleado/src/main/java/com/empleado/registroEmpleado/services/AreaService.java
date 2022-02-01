package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.Area;

import java.util.List;

public interface AreaService {
    Area createArea(Area area);
    List<Area> getAllArea();
}
