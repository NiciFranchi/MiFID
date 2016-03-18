/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('QuestionnaireCtrl',[]).controller("QuestionnaireCtrl", function($scope, QuestionnairesService){
    var questionnaireNames = [];

    $scope.allQuestionnaires = QuestionnairesService.query(function () {
        for(var i = 0; i < $scope.allQuestionnaires.length; i++) {
            questionnaireNames.push($scope.allQuestionnaires[i].name);
        }
    });
    
    $scope.placement = {
        options: questionnaireNames,
        selected: questionnaireNames[0]
    };
});
