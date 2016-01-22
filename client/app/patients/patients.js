'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('patients', {
        url: '/patients',
        templateUrl: 'app/patients/patients.html',
        controller: 'PatientsCtrl'
      });
  });
