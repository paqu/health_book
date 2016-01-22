'use strict';

var proxyquire = require('proxyquire').noPreserveCache();

var patientCtrlStub = {
  index: 'patientCtrl.index',
  show: 'patientCtrl.show',
  create: 'patientCtrl.create',
  update: 'patientCtrl.update',
  destroy: 'patientCtrl.destroy'
};

var routerStub = {
  get: sinon.spy(),
  put: sinon.spy(),
  patch: sinon.spy(),
  post: sinon.spy(),
  delete: sinon.spy()
};

// require the index with our stubbed out modules
var patientIndex = proxyquire('./index.js', {
  'express': {
    Router: function() {
      return routerStub;
    }
  },
  './patient.controller': patientCtrlStub
});

describe('Patient API Router:', function() {

  it('should return an express router instance', function() {
    expect(patientIndex).to.equal(routerStub);
  });

  describe('GET /api/patients', function() {

    it('should route to patient.controller.index', function() {
      expect(routerStub.get
        .withArgs('/', 'patientCtrl.index')
        ).to.have.been.calledOnce;
    });

  });

  describe('GET /api/patients/:id', function() {

    it('should route to patient.controller.show', function() {
      expect(routerStub.get
        .withArgs('/:id', 'patientCtrl.show')
        ).to.have.been.calledOnce;
    });

  });

  describe('POST /api/patients', function() {

    it('should route to patient.controller.create', function() {
      expect(routerStub.post
        .withArgs('/', 'patientCtrl.create')
        ).to.have.been.calledOnce;
    });

  });

  describe('PUT /api/patients/:id', function() {

    it('should route to patient.controller.update', function() {
      expect(routerStub.put
        .withArgs('/:id', 'patientCtrl.update')
        ).to.have.been.calledOnce;
    });

  });

  describe('PATCH /api/patients/:id', function() {

    it('should route to patient.controller.update', function() {
      expect(routerStub.patch
        .withArgs('/:id', 'patientCtrl.update')
        ).to.have.been.calledOnce;
    });

  });

  describe('DELETE /api/patients/:id', function() {

    it('should route to patient.controller.destroy', function() {
      expect(routerStub.delete
        .withArgs('/:id', 'patientCtrl.destroy')
        ).to.have.been.calledOnce;
    });

  });

});
