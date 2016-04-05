/**
 * Created by u95599 on 2016.04.05.
 */

angular.module('mainApp.services',[]).factory('ProductService', function ($resource) {
    return $resource('rest/resources/products', {},{
        query: {method:'GET', isArray:true}
    });
});