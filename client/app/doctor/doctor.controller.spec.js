'use strict';

describe('Controller: DoctorCtrl', function () {

  // load the controller's module
  beforeEach(module('ksiazeczkaZdrowiaApp'));

  var DoctorCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DoctorCtrl = $controller('DoctorCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).to.equal(1);
  });
});
