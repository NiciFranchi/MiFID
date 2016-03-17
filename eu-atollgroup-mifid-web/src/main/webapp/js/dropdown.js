/**
 * Created by abator on 3/15/2016.
 */
//angular.module('todoApp', []).controller('PopoverDemoCtrl', function ($scope) {
//    $scope.placement = {
//        options: [
//            'top',
//            'top-left',
//            'top-right',
//            'bottom',
//            'bottom-left',
//            'bottom-right',
//            'left',
//            'left-top',
//            'left-bottom',
//            'right',
//            'right-top',
//            'right-bottom'
//        ],
//        selected: 'top'
//    }
//    ;
//});

angular.module('todoApp', []).controller('QuestionnarieCtrl', function ($scope, Questionnaires) {
    $scope.allQuestionnaires = Questionnaires.query();
});
