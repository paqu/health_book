/**
 * Populate DB with sample data on server start
 * to disable, edit config/environment/index.js, and set `seedDB: false`
 */

'use strict';
import User from '../api/user/user.model';
import Patient from '../api/patient/patient.model';


User.find({}).removeAsync()
  .then(function() {
    User.createAsync({
      provider: 'local',
      name: 'Test User 1',
      email: 'test1@example.com',
      password: 'test'
    }, {
      provider: 'local',
      name: 'Test User 2',
      email: 'test2@example.com',
      password: 'test'
    }, {
      provider: 'local',
      role: 'admin',
      name: 'Admin',
      email: 'admin@example.com',
      password: 'admin'
    }, {
      provider: 'local',
      role: 'doctor',
      name: 'Doctor 1',
      email: 'doctor1@example.com',
      password: 'doctor'
    }, {
      provider: 'local',
      role: 'doctor',
      name: 'Doctor 2',
      email: 'doctor2@example.com',
      password: 'doctor'
    })
    .then(function() {
      console.log('finished populating users');
    });
  });

Patient.find({}).removeAsync()
  .then(function() {
    Patient.createAsync({
      name: 'Test User 1',
    }, {
      name: 'Test User 2',
    }, {
      provider: 'local',
    }, {
      name: 'Doctor 1',
    }, {
      name: 'Doctor 2',
    })
    .then(function() {
      console.log('finished populating users');
    });
  });
