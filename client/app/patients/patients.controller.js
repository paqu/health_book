'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('PatientsCtrl', function ($scope,Patient) {
    $scope.patients = Patient.query();
  })
  .controller('PatientViewCtrl',function ($scope, $state, $stateParams, Patient) {
      console.log("XXXXXXXXXXXXXXXXXXXX");
      console.log($stateParams.id);
      console.log("XXXXXXXXXXXXXXXXXXXX");
    $scope.patient = Patient.get({id: $stateParams.id});

    $scope.deletePatient = function (){
        Patient.remove({id: $stateParams.id});
        $state.go('patients');
    }
  })
  .controller('PatientNewCtrl',function ($scope, $state, Patient) {
    $scope.patient = {};

    $scope.addPatient = function (){
        Patient.create($scope.patient);
        $state.go('patients');
    }
  })
  .controller('PatientEditCtrl',function ($scope, $state,$stateParams, Patient) {
    $scope.patient = Patient.get({id: $stateParams.id});

    $scope.editPatient = function (){
        Patient.update($scope.patient);
        $state.go('patients');
    }
  })
;
