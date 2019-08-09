import { Component, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';
import { Router } from '@angular/router';
import { ModalService } from 'src/app/modal/modal-service';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {
  books : any[] = [];
  
  constructor(private bookService: BookService, 
     private modalService: ModalService,
     private router: Router) { }

  ngOnInit() {
    this.fetchBooks();
  }
  fetchBooks() {
    this.bookService.getBooks().subscribe((data)=> {
      console.log(data);
      this.books = data;
    });
  }
  edit(bookid) {
    this.router.navigate(['/addbook/' + bookid]);
  }
  delete(bookid) {
    this.bookService.deleteBook(bookid).subscribe((response) =>{
      console.log("Book update successfully>>");            
      this.modalService.confirmOK("Book deleted successfully", () => {}, "Success");
      this.fetchBooks(); 
    }, error => {
      console.log("error occured>>");        
      this.modalService.confirmOK("Error occured..", () => {}, "Error");
    });
  }
}
