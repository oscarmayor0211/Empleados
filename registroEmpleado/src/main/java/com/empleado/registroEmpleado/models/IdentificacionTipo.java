package com.empleado.registroEmpleado.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="tipoIdentificacion")
public class IdentificacionTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idIdentificacionTipo")
    private int idIdentificacionTipo;

    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;
}
