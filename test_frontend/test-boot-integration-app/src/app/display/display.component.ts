import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { TestService } from '../test.service';




@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit 
{

  constructor(private service:TestService)
  {

  }
   public marksToDisplay:number;
   public result:string="";
  datatodisplay:string;
  public question_with_answers:Test[]=[];
  show()
  {
  this.marksToDisplay=this.service.finalmark;
  this.datatodisplay="Your Score is";
  }
  ngOnInit()
   {
     console.log("hi");
     this.show();
     this.printextra();
  }
  printextra()
  {
  if(this.marksToDisplay<2)
  {
    this.result="work hard"
  }
  else if(this.marksToDisplay<=4)
  {
    this.result="not bad"
  }
  else 
  {
    this.result="good";
  }
  }

  review()
  {
    this.service.getAllQuestions().subscribe(res=>{
      this.question_with_answers=res});
  }
  
}
