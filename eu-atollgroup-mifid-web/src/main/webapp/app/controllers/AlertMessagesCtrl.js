/**
 * Created by abator on 4/9/2016.
 */
angular.module('AlertMessagesCtrl', []).controller("AlertMessagesCtrl", function ($scope) {
    // Picks up the event to display a saved message.
    $scope.$on('questionnaireSaved', function () {
        $scope.alerts = [
            { type: 'success', msg: 'Kérdőív sikeresen elmentve!' }
        ];
    });
    
    // Picks up the event to display a deleted message.
    $scope.$on('questionnaireDeleted', function () {
        $scope.alerts = [
            { type: 'success', msg: 'Kérdőív sikeresen törölve!' }
        ];
    });

    // Picks up the event to display a server error message.
    $scope.$on('error', function () {
        $scope.alerts = [
            { type: 'danger', msg: 'Szerver oldali hiba történt!' }
        ];
    });

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };
});