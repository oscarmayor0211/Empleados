package com.empleado.registroEmpleado.services;

import com.empleado.registroEmpleado.models.Area;
import com.empleado.registroEmpleado.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaRepository areaRepository;
    @Override
    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public List<Area> getAllArea() {
        return areaRepository.findAll();
    }
}
