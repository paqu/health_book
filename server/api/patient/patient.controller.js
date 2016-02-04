/**
 * Using Rails-like standard naming convention for endpoints.
 * GET     /api/patients              ->  index
 * POST    /api/patients              ->  create
 * GET     /api/patients/:id          ->  show
 * PUT     /api/patients/:id          ->  update
 * DELETE  /api/patients/:id          ->  destroy
 */

'use strict';

var _ = require('lodash');
var url = require('url');
var Patient = require('./patient.model');

function handleError(res, statusCode) {
  statusCode = statusCode || 500;
  return function(err) {
    res.status(statusCode).send(err);
  };
}

function responseWithResult(res, statusCode) {
  statusCode = statusCode || 200;
  return function(entity) {
    if (entity) {
      res.status(statusCode).json(entity);
    }
  };
}

function handleEntityNotFound(res) {
  return function(entity) {
    if (!entity) {
      res.status(404).end();
      return null;
    }
    return entity;
  };
}

function saveUpdates(updates) {
  return function(entity) {
    var updated = _.merge(entity, updates);
    return updated.saveAsync()
      .spread(function(updated) {
        return updated;
      });
  };
}

function removeEntity(res) {
  return function(entity) {
    if (entity) {
      return entity.removeAsync()
        .then(function() {
          res.status(204).end();
        });
    }
  };
}

// Gets a list of Patients
exports.index = function(req, res) {
  Patient.findAsync()
    .then(responseWithResult(res))
    .catch(handleError(res));
};

// Gets a list of Patients asigned to User
exports.mychildren = function(req, res) {
  Patient.findAsync({'parentId':req.params.id},
          'childInfo.surname childInfo.firstname childInfo.pesel'
          )
    .then(responseWithResult(res))
    .catch(handleError(res));
};
// Gets a list of Patients asigned to doctor
exports.mypatients = function(req, res) {
  Patient.findAsync({'doctorId':req.params.id},
          'childInfo.surname childInfo.firstname childInfo.pesel'
          )
    .then(responseWithResult(res))
    .catch(handleError(res));
};

// Gets a single Patient from the DB
exports.show = function(req, res) {
  Patient.findByIdAsync(req.params.id)
    .then(handleEntityNotFound(res))
    .then(responseWithResult(res))
    .catch(handleError(res));
};

// Creates a new Patient in the DB
exports.create = function(req, res) {
  Patient.createAsync(req.body)
    .then(responseWithResult(res, 201))
    .catch(handleError(res));
};

// Updates an existing Patient in the DB
exports.update = function(req, res) {
    var userId = req.params.id;
    var visits = req.body.visitsInfo;
    Patient.findByIdAsync(userId)
        .then(function(patient) {
            patient.visitsInfo = visits;
            return patient.saveAsync()
                .then(function() {
                    res.status(204).end();
                })
            return res.status(403).end();
        });
    /*
  if (req.body._id) {
    delete req.body._id;
  }
  Patient.findByIdAsync(req.params.id)
    .then(handleEntityNotFound(res))
    .then(saveUpdates(req.body))
    .then(responseWithResult(res))
    .catch(handleError(res));
    */
};

// Deletes a Patient from the DB
exports.destroy = function(req, res) {
  Patient.findByIdAsync(req.params.id)
    .then(handleEntityNotFound(res))
    .then(removeEntity(res))
    .catch(handleError(res));
};
