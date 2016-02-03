'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('PatientsCtrl', function ($scope,$state, $stateParams, Patient) {
    $scope.patients = Patient.query();

    $scope.deletePatient = function (patient){
        Patient.remove({id: patient._id});
        $scope.patients.splice($scope.patients.indexOf(patient),1);
    }
  })
  .controller('MyChildrenCtrl', function ($scope,$state,$cookies, $stateParams,User, Patient) {
    var userId = $cookies.get('userId');
    $stateParams.id = userId;
    $scope.patients = Patient.getChildrenList({id: $stateParams.id});

    $scope.deletePatient = function (patient){
        Patient.remove({id: patient._id});
        $scope.patients.splice($scope.patients.indexOf(patient),1);
    }
  })
  .controller('MyPatientsCtrl', function ($scope,$state,$cookies, $stateParams,User, Patient) {
    var userId = $cookies.get('userId');
    $stateParams.id = userId;
    $scope.patients = Patient.getPatientsList({id: $stateParams.id});

    $scope.deletePatient = function (patient){
        Patient.remove({id: patient._id});
        $scope.patients.splice($scope.patients.indexOf(patient),1);
    }
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
  .controller('PatientEditCtrl',function ($scope,$state,$stateParams, Patient) {
    $scope.patient = Patient.get({id: $stateParams.id});

    $scope.editPatient = function (){
        Patient.update({id: $stateParams.id},$scope.patient);
        $state.go('patientsList');
    }
  })
;
