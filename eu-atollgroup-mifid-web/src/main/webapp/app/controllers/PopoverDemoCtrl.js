/**
 * Created by u95599 on 2016.03.18.
 */

angular.module('PopoverDemoCtrl',[]).controller('PopoverDemoCtrl', function ($scope) {
    $scope.placement = {
        options: [
            'top',
            'top-left',
            'top-right',
            'bottom',
            'bottom-left',
            'bottom-right',
            'left',
            'left-top',
            'left-bottom',
            'right',
            'right-top',
            'right-bottom'
        ],
        selected: 'top'
    };
});