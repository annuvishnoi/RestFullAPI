import { Component, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';
import { SubjectService } from '../services/subject.service';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { BsModalService, BsModalRef } from 'ngx-bootstrap';
import { ModalService } from 'src/app/modal/modal-service';
import { Router } from '@angular/router';

@Component({
  selector: 'add-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  model: any = {};
  books: any[];
  subjects: any[];
  bsModalRef: BsModalRef;
  constructor(private bookService: BookService, 
              private subjectService: SubjectService, 
              private route: ActivatedRoute,
              private modalService: ModalService,
              private router: Router) { }

  ngOnInit() {
    this.getBook();
    this.subjectService.getSubjects().subscribe((data)=> {
      console.log(data);
      this.subjects = data;
    })
  }
  getBook() {
    let bookId = this.route.snapshot.paramMap.get('id');
    if(bookId) {
      this.bookService.getBooksById(bookId).subscribe((data)=> {
        this.model = data;
        let dateStr =  new Date(this.model.publishDate);     
        this.model.publishDate = moment(dateStr).format("YYYY-MM-DD");
        console.log(data);
      });
    }
  }
  onSubmit() {
    console.log(this.model);
    if(this.model && this.model.bookId) {
      this.bookService.updateBook(this.model.bookId, this.model).subscribe((response) =>{
        console.log("Book update successfully>>");       
        this.redirectAfterSave("Book updated successfully", () => {
          this.router.navigate(['/books']);
        }, "Success");
      }, error => {
        console.log("error occured>>");        
        this.redirectAfterSave("Error occured..", () => {}, "Error");
      });
    } else {
      this.bookService.saveBook(this.model).subscribe((response) =>{
        console.log("Book save successfully>>");       
        this.redirectAfterSave("Book save successfully", () => {
          this.router.navigate(['/books']);
        }, "Success");
      }, error => {
        console.log("error occured>>");        
        this.redirectAfterSave("Error occured..", () => {}, "Error");
      });
    } 
  }
  redirectAfterSave(popMesg, confirmCallback, popTitle) {
    this.modalService.confirmOK(popMesg, confirmCallback, popTitle);
  
  }


}
