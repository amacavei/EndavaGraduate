import { Component, Input, Output, EventEmitter} from '@angular/core';
import { Router,ROUTER_DIRECTIVES } from '@angular/router';

import { User } from './user';
import { LoginService } from './login.service';

@Component({
	selector : 'login-cmp',
	templateUrl : './pages/login/components/login.html',
	directives: [ROUTER_DIRECTIVES],
	providers: [LoginService]
})

export class LoginComponent {
	@Input() user: User;
	@Output() userDetails = new EventEmitter();
	username: String;
	password: String;
	error: any;

	constructor(
		public router: Router,
		private loginService: LoginService
	) {}

	post() {
		this.user = {
			username: this.username,
			password: this.password
		}
	    this.loginService
	        .post(this.user)
	        .then(user => {
	          this.user = user; // saved hero, w/ id if new
						this.get();
						this.router.navigateByUrl('/dashboard/home');
	        })
	        .catch(error => this.error = error); // TODO: Display error message
	  }

		get() {
			this.user = {
				username: this.username,
				password: this.password
			}
		    this.loginService
		        .get(this.user)
		        .then(user => {
		          this.user = user; // saved hero, w/ id if new
							console.log(this.user);
						})
		        .catch(error => this.error = error); // TODO: Display error message
		  }


}
