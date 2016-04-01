/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('QuestionnaireCtrl', []).controller("QuestionnaireCtrl", function ($scope, QuestionnairesService) {
    $scope.questions = [{
        'name': 'Hány éves?',
        'selectedAnswer': '',
        'answers': ['2', '6', '100', '14']
    }];
    
    $scope.addQuestion = function (questionName) {
        console.log($scope.questions);
        
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

    $scope.addAnswer = function (questionIndex) {
        $scope.selectedIndex = questionIndex;

        console.log("this.answerName = ", this.answerName);
        console.log("answerName = ", $scope.answerName);
        console.log("selectedIndex = ", $scope.selectedIndex);

        if ($scope.questions.indexOf($scope.answerName) == -1) {
            $scope.questions[$scope.selectedIndex].answers.push(this.answerName);
        }
        this.answerName='';
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
