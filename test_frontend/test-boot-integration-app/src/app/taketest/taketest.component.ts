import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { TestService } from '../test.service';

@Component({
  selector: 'app-taketest',
  templateUrl: './taketest.component.html',
  styleUrls: ['./taketest.component.css']
})
export class TaketestComponent implements OnInit {

  answerarr:string[]=[];
  temp1:string="";
  temp2:string="";
  temp3:string="";
  temp4:string="";
  temp5:string="";
  radioChangeHandler(event:any)
   { 
    
     if(event.target.checked)
     {
      if(event.target.name==="captain")
      {
       this.answerarr[0]=event.target.value;
       this.temp1=event.target.value;
      }
      else if(event.target.name==="LBW")
      {
        this.answerarr[1]=event.target.value;
        this.temp2=event.target.value;
      }
      else if(event.target.name==="nickname")
      {
        this.answerarr[2]=event.target.value;
        this.temp3=event.target.value;
      }
      else if(event.target.name==="short-temper")
      {
        this.answerarr[3]=event.target.value;
        this.temp4=event.target.value;
      }
      else if(event.target.name==="cup")
      {
        this.answerarr[4]=event.target.value;
        this.temp5=event.target.value;
      }
       
     }
   }
   private tests:Test[]=[];
  constructor(private service:TestService)
   {

    }
    backendarr()
    {
     this.service.getAllQuestions().subscribe(res=>{
       this.tests=res});
    }

  ngOnInit()
   {
    this.backendarr();
  }
  mark:number=0;
   result:string="";
  evaluate()
  { 

       for (let index = 0; index < 5; index++)
     {
            if(this.tests[index].answer==this.answerarr[index])
       {
            this.mark++
          // console.log(this.tests[index].answer);
          // console.log(this.answerarr[index]);
   
       }
     }
      this.result="evaluated press SUBMIT to see your score";
      this.service.mark(this.mark);
  }

}
