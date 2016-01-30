'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('DoctorCtrl', function ($scope,Doctor) {
    $scope.doctors  = Doctor.query();

    $scope.deleteDoctor = function (doctor){
        Doctor.remove({id: doctor._id});
        $scope.doctors.splice($scope.doctors.indexOf(doctor),1);
    }
  });
