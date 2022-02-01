import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";

import { Router } from '@angular/router';
import { Area, Empleado, Pais, TipoIdentificacion } from 'src/app/model/Empleado.model';
import { EmpleadoService } from 'src/app/services/empleado.service';
import Swal from "sweetalert2";
@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css']
})
export class EmpleadoComponent implements OnInit {
  empleados : Empleado[];
  pais : Pais[];
  area : Area[];
  tipoIdentificacion : TipoIdentificacion[];
  state: boolean = true;
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private empleadoService : EmpleadoService,
    private router: Router
  ) {}

  ngOnInit() {
    this.createForm();
     this.getPersonaAll();
     this. getPaisAll();
    this.getAreaAll();
    this.getIdentificacionAll();
    
  }

  createForm() {
    this.form = this.fb.group({
      id_empleado: [],
      primerNombre: ["", Validators.required],
      segundoNombre: [null, Validators.required],
      primerApellido: ["", Validators.required],
      segundoApellido: [null, Validators.required],
      cedula: [null,Validators.required],
      idIdentificacionTipo: [1, Validators.required],
      correo: [null, Validators.required],
      idArea: [null, Validators.required],
      estado: ["ACTIVO", Validators.required],
      idPais: [null,Validators.required],
      fechaIngreso: ["", Validators.required],
      fechaHoraIngreso :["2022-01-31T21:07:40.914"]
    });
  }

  

  getPersonaAll() {
    this.empleadoService.getPersonaAll().subscribe((empleado: any) => {
      console.log(empleado);
      
      this.empleados = empleado;
    });
  }

  getPaisAll() {
    this.empleadoService.getAllPais().subscribe((pais: any) => {
      console.log(pais);
      
      this.pais = pais;
    });
  }
  getIdentificacionAll() {
    this.empleadoService.getAllTipoIdentificacion().subscribe((id: any) => {
      console.log(id);
      
      this.tipoIdentificacion = id;
    });
  }

  
  getAreaAll() {
    this.empleadoService.getAllArea().subscribe((area: any) => {
      console.log(area);
      
      this.area = area;
    });
  }
  

  createUsuario() {
    console.log(this.form.value.id_empleado);
    
    if (this.form.value.id_empleado === null) {
      console.log("entro");
      
      this.empleadoService.postPersona(this.form.value).subscribe(
        (persona: any) => {
         
          
          this.empleados = [...this.empleados, persona];
          console.log(persona);
          console.log(this.empleados);
          
          Swal.fire("Empleado Creado");
          // this.resetFormulario();
        },
       
      );
    } else {
      this.state = false;
      this.empleadoService
        .putPersona(this.form.value)
        .subscribe((produ: any) => {
          this.state = true;
          this.getPersonaAll();
          Swal.fire("Producto Editado");
          // this.resetFormulario();
        });
    }
  }



  handleDeletePersona(id: number) {
    Swal.fire({
      title: "Desear Eliminar el Empleado?",
      text: "Eliminar el Empleado",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Eliminar!",
    }).then((borrar) => {
      if (borrar.value) {
        this.empleadoService.deletePersona(id).subscribe(() => {
          console.log(id);
          
          this.getPersonaAll();
        });
      }
    });
  }

  handleEditPersona(empleado: Empleado) {
    this.state = false;
    this.form.setValue({
      id_empleado : empleado.id_empleado,
      primerNombre : empleado.primerNombre,
      segundoNombre : empleado.segundoNombre,
      primerApellido : empleado.primerApellido,
      segundoApellido : empleado.segundoApellido,
      paisEmpleo : empleado.paisEmpleo,
      area : empleado.area,
      estado : empleado.estado,
      tipoId : empleado.tipoIdentificacion,
      cedula : empleado.cedula,
      correo : empleado.correo,
      fechaIngreso : empleado.fechaIngreso
    });
  }
}
