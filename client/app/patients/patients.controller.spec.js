'use strict';

describe('Controller: PatientsCtrl', function () {

  // load the controller's module
  beforeEach(module('ksiazeczkaZdrowiaApp'));

  var PatientsCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PatientsCtrl = $controller('PatientsCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).to.equal(1);
  });
});
