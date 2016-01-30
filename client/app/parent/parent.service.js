'use strict';

(function() {
    
function ParentResource($resource) {
    return $resource('/api/users/:id',{
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
            isArray:true,
            params: {
                id:'parents'
            }
        },
        remove:{
            method:'DELETE'
        }
    });
}

angular.module('ksiazeczkaZdrowiaApp')
.factory('Parent', ParentResource);

})();
