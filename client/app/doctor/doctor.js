'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('doctor', {
        url: '/doctor',
        templateUrl: 'app/doctor/doctor.html',
        controller: 'DoctorCtrl'
      });
  });
