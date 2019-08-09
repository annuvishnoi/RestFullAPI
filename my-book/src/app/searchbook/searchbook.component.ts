import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';
import { ModalService } from 'src/app/modal/modal-service';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})
export class SearchbookComponent implements OnInit {
  searchText: string = "";
  result: any;

  constructor(private bookService: BookService, private modalService: ModalService) { }

  ngOnInit() {
  
  }
  searhBook() {
    this.bookService.getBooksById(this.searchText).subscribe((response) =>{             
      this.result = response;
    }, error => {
      this.modalService.confirmOK("No Record Found..", () => {}, "Error");          
      this.result = null;    
    });
  }

}
