/**
 * Created by abator on 3/16/2016.
 */

angular.module('mainApp.services',[]).factory('Questionnaires', function ($resource) {
    return $resource('rest/resources/questionnaires', {},{
        query: {method:'GET', isArray:true}
    });
});