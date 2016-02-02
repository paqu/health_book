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
      _id:'a1b2c3d4e5f6a1b2c3d4e5f6',
      provider: 'local',
      firstname:'Julian',
      surname: 'Test User 1',
      email: 'test1@example.com',
      password: 'test'
    }, {
      _id:'b1b2c3d4e5f6a1b2c3d4e5f6',
      provider: 'local',
      firstname:'Julian',
      surname: 'Test User 2',
      email: 'test2@example.com',
      password: 'test'
    },{
      _id:'01b2c3d4e5f6a1b2c3d4e5f6',
      provider: 'local',
      firstname:'Andrzej',
      surname: 'Test User 3',
      email: 'test3@example.com',
      password: 'test'
    }, {
      _id:'c1b2c3d4e5f6a1b2c3d4e5f6',
      provider: 'local',
      role: 'admin',
      surname: 'Admin',
      email: 'admin@example.com',
      password: 'admin'
    }, {
      _id:'d1b2c3d4e5f6a1b2c3d4e5f6',
      provider: 'local',
      description:"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      role: 'doctor',
      firstname:'Julian',
      surname: 'Doctor 1',
      email: 'doctor1@example.com',
      password: 'doctor'
    }, {
      _id:'e1b2c3d4e5f6a1b2c3d4e5f6',
      provider: 'local',
      description:"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
      role: 'doctor',
      firstname:'Julian',
      surname: 'Doctor 2',
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
        _id:'aaaaaaaaaaaaaaaaaaaaaaaa',
        parentId:'a1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'d1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Nowak',
            firstname:'Julian',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:111111111111
        },
        familyInfo:{
            motherName:'Maria',
            fatherName:'Janusz',
            contactPhone:'xxx-xxx-xxx'
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    }, {
        _id:'aaaaaaaaaaaaaaaaaaaaaaa1',
        parentId:'a1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'e1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Nowak',
            firstname:'Marek',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:611111111111
        },
        familyInfo:{
            motherName:'Maria',
            fatherName:'Janusz',
            contactPhone:'xxx-xxx-xxx'
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    },{
        _id:'aaaaaaaaaaaaaaaaaaaaaa11',
        parentId:'a1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'d1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Nowak',
            firstname:'Marek',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:611111111111
        },
        familyInfo:{
            motherName:'Maria',
            fatherName:'Janusz',
            contactPhone:'xxx-xxx-xxx'
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    },{
        _id:'aaaaaaaaaaaaaaaaaaaaaa21',
        parentId:'a1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'e1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Nowak',
            firstname:'Marek',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:611111111111
        },
        familyInfo:{
            motherName:'Maria',
            fatherName:'Janusz',
            contactPhone:'xxx-xxx-xxx'
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    },{
        _id:'aaaaaaaaaaaaaaaaaaaaaa31',
        parentId:'a1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'d1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Nowak',
            firstname:'Marek',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:611111111111
        },
        familyInfo:{
            motherName:'Maria',
            fatherName:'Janusz',
            contactPhone:'xxx-xxx-xxx'
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    }, {
        _id:'aaaaaaaaaaaaaaaaaaaaaaa2',
        parentId:'b1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'e1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Perka',
            firstname:'Katarzyna',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:511111111111
        },
        familyInfo:{
            motherName:'Maria',
            fatherName:'Janusz',
            contactPhone:'xxx-xxx-xxx'
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    }, {
        _id:'aaaaaaaaaaaaaaaaaaaaaaa3',
        parentId:'b1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'d1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Lukasik',
            firstname:'Wiktoria',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:411111111111
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    }, {
        _id:'aaaaaaaaaaaaaaaaaaaaaaa4',
        parentId:'b1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'e1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Sobota',
            firstname:'Robert',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:311111111111
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    }, {
        _id:'aaaaaaaaaaaaaaaaaaaaaaa5',
        parentId:'a1b2c3d4e5f6a1b2c3d4e5f6',
        doctorId:'d1b2c3d4e5f6a1b2c3d4e5f6',
        childInfo : {
            surname: 'Wojcik',
            firstname:'Wojciech',
            dateOfBirth:'1993/10/20',
            placeOfBirth:'Gniezno',
            address:'os. xxx 45/3, 62-200 Gniezno',
            pesel:211111111111
        },
        prenatalInfo:{
            motherAge:27,
            bloodGroup:'B',
            motherRhFactor:'X',
            isImmuAntyRhDApplied:true,
            isPreventionDurringPregnacy:true,
            isPreventionAfterChildBirth:true,
            pregnancyNumber:3,
            isSingle:true,
            isMultiFetal:false,
            caregiver:'Piotr Szpilkowski',
            date:'27/01/2017'
        },
        visitsInfo:[{
            date:"2013/01/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/04/21",
            kindOfVisit:"XXXX",
            doctorSignature:"Szpilman"
        },{
            date:"2013/05/21",
            kindOfVisit:"YYYY",
            doctorSignature:"Szpilman"
        },{
            date:"2014/01/21",
            kindOfVisit:"ZZZ",
            doctorSignature:"Szpilman"
        }],
        birthInfo:{
            bodyWeight:2000,
            bodyLength:40,
            headCircuit:30,
            chestCircuit:45
        }
    })
    .then(function() {
      console.log('finished populating patients');
    });
  });
