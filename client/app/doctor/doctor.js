'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('doctor', {
        url: '/doctor',
        templateUrl: 'app/doctor/doctor.html',
        controller: 'DoctorCtrl'
      })
      .state('doctorsList', {
        url: '/doctors',
        templateUrl: 'app/doctor/templates/doctors-list.html',
        controller: 'DoctorCtrl'
      })
      .state('newDoctor', {
        url: '/doctors/new',
        templateUrl: 'app/doctor/templates/doctor-new.html',
        controller: 'DoctorNewCtrl'
        //controllerAs:'doctorsNew'
      })
      .state('viewDoctor', {
        url: '/doctors/:id',
        templateUrl: 'app/doctor/templates/doctor-view.html',
        controller: 'DoctorViewCtrl'
        //controllerAs:'doctorsView'
      })
      .state('editDoctor', {
        url: '/doctors/:id/edit',
        templateUrl: 'app/doctor/templates/doctor-edit.html',
        controller: 'DoctorEditCtrl'
        //controllerAs:'doctorsEidt'
      });
  });
