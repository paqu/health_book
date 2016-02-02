'use strict';

class NavbarController {
  //start-non-standard
  menu = [{
    'title': 'Home',
    'state': 'main'
  }];

  isCollapsed = true;
  //end-non-standard

  constructor(Auth) {
    this.isLoggedIn = Auth.isLoggedIn;
    this.isAdmin = Auth.isAdmin;
    this.isParent = Auth.isParent;
    this.isDoctor = Auth.isDoctor;
    this.getCurrentUser = Auth.getCurrentUser;
  }
}

angular.module('ksiazeczkaZdrowiaApp')
  .controller('NavbarController', NavbarController);
