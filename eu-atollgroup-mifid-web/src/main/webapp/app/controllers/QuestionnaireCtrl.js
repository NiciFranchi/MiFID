/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('QuestionnaireCtrl', []).controller("QuestionnaireCtrl", function ($scope, $rootScope, QuestionnairesService) {
    $scope.isCollapsed = true;

    $scope.allQuestionnaires = QuestionnairesService.query(function () {
    });
    $scope.questionnaire = {
        id: '',
        name: '',
        description: '',
        minScoreToAccept: '',
        questions: []
    }

    $scope.questionnaireNames = [];
    QuestionnairesService.query(function (allQuestionnaires) {
        $scope.questionnaireNames.push("");
        for (var i = 0; i < allQuestionnaires.length; i++) {
            $scope.questionnaireNames.push(allQuestionnaires[i].name);
        }
    });

    $scope.quest = {
        options: $scope.questionnaireNames,
        selected: ""
    };

    function getSum(questions) {
        console.log(questions);
        var sum=0;
        console.log($scope.questionnaire);
        for(var i=0; i<questions.length; i++){
            var question = questions[i];
            console.log(question);
            if(question.selectedAnswer != null){
                sum = sum + question.selectedAnswer.score;
            }
        }
        return sum;
    }

    $scope.previewSumScore; //= getSum($scope.questionnaire.questions);

    $scope.$watch('questionnaire.questions', function(newQuestions, oldQuestions) {
        console.log("watcher called");
        $scope.previewSumScore = getSum(newQuestions);
    }, true);

    // var questions = $scope.questionnaire.questions;
    // for (var i = 0; i < questions.length; i++) {
    //     if (questions.selectedAnswer != null) {
    //         console.log(questions[questions.selectedAnswer]);
    //         $scope.previewSumScore = $scope.previewSumScore + questions[questions.selectedAnswer].score;
    //     }
    // }

    $scope.addQuestionnaire = function () {
        $scope.clearForm();
        $scope.isCollapsed = false;
    }

    $scope.addQuestion = function (questionName) {
        if (!questionName) {
            return;
        }
        if ($scope.questionnaire.questions.length == 0) {
            $scope.questionnaire.questions = [{
                name: questionName,
                description: '',
                answers: []
            }]
        }
        else if ($scope.questionnaire.questions.indexOf(questionName) == -1) {
            $scope.questionnaire.questions.push({
                name: questionName,
                description: '',
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
            $scope.questionnaire.questions[$scope.selectedIndex].answers.push(
                {
                    name: this.answerName,
                    score: this.answerScore
                });
        }
        this.answerName = '';
        this.answerScore = '';
    }

    $scope.removeAnswer = function (questionIndex, answerIndex) {
        $scope.selectedAnswerIndex = answerIndex;
        $scope.selectedQuestionIndex = questionIndex;
        $scope.questionnaire.questions[$scope.selectedQuestionIndex].answers.splice(answerIndex, 1);
    }

    $scope.selectUpdate = function () {
        if ($scope.quest.selected != '') {
            $scope.isCollapsed = false;
            $scope.questionnaire.name = $scope.quest.selected;

            QuestionnairesService.query(function (allQuestionnaires) {
                for (var i = 0; i < allQuestionnaires.length; i++) {
                    if (allQuestionnaires[i].name == $scope.questionnaire.name) {
                        $scope.questionnaire.id = allQuestionnaires[i].id;
                        $scope.questionnaire.name = allQuestionnaires[i].name;
                        $scope.questionnaire.description = allQuestionnaires[i].description;
                        $scope.questionnaire.minScoreToAccept = allQuestionnaires[i].minScoreToAccept;
                        $scope.questionnaire.questions = allQuestionnaires[i].questions;
                    }
                }
            });
        }
    }

    $scope.refreshContent = function () {
        QuestionnairesService.query(function (data) {
            $scope.allQuestionnaires = data;

            $scope.questionnaireNames = [];
            $scope.questionnaireNames.push("");
            for (var i = 0; i < $scope.allQuestionnaires.length; i++) {
                $scope.questionnaireNames.push($scope.allQuestionnaires[i].name);
            }
            $scope.quest = {
                options: $scope.questionnaireNames,
                selected: ""
            };
        });
    };

    $scope.$on('refreshContent', function () {
        $scope.refreshContent();
    });

    $scope.clearForm = function () {
        var emptyQuestionnaire = {
            id: '',
            name: '',
            description: '',
            minScoreToAccept: '',
            questions: []
        }

        $scope.quest.selected = '';
        $scope.questionnaire = angular.copy(emptyQuestionnaire);
        // Resets the form validation state.
        $scope.questionnaireForm.$setPristine();
    };

    $scope.cancelQuestionnaire = function () {
        $scope.clearForm();
        $scope.isCollapsed = true;
    }

    $scope.deleteQuestionnaire = function () {
        QuestionnairesService.delete({id: $scope.questionnaire.id}).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshContent');
                // Broadcast the event to display a save message.
                $rootScope.$broadcast('questionnaireDeleted');
                $scope.clearForm();
                $scope.isCollapsed = true;
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    }

    $scope.submitQuestionnaireForm = function () {
        QuestionnairesService.save($scope.questionnaire).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshContent');
                // Broadcast the event to display a save message.
                $rootScope.$broadcast('questionnaireSaved');
                $scope.clearForm();
                $scope.isCollapsed = true;
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    };
});
