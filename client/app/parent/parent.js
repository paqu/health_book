'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('parent', {
        url: '/parent',
        templateUrl: 'app/parent/parent.html',
        controller: 'ParentCtrl'
      })
      .state('parentsList', {
          url: '/parents',
          templateUrl: 'app/parent/templates/parents-list.html',
          controller:'ParentCtrl'
      })
      .state('editParent', {
        url: '/parents/:id/edit',
        templateUrl: 'app/parent/templates/parent-edit.html',
        controller: 'ParentEditCtrl'
      });
  });
