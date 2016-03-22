/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('QuestionnaireCtrl', []).controller("QuestionnaireCtrl", function ($scope, QuestionnairesService) {
    //$scope.name = $scope.questionnaireName;
    //$scope.description = $scope.questionnaireDescription;
    console.log($scope.name);
    //console.log($scope.questionnaire.name);
    //console.log($scope.questionnaireForm.name);
    //console.log($scope.questionnaireForm.questionnaire.name);


    $scope.questions = [{
        'name': 'Hány éves?',
        'selectedAnswer': '',
        'answers': ['2', '6', '100']
    }];
    
    $scope.addQuestion = function (questionName) {
        if (!questionName) {
            return;
        }
        if ($scope.questions.length == 0) {
            $scope.questions = [{
                'name': questionName,
                'selectedAnswer': '',
                'answers': []
            }]
        }
        else if ($scope.questions.indexOf(questionName) == -1) {
            $scope.questions.push({
                'name': questionName,
                'selectedAnswer': '',
                'answers': []
            });
        }
        $scope.questionName='';

    }

    $scope.removeQuestion = function (questionIndex) {
        $scope.selectedQuestionIndex = questionIndex;
        $scope.questions.splice(questionIndex, 1);
    }

    $scope.addAnswer = function (answerName, questionIndex) {
        $scope.selectedIndex = questionIndex;

        if (!answerName) {
            return;
        }
        if ($scope.questions.indexOf($scope.answerName) == -1) {
            $scope.questions[$scope.selectedIndex].answers.push(answerName);
        }

    }

    $scope.removeAnswer = function (questionIndex, answerIndex) {
        $scope.selectedAnswerIndex = answerIndex;
        $scope.selectedQuestionIndex = questionIndex;
        $scope.questions[$scope.selectedQuestionIndex].answers.splice(answerIndex, 1);
    }


    var questionnaireNames = [];
    $scope.isCollapsed = true;

    $scope.allQuestionnaires = QuestionnairesService.query(function () {
        for (var i = 0; i < $scope.allQuestionnaires.length; i++) {
            questionnaireNames.push($scope.allQuestionnaires[i].name);
        }
    });

    $scope.placement = {
        options: questionnaireNames,
        selected: questionnaireNames[0]
    };
});
