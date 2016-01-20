'use strict';

(function() {

class AdminController {

  menu = [
      {
          'title':'title1'
      },
      {
          'title':'title2'
      }];

  constructor(User) {
    // Use the User $resource to fetch all users
    this.users = User.query();
  }

  delete(user) {
    user.$remove();
    this.users.splice(this.users.indexOf(user), 1);
  }
}

angular.module('ksiazeczkaZdrowiaApp.admin')
  .controller('AdminController', AdminController);

})();
