import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule } from  '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { BookService } from './services/book.service';
import { SubjectService } from './services/subject.service';
import { SubjectComponent } from './subject/subject.component';
import { BooklistComponent } from './booklist/booklist.component';
import { SearchbookComponent } from './searchbook/searchbook.component';
import { ConfirmOkComponent } from './modal/confirmok/confirmok.component';
import { ModalService } from './modal/modal-service';
import { ModalModule } from 'ngx-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    SubjectComponent,
    BooklistComponent,
    SearchbookComponent,
    ConfirmOkComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ModalModule.forRoot()
  ],
  exports: [ConfirmOkComponent],
  entryComponents: [ConfirmOkComponent],
  providers: [BookService, SubjectService,  ModalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
