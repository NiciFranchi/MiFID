/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('QuestionnaireCtrl', []).controller("QuestionnaireCtrl", function ($scope, $rootScope, QuestionnairesService, ProductsService) {
    $scope.isCollapsed = true;
    $scope.isAcceptable = false;
    $scope.answerWasSelected = false;
    $scope.showAcceptResult = false;

    $scope.questionnaire = {
        id: '',
        name: '',
        description: '',
        minScoreToAccept: '',
        questions: [],
        product: {}
    }

    $scope.product = {};

    refreshQuestionnaireSelector();
    refreshProductSelector();

    $scope.$watch('questionnaire', function (newQuestionnaire, oldQuestionnaire) {
        $scope.previewSumScore = getSum(newQuestionnaire.questions);


        if ($scope.answerWasSelected == true && $scope.questionnaire.minScoreToAccept != null) {
            $scope.showAcceptResult = true;
        } else {
            $scope.showAcceptResult = false;
        }

        if ($scope.previewSumScore >= $scope.questionnaire.minScoreToAccept) {
            $scope.isAcceptable = true;
        } else {
            $scope.isAcceptable = false;
        }
    }, true);

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

    $scope.selectQuestionnaireUpdate = function () {
        if ($scope.quest.selected != '') {
            $scope.isCollapsed = false;
            $scope.questionnaire.name = $scope.quest.selected;

            QuestionnairesService.query(function (allQuestionnaires) {
                for (var i = 0; i < allQuestionnaires.length; i++) {
                    if (allQuestionnaires[i].name == $scope.questionnaire.name) {
                        $scope.questionnaire = allQuestionnaires[i];
                        $scope.prod.selected = $scope.questionnaire.product.name;
                    }
                }
            });
        }
    }

    $scope.selectProductUpdate = function () {
        $scope.questionnaire.product = {};
        if ($scope.prod.selected != '') {
            ProductsService.query(function (allProducts) {
                for (var i = 0; i < allProducts.length; i++) {
                    if (allProducts[i].name == $scope.prod.selected) {
                        $scope.questionnaire.product = allProducts[i];
                    }
                }
            });
        } else {
            $scope.questionnaire.product = null;
        }
    }

    $scope.refreshContent = function () {
        refreshQuestionnaireSelector();
        refreshProductSelector();
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
        console.log($scope.questionnaire);
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

    function refreshQuestionnaireSelector() {
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
    }


    function getSum(questions) {
        var sum = 0;
        for (var i = 0; i < questions.length; i++) {
            var question = questions[i];
            if (question.selectedAnswer != null) {
                $scope.answerWasSelected = true;
                //Kérdés azonosító levágása a Stringről...
                var selected = question.selectedAnswer.substring(0, question.selectedAnswer.length - 1);
                //Majd a JSON objektummá való parse-olása
                var selectedObj = JSON.parse(selected);
                sum = sum + selectedObj.score;
            }
        }
        return sum;
    }

    function refreshProductSelector() {
        $scope.productNames = [];
        ProductsService.query(function (allProducts) {
            $scope.productNames.push("");
            for (var i = 0; i < allProducts.length; i++) {
                if(allProducts[i].isQuestionnaireNeeded == true){
                    $scope.productNames.push(allProducts[i].name);
                }
            }
        });

        $scope.prod = {
            options: $scope.productNames,
            selected: ""
        };
    }

});
