import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DisplayComponent } from './display/display.component';
import { TaketestComponent } from './taketest/taketest.component';


const routes: Routes = [
  {path:'display-answers',component:DisplayComponent},
  {path:'take-test',component:TaketestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
