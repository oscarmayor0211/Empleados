export interface Empleado {
   id_empleado : number;
   primerNombre : string;
   segundoNombre: string;
   primerApellido: string;
   segundoApellido:string;
   cedula : string;
   tipoIdentificacion : TipoIdentificacion;
   correo : string;
   area:Area;
   estado:string;
   paisEmpleo: Pais;
   fechaIngreso:Date;
   fechaHoraIngreso:Date;
}

export interface Area{
   idArea : number,
   area : string
}

export interface TipoIdentificacion {
   idIdentificacionTipo: number,
   tipoIdentificacion: string
}

export interface Pais{
   idPais: number,
   pais: string
}