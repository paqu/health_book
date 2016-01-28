'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('DoctorCtrl', function ($scope,Doctor) {
    $scope.doctors  = Doctor.query();
  })
;
