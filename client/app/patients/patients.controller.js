'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('PatientsCtrl', function ($scope,Patient) {
    $scope.patients = Patient.query();
  })
  .controller('PatientViewCtrl',function ($scope, $state, $stateParams, Patient) {
    $scope.patient = Patient.get({id: $stateParams.id});

    $scope.deletePatient = function (){
        Patient.remove({id: $stateParams.id});
        $state.go('patientsList');
    }
  })
  .controller('PatientNewCtrl',function ($scope, $state, Patient) {
    $scope.patient = {};

    $scope.addPatient = function (){
        Patient.create($scope.patient);
        $state.go('patientsList');
    }
  })
  .controller('PatientEditCtrl',function ($scope,$http, $state,$stateParams, Patient) {
    $scope.patient = Patient.get({id: $stateParams.id});

    $scope.editPatient = function (){
        Patient.update({id: $stateParams.id},$scope.patient);
        $state.go('patientsList');
    }
  })
;
