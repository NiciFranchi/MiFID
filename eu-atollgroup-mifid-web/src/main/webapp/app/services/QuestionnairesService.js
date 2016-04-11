/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('mainApp.services',[]).factory('QuestionnairesService', function ($resource) {
    return $resource('rest/resources/questionnaires/:id');
});