import { Component, OnInit } from '@angular/core';
import { SubjectService } from '../services/subject.service';
import { ModalService } from 'src/app/modal/modal-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent implements OnInit {
  model: any = {};
  //subjects: any[];
  
  constructor(private subjectService: SubjectService,
    private modalService: ModalService,
    private router: Router) { }
  ngOnInit() {    
    
  }
  onSubmit() {
    this.subjectService.saveSubject(this.model).subscribe((response) => {
      this.modalService.confirmOK("Subject added successfully", () => {this.router.navigate(['/books']);}, "Success");      
    }, error => {
      console.log("error occured>>");        
      this.modalService.confirmOK("Error occured..", () => {}, "Error");
    });
    console.log(this.model);
    
  }

}
