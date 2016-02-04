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
  .controller('PatientViewCtrl',function ($scope, $state, $stateParams, Patient, Auth) {
    $scope.isAdmin = Auth.isAdmin;
    $scope.isDocotr= Auth.isDoctor;
    $scope.isParent= Auth.isParent;
    $scope.patient = Patient.get({id: $stateParams.id});

    $scope.deletePatient = function (){
        Patient.remove({id: $stateParams.id});
        $state.go('patientsList');
    }
  })
  .controller('PatientNewCtrl',function ($scope, $state, Patient,User,Doctor) {
    $scope.patient = {
        parentId:'',
        doctorId:'',
        childInfo:{
            surname:'',
            firstname:'',
            dateOfBirth:'',
            placeOfBirth:'',
            address:'',
            pesel:0
        },
        familyInfo:{
            motherName:'',
            fatherName:'',
            contactPhone:''
        }
    };

    $scope.me = User.get();
    $scope.doctors = Doctor.query();
    $scope.select = function(doctor) {
        $scope.patient.doctorId = doctor._id;
    };

    $scope.addPatient = function (){
        $scope.patient.parentId = $scope.me._id;
        if ($scope.patient.childInfo.firstname == ''
                || $scope.patient.childInfo.surname == ''
                || $scope.patient.childInfo.dateOfBirth == ''
                || $scope.patient.childInfo.placeOfBirth == ''
                || $scope.patient.childInfo.address == ''
                || $scope.patient.childInfo.pesel == 0
                || $scope.patient.familyInfo.motherName == ''
                || $scope.patient.familyInfo.faterName == ''
                || $scope.patient.familyInfo.contactPhone == ''
                || $scope.patient.parentId == ''
                || $scope.patient.doctorId == ''
                ){
            alert("Prosze uzupelnic wszystkie pola w formularzu i wybrac lekarza");
        }
        else {
            Patient.save($scope.patient);
            $state.go('myChildren');
        }
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
