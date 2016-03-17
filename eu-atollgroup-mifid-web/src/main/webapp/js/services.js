/**
 * Created by abator on 3/16/2016.
 */


// Service that provides questionnaires operations
//var app = angular.module('questionnaires', ['ngResource']);
//
//app.factory('questionnaireService', function ($resource) {
//    return $resource('resources/questionnaires/');
//});

var questionnaireService = angular.module("todoApp", ['ngResource']);

questionnaireService.factory('Questionnaires', function($resource){
    return $resource('http://localhost:7001/eu.atollgroup.mifid.web/rest/resources/questionnaires', {},{
        query: {method:'GET', isArray:true}
    });
});