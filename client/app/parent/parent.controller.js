'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('ParentCtrl', function ($scope,Parent) {
    $scope.parents = Parent.query();

    $scope.deleteParent = function (_parent){
        Parent.remove({id: _parent._id});
        $scope.parents.splice($scope.parents.indexOf(_parent),1);
    }
  });
