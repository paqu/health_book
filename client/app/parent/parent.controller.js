'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('ParentCtrl', function ($scope,Parent) {
    $scope.parents = Parent.query();

    $scope.deleteParent = function (parent_){
        Parent.remove({id: parent_._id});
        $scope.parents.splice($scope.parents.indexOf(parent_),1);
    }
  })
  .controller('ParentEditCtrl',function ($scope, $state, $stateParams, Parent) {
    $scope.parent_ = Parent.get({id: $stateParams.id});


    $scope.editParent = function (){
        var firstname = $scope.parent_.firstname;
        var surname = $scope.parent_.surname;
        var email = $scope.parent_.email;
        Parent.update({id: $stateParams.id},{firstname:firstname,surname:surname,email:email});
        $state.go('parentsList');
    }
  });
