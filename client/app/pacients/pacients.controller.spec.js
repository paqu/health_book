'use strict';

describe('Controller: PacientsCtrl', function () {

  // load the controller's module
  beforeEach(module('ksiazeczkaZdrowiaApp'));

  var PacientsCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PacientsCtrl = $controller('PacientsCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).to.equal(1);
  });
});
