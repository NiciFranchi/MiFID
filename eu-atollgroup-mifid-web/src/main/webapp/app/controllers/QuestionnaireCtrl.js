/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('QuestionnaireCtrl', []).controller("QuestionnaireCtrl", function ($scope, QuestionnairesService) {
    $scope.isCollapsed = true;

    $scope.questionnaire = {
        name: '',
        description: '',
        product: '',
        questions: [{
            name: 'Hány éves?',
            selectedAnswer: '',
            answers: [
                {name: '1111'},
                {name: '2222'}
            ]
        }]
    }


    $scope.addQuestion = function (questionName) {
        if (!questionName) {
            return;
        }
        console.log($scope.questionnaire);
        console.log($scope.questionnaire.questions);
        if ($scope.questionnaire.questions.length == 0) {
            $scope.questionnaire.questions = [{
                'name': questionName,
                'selectedAnswer': '',
                'answers': []
            }]
        }
        else if ($scope.questionnaire.questions.indexOf(questionName) == -1) {
            $scope.questionnaire.questions.push({
                'name': questionName,
                'selectedAnswer': '',
                'answers': []
            });
        }
        $scope.questionName = '';
    }

    $scope.removeQuestion = function (questionIndex) {
        $scope.selectedQuestionIndex = questionIndex;
        $scope.questionnaire.questions.splice(questionIndex, 1);
    }

    $scope.addAnswer = function (questionIndex) {
        $scope.selectedIndex = questionIndex;

        if ($scope.questionnaire.questions.indexOf($scope.answerName) == -1) {
            $scope.questionnaire.questions[$scope.selectedIndex].answers.push({'name': this.answerName});
        }
        this.answerName = '';
    }

    $scope.removeAnswer = function (questionIndex, answerIndex) {
        $scope.selectedAnswerIndex = answerIndex;
        $scope.selectedQuestionIndex = questionIndex;
        $scope.questionnaire.questions[$scope.selectedQuestionIndex].answers.splice(answerIndex, 1);
    }

    var questionnaireNames = [];
    $scope.allQuestionnaires = QuestionnairesService.query(function () {
        questionnaireNames.push("");
        for (var i = 0; i < $scope.allQuestionnaires.length; i++) {
            questionnaireNames.push($scope.allQuestionnaires[i].name);
        }
    });

    $scope.quest = {
        options: questionnaireNames,
        selected: ""
    };

    $scope.selectUpdate = function () {
        if ($scope.quest.selected != '') {
            $scope.isCollapsed = false;
            $scope.questionnaire.name = $scope.quest.selected;

            $scope.quest.selected = '';
        }
    }

});
