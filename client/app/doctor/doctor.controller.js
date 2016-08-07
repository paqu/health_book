'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('DoctorCtrl', function ($scope,Doctor,User) {
    $scope.me = User.get();
    $scope.doctors  = Doctor.query();

    $scope.deleteDoctor = function (doctor){
        Doctor.remove({id: doctor._id});
        $scope.doctors.splice($scope.doctors.indexOf(doctor),1);
    }
  })
  .controller('DoctorEditCtrl',function ($scope, $state, $stateParams, Doctor, Auth, User) {
    $scope.doctor = Doctor.get({id: $stateParams.id});
    $scope.isAdmin = Auth.isAdmin;
    $scope.isDoctor= Auth.isDoctor;
    $scope.me = User.get();

    $scope.editDoctor = function (){
        var firstname = $scope.doctor.firstname;
        var surname = $scope.doctor.surname;
        var email = $scope.doctor.email;
        Doctor.update({id: $stateParams.id},{firstname:firstname,surname:surname,email:email});
        if ($scope.me.role =='admin')
            $state.go('doctorsList');
        else $state.go('doctor');
    }
  })
  .controller('DoctorNewCtrl',function ($scope, $state, Doctor,Auth) {
    $scope.doctor = {};
    $scope.isAdmin = Auth.isAdmin;
    $scope.createUser = Auth.createUser;
    $scope.addButton = true;
    $scope.errors = {};

    $scope.addDoctor = function (){
        $scope.createUser({
            firstname:$scope.doctor.firstname,
            surname:$scope.doctor.surname,
            role:'doctor',
            email:$scope.doctor.email,
            password:'doctor',
            description:$scope.doctor.description
        })
        .then(() => {
            console.log("JESTEM TUTAJ");
            $state.go('doctorsList');
        })
        .catch(err => {
            err = err.data;
            $scope.errors = {};

            // Update validity of form fields that match the mongoose errors
            angular.forEach(err.errors, (error, field) => {
                form[field].$setValidity('mongoose', false);
                $scope.errors[field] = error.message;
            });
        });
    }
  })
;
