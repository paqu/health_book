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
        childInfo : {
            surname: 'Julian',
            firstname:'Nowak',
            dateOfBirth:{
                day:1,
                mounth:12,
                year:1993
            },
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:111111111111
        }
    }, {
        childInfo : {
            surname: 'Marek',
            firstname:'Nowak',
            dateOfBirth:{
                day:1,
                mounth:12,
                year:1993
            },
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:611111111111
        }
    }, {
        childInfo : {
            surname: 'Kasia',
            firstname:'Perka',
            dateOfBirth:{
                day:1,
                mounth:12,
                year:1993
            },
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:511111111111
        }
    }, {
        childInfo : {
            surname: 'Anna',
            firstname:'Lukasik',
            dateOfBirth:{
                day:1,
                mounth:12,
                year:1993
            },
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:411111111111
        }
    }, {
        childInfo : {
            surname: 'Robert',
            firstname:'Sobota',
            dateOfBirth:{
                day:1,
                mounth:12,
                year:1993
            },
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:311111111111
        }
    }, {
        childInfo : {
            surname: 'Wiktorai',
            firstname:'Wojcik',
            dateOfBirth:{
                day:1,
                mounth:12,
                year:1993
            },
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:211111111111
        }
    })
    .then(function() {
      console.log('finished populating users');
    });
  });
