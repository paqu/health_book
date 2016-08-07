'use strict';

(function() {

class AdminController {


  constructor(User,Patient) {
    // Use the User $resource to fetch all users
    this.users = User.query();
    this.patients = Patient.query();
  }

  delete(user) {
    user.$remove();
    this.users.splice(this.users.indexOf(user), 1);
  }

}

angular.module('ksiazeczkaZdrowiaApp.admin')
  .controller('AdminController', AdminController);

})();
