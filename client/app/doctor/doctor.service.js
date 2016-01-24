'use strict';

(function() {
    
function DoctorResource($resource) {
    return $resource('/api/user/:id',{
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
            params: {
                id:'doctors'
            }
        },
        remove:{
            method:'DELETE'
        }
    });
}

angular.module('ksiazeczkaZdrowiaApp')
.factory('Doctor', DoctorResource);

})();
