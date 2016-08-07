'use strict';

var mongoose = require('bluebird').promisifyAll(require('mongoose'));
var Schema = mongoose.Schema;

var PatientSchema = new Schema({
    parentId:String,
    doctorId:String,
    childInfo:{
      surname: String,
      firstname:String,
      dateOfBirth:String,
      placeOfBirth:String,
      address:String,
      pesel:Number,
    },
    familyInfo:{
        motherName:String,
        fatherName:String,
        contactPhone:String
    },
    prenatalInfo:{
        motherAge:Number,
        bloodGroup:String,
        motherRhFactor:String,
        isImmuAntyRhDApplied:Boolean,
        isPreventionDuringPregnancy:Boolean,
        isPreventionAfterChildBirth:Boolean,
        pregnancyNumber:Number,
        isSingle:Boolean,
        isMultiFetal:Boolean,
        caregiver:String,
        date:String
    },
    visitsInfo:[{
        date:String,
        kindOfVisit:String,
        doctorSignature:String
    }],
   birthInfo:{
        bodyWeight:Number,
        bodyLength:Number,
        headCircuit:Number,
        chestCircuit:Number
    }
});

module.exports = mongoose.model('Patient', PatientSchema);
