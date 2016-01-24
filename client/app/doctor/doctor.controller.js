'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('DoctorCtrl', function ($scope) {
    $scope.message = 'Hello';
  })
  .controller('DoctorViewCtrl',function ($scope, $state, $stateParams, Doctor) {
      console.log($stateParams.id);
    $scope.patient = Doctor.get({id: $stateParams.id});

    $scope.deleteDoctor = function (){
        Doctor.remove({id: $stateParams.id});
        $state.go('doctors');
    }
  })
  .controller('DoctorNewCtrl',function ($scope, $state, Doctor) {
    $scope.patient = {};

    $scope.addDoctor = function (){
        Doctor.create($scope.patient);
        $state.go('doctors');
    }
  })
  .controller('DoctorEditCtrl',function ($scope, $state,$stateParams, Doctor) {
    $scope.patient = Doctor.get({id: $stateParams.id});

    $scope.editDoctor = function (){
        Doctor.update($scope.patient);
        $state.go('doctors');
    }
  })
;
