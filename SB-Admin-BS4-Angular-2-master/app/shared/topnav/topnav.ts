import {Component, Input, ViewEncapsulation, OnInit} from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import {CORE_DIRECTIVES} from '@angular/common';
import {DROPDOWN_DIRECTIVES} from 'ng2-bootstrap/ng2-bootstrap';

import { LoginService } from '../../pages/login/components/login.service';
import { User } from '../../pages/login/components/user';

@Component({
    moduleId: module.id,
    selector: 'top-nav',
    templateUrl: 'topnav.html',
    encapsulation: ViewEncapsulation.None,
    directives: [DROPDOWN_DIRECTIVES, CORE_DIRECTIVES, ROUTER_DIRECTIVES],
    providers: [LoginService]
})

export class TopNavComponent {
 @Input() user: User;
 currentUser: String;
  constructor(
		private loginService: LoginService
	) {}

ngOnInit(){
    console.log(this.user);
    this.currentUser = localStorage.getItem("user");
  }

  logout(){
    localStorage.removeItem("user");
  }
}
