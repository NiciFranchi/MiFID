/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('QuestionnaireCtrl', []).controller("QuestionnaireCtrl", function ($scope, QuestionnairesService) {
    $scope.isCollapsed = true;

    $scope.questionnaire = {
        id: '',
        name: '',
        description: '',
        questions: [{
            name: 'Hány éves?',
            description: '',
            answers: [
                {name: '1111'},
                {name: '2222'}
            ]
        }]
    }

    
    
    $scope.addQuestion = function (questionName) {
        console.log($scope.questionnaire);
        console.log($scope.preview);

        if (!questionName) {
            return;
        }
        if ($scope.questionnaire.questions.length == 0) {
            $scope.questionnaire.questions = [{
                id: '',
                name: questionName,
                description:'',
                answers: []
            }]
        }
        else if ($scope.questionnaire.questions.indexOf(questionName) == -1) {
            $scope.questionnaire.questions.push({
                id: '',
                name: questionName,
                description:'',
                answers: []
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

    $scope.valami = $scope.questionnaire;

    $scope.selectUpdate = function () {
        if ($scope.quest.selected != '') {
            $scope.isCollapsed = false;
            $scope.questionnaire.name = $scope.quest.selected;

            $scope.allQuestionnaires = QuestionnairesService.query(function () {
                for (var i = 0; i < $scope.allQuestionnaires.length; i++) {
                    if($scope.allQuestionnaires[i].name == $scope.questionnaire.name){
                        $scope.valami = QuestionnairesService.get({id: $scope.allQuestionnaires[i].id});
                    }
                }
            });

            $scope.quest.selected = '';
            $scope.$apply();
        }
    }

    $scope.submitQuestionnaireForm = function () {
        QuestionnairesService.save($scope.questionnaire);
    };


});
