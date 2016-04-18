/**
 * Created by u95599 on 2016.04.05.
 */

angular.module('ProductsService',[]).factory('ProductsService', function ($resource) {
    return $resource('rest/resources/products/:id');
});