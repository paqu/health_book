'use strict';

var mongoose = require('bluebird').promisifyAll(require('mongoose'));
var Schema = mongoose.Schema;

var PatientSchema = new Schema({
    childInfo:{
      surname: String,
      firstname:String,
      dateOfBirth: {
          day:Number,
          month:Number,
          year:Number,
      },
      placeOfBirth:String,
      address:String,
      pesel:Number,
    }
});

module.exports = mongoose.model('Patient', PatientSchema);
