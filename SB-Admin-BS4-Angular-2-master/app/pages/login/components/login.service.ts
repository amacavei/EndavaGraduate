import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { User } from './user';

@Injectable()
  export class LoginService {
    private loginUrl = 'https://jira.endava.com/rest/auth/1/session';

    constructor(private http: Http) {}

    handleError(error: any) {
      console.error('An error occured', error);
      return Promise.reject(error.message || error);
    }

    post (user: User): Promise<User> {
      let headers = new Headers({
        'Content-Type': 'application/json'
      });
      return this.http
                 .post(this.loginUrl, JSON.stringify(user), {headers: headers})
                 .toPromise()
                 .then(
                   function(res){
                     var response = res.json();
                     return response.data;
                   })
                 .catch(this.handleError);
    }

    get (user: User): Promise<User> {
      let basicAuth = user.username + ':' + user.password;
      let headers = new Headers({
        'Content-Type': 'application/json',
        'Authorization': 'Basic ' + window.btoa(basicAuth)
      });

      return this.http
                 .get(this.loginUrl, {headers: headers})
                 .toPromise()
                 .then(
                   function(res){
                     localStorage.setItem("header", window.btoa(basicAuth));
                     var response = res.json();
                     return response.data;
                   })
                 .catch(this.handleError);
    }
}
