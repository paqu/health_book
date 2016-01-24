'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('doctor', {
        url: '/doctor',
        templateUrl: 'app/doctor/doctor.html',
        controller: 'DoctorCtrl'
      })
      .state('listDoctor', {
        url: '/doctors',
        templateUrl: 'app/doctor/templates/doctors-list.html',
        controller: 'DoctorCtrl'
      })
      .state('newDoctor', {
        url: '/doctors/new',
        templateUrl: 'app/doctors/templates/doctor-new.html',
        controller: 'DoctorNewCtrl',
        //controllerAs:'doctorsNew'
      })
      .state('viewDoctor', {
        url: '/doctors/:id',
        templateUrl: 'app/doctors/templates/doctor-view.html',
        controller: 'DoctorViewCtrl',
        //controllerAs:'doctorsView'
      })
      .state('editDoctor', {
        url: '/doctors/:id/edit',
        templateUrl: 'app/doctors/templates/doctor-edit.html',
        controller: 'DoctorEditCtrl',
        //controllerAs:'doctorsEidt'
      });
  });
