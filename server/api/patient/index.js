'use strict';

var express = require('express');
var controller = require('./patient.controller');

var router = express.Router();

router.get('/', controller.index);
router.get('/:id', controller.show);
router.get('/mypatients/:id',controller.mypatients);
router.get('/mychildren/:id',controller.mychildren);
router.post('/', controller.create);
router.put('/:id', controller.update);
router.patch('/:id', controller.update);
router.delete('/:id', controller.destroy);

module.exports = router;
