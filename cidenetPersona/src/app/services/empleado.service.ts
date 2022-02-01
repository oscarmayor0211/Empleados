import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URL_SERVICE } from '../config/config';
import { Empleado } from '../model/Empleado.model';
@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {


  constructor(private http : HttpClient) { }

  getPersonaAll() {
    let url = URL_SERVICE + "/persona";
    return this.http.get(url);
  }
  getAllArea(){
    let url = URL_SERVICE + "/area";
    return this.http.get(url);
  }

  getAllPais(){
    let url = URL_SERVICE + "/pais";
    return this.http.get(url);
  }

  getAllTipoIdentificacion(){
    let url = URL_SERVICE + "/identificacion";
    return this.http.get(url);
  }

  deletePersona(id: number) {
    let url = URL_SERVICE + "/persona/" + id ;
    return this.http.delete(url);
  }

  postPersona(empleado: Empleado){
    console.log(empleado);
    
    let Url = URL_SERVICE + "/persona";
    return this.http.post(Url,empleado);
  }

  putPersona(persona: Empleado) {
    let url = URL_SERVICE + "/persona/" + persona.id_empleado;
    return this.http.put(url, persona);
  }

 
}