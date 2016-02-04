'use strict';

(function() {
   
function PatientResource($resource) {
    return $resource('/api/patients/:controller/:id',null,
    {
        update:{
            method:'PUT',
        },
        get:{
            method:'GET'
        },
        save:{
            method:'POST'
        },
        query:{
            method:'GET',
            isArray:true
        },
        remove:{
            method:'DELETE'
        },
        getChildrenList:{
            method: 'GET',
            params: {
                controller: 'mychildren',
            },
            isArray:true
        },
        getPatientsList:{
            method: 'GET',
            params: {
                controller: 'mypatients',
            },
            isArray:true
        }

    });
}

angular.module('ksiazeczkaZdrowiaApp')
.factory('Patient', PatientResource);

})();
