'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('PatientsCtrl', function ($scope,Patient) {
    $scope.patients = Patient.query();
  });
