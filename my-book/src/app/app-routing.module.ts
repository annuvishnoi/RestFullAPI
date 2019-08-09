import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookComponent } from './book/book.component';
import { SubjectComponent } from './subject/subject.component';
import { BooklistComponent } from './booklist/booklist.component';
import { SearchbookComponent } from './searchbook/searchbook.component';

const routes: Routes = [
  { path: '', redirectTo: '/addbook', pathMatch: 'full' },
  { path: 'addbook', component: BookComponent },
  { path: 'addbook/:id', component: BookComponent },
  { path: 'addsubject', component: SubjectComponent },
  { path: 'books', component: BooklistComponent },
  
  { path: 'searchbook', component: SearchbookComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
