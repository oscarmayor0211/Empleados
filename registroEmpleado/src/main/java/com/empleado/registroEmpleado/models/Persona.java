package com.empleado.registroEmpleado.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="empleado")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleado")
    private long id_empleado;

    @Length(min = 2, max = 20, message = "Verifique que la longitud de la cadena esté dentro del rango especificado")
    private String primerNombre;

    @Length(min = 2, max = 50, message = "Verifique que la longitud de la cadena esté dentro del rango especificado")
    private String segundoNombre;

    @Length(min = 2, max = 20, message = "Verifique que la longitud de la cadena esté dentro del rango especificado")
    private String primerApellido;

    @Length(min = 2, max = 20, message = "Verifique que la longitud de la cadena esté dentro del rango especificado")
    private String segundoApellido;

    @Length(min = 1, max = 20, message = "Verifique que la longitud de la cadena esté dentro del rango especificado")
    private String cedula;

    @Column(name="idIdentificacionTipo")
    private long idIdentificacionTipo;

    @Length(min = 8, max = 300, message = "Verifique que la longitud de la cadena esté dentro del rango especificado")
    private String correo;

    @Column(name="idArea")
    private long idArea;

    @Column(name="estado")
    private String estado;

    @Column(name="idPais")
    private int idPais;


    @Column(name="fechaIngreso")
    private LocalDate fechaIngreso;

   // @JsonFormat(pattern = "DD-MM-YYYY HH:mm:ss")
    @Column(name="fechaHoraIngreso")
    private final LocalDateTime fechaHoraIngreso = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "idPais", insertable = false,updatable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "idArea", insertable = false,updatable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idIdentificacionTipo", insertable = false,updatable = false)
    private IdentificacionTipo IdentificacionTipo;

    public void construirCorreo(){
        switch (getIdPais()){
            case 1:
                setCorreo(getPrimerNombre().toLowerCase()+"."+getPrimerApellido().toLowerCase()+"."+getCedula()+"@cidenet.com.co");
            break;
            case 2:
                setCorreo(getPrimerNombre().toLowerCase()+"."+getPrimerApellido().toLowerCase()+"."+getCedula()+"@cidenet.com.us");
                break;
        }
    }
}
