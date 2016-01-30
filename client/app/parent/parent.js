'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('parent', {
        url: '/parent',
        templateUrl: 'app/parent/parent.html',
        controller: 'ParentCtrl'
      });
  });
