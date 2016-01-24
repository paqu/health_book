'use strict';

class LoginController {
  //start-non-standard
  user = {};
  errors = {};
  submitted = false;
  //end-non-standard

  constructor(Auth, $state) {
    this.Auth = Auth;
    this.$state = $state;
  }

  login(form) {
    this.submitted = true;

    if (form.$valid) {
      this.Auth.login({
        email: this.user.email,
        password: this.user.password
      })
      .then((user) => {
        // Logged in, redirect to home
        console.log(user);
        if ('admin' == user.role)
            this.$state.go('admin');
        else if ('user' == user.role)
            this.$state.go('user');
        else
            this.$state.go('doctor');
      })
      .catch(err => {
        this.errors.other = err.message;
      });
    }
  }
}

angular.module('ksiazeczkaZdrowiaApp')
  .controller('LoginController', LoginController);
