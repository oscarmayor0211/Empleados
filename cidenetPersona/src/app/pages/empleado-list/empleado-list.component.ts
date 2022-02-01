import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Empleado } from 'src/app/model/Empleado.model';

@Component({
  selector: 'app-empleado-list',
  templateUrl: './empleado-list.component.html',
  styleUrls: ['./empleado-list.component.css']
})
export class EmpleadoListComponent implements OnInit {
  @Input() empleados : Empleado;
  @Output() editPersona = new EventEmitter<Empleado>();
  @Output() deletPersona = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }
  llenarForm(empleado: Empleado) {
    console.log(empleado);
    
    this.editPersona.emit(empleado);
  }

  deletePersona(id: number) {
    console.log(id);
    
    this.deletPersona.emit(id);
  }
}
