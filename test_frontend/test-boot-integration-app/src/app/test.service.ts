import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Test } from './test';

@Injectable({
  providedIn: 'root'
})
export class TestService 
{
  public finalmark:number=0;

  private url:string;
  constructor(private http:HttpClient)
   {
    this.url="http://localhost:9100/test"
    }

    
    public getAllQuestions():Observable<Test[]>
    {
      return this.http.get<Test[]>(this.url+"s");
    }

    public mark(marks:number):any
    {
        this.finalmark= marks;
    }

    
    

}
