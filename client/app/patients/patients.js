'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('patientsList', {
        url: '/patients',
        templateUrl: 'app/patients/templates/patients-list.html',
        controller: 'PatientsCtrl'
        //controllerAs:'patients'
      })
      .state('myChildren', {
        url: '/myChildren',
        templateUrl: 'app/patients/templates/parent-children-list.html',
        controller: 'MyChildrenCtrl'
      })
      .state('newPatient', {
        url: '/patients/new',
        templateUrl: 'app/patients/templates/patient-new.html',
        controller: 'PatientNewCtrl',
        //controllerAs:'patientsNew'
      })
      .state('viewPatient', {
        url: '/patients/:id',
        templateUrl: 'app/patients/templates/patient-view.html',
        controller: 'PatientViewCtrl',
        //controllerAs:'patientsView'
      })
      .state('editPatient', {
        url: '/patients/:id/edit',
        templateUrl: 'app/patients/templates/patient-edit.html',
        controller: 'PatientEditCtrl',
        //controllerAs:'patientsEidt'
      });
  });
