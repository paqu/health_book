'use strict';

(function() {
   
function PatientResource($resource) {
    return $resource('/api/patients/:controller/:userId',{
        userId:'@_id'
    },
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
                controller: 'mychildren_',
            },
            isArray:true
        }
    });
}

angular.module('ksiazeczkaZdrowiaApp')
.factory('Patient', PatientResource);

})();
