'use strict';

class LoginController {
  //start-non-standard
  user = {};
  errors = {};
  submitted = false;
  //end-non-standard

  constructor(Auth, $state,$cookies) {
    this.Auth = Auth;
    this.$state = $state;
    this.$cookies = $cookies;
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
        this.$cookies.put('userId',user._id);
        if ('admin' == user.role)
            this.$state.go('doctorsList');
        else if ('user' == user.role)
            this.$state.go('parent');
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
