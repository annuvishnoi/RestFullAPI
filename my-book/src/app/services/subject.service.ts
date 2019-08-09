import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable()
export class SubjectService {
    baseUrl: string = 'http://localhost:9080/mavenweb/api/subjects/'
    constructor(public http: HttpClient) { }
    getSubjects(): Observable<any> {
        return this.http.get(this.baseUrl);
    }
   
    saveSubject(formValue): Observable<any>{       
        return this.http.post(this.baseUrl, formValue);
    }
}