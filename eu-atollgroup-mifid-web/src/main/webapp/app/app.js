/**
 * Created by abator on 3/16/2016.
 */

var mainApp = angular.module("mainApp", [
    'ngResource'
    ,'ngAnimate'
    ,'ngRoute'
    ,'ui.bootstrap'
    ,'QuestionnairesService'
    ,'ProductsService'
    ,'AlertMessagesCtrl'
    ,'QuestionnaireCtrl'
    ,'PopoverDemoCtrl'
    ,'ProductCtrl'
    ,'questionnairenamevalidator'
    ,'answerscorevalidator'
    ]);

mainApp.config(function($routeProvider) {
    $routeProvider

        .when("/questionnaires", {
            templateUrl: 'views/questionnaires.html',
            controller: 'QuestionnaireCtrl'
        })

        .when("/products", {
            templateUrl: 'views/products.html',
            controller: 'ProductCtrl'
        })
        
        .otherwise({
        redirectTo: '/questionnaires'
    });
});