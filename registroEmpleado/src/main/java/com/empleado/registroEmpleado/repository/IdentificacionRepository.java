package com.empleado.registroEmpleado.repository;

import com.empleado.registroEmpleado.models.IdentificacionTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificacionRepository extends JpaRepository<IdentificacionTipo, Long> {
}
