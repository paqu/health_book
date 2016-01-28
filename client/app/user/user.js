'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('user', {
        url: '/user',
        templateUrl: 'app/user/user.html',
        controller: 'UserCtrl'
      })
    .state('usersList', {
        url:'/users',
        templateUrl:'app/user/tempaltes/users-list.html'
  });
