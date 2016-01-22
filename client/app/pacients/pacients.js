'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('pacients', {
        url: '/pacients',
        templateUrl: 'app/pacients/pacients.html',
        controller: 'PacientsCtrl'
      });
  });
