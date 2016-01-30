'use strict';

angular.module('ksiazeczkaZdrowiaApp')
  .controller('ParentCtrl', function ($scope,Parent) {
    $scope.parents = Parent.query();
  });
