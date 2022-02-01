import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpleadoListComponent } from './pages/empleado-list/empleado-list.component';
import { EmpleadoComponent } from './pages/empleado/empleado.component';


const routes: Routes = [
  {path : "empleado", component: EmpleadoComponent},
  {path: "empleados", component: EmpleadoListComponent},
  { path: "**", redirectTo: "empleado", pathMatch: "full" },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
