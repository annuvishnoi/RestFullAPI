import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable()
export class BookService {
    baseUrl: string = 'http://localhost:9080/mavenweb/api/books/'
    constructor(public http: HttpClient) { }
    getBooks(): Observable<any> {
        return this.http.get(this.baseUrl);
    }

    getBooksById(bookId): Observable<any> {
        return this.http.get(this.baseUrl + bookId);
    }
    saveBook(formValue): Observable<any>{       
        return this.http.post(this.baseUrl, formValue);
    }
    updateBook(bookid, formValue): Observable<any>{       
        return this.http.put(this.baseUrl, formValue);
    }
    deleteBook(bookid): Observable<any>{       
        return this.http.delete(this.baseUrl + bookid);
    }

}