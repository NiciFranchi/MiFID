/**
 * Created by u95599 on 2016.03.21.
 */

angular.module('myCtrl', []).controller('myCtrl', function($scope) {
    $scope.products = ["Milk", "Bread", "Cheese"];
    $scope.addItem = function () {
        $scope.errortext = "";
        if (!$scope.addMe) {return;}
        if ($scope.products.indexOf($scope.addMe) == -1) {
            $scope.products.push($scope.addMe);
        } else {
            $scope.errortext = "The item is already in your shopping list.";
        }
    }
    $scope.removeItem = function (x) {
        $scope.errortext = "";
        $scope.products.splice(x, 1);
    }
});