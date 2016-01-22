'use strict';

(function() {
    
function PatientResource($resource) {
    return $resource('/api/patients/:id',{
        id: null
    },
    {
        update:{
            method:'PUT'
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
        }
    });
}

angular.module('ksiazeczkaZdrowiaApp')
.factory('Patient', PatientResource);

})();
