/**
 * Created by abator on 3/16/2016.
 */

mainApp
    .controller("myCtrl", function ($scope) {
        $scope.products = ["Milk", "Bread", "Cheese"];
        $scope.addItem = function () {
            $scope.errortext = "";
            if (!$scope.addMe) {
                return;
            }
            if ($scope.products.indexOf($scope.addMe) == -1) {
                $scope.products.push($scope.addMe);
            } else {
                $scope.errortext = "The item is already in your shopping list.";
            }
            $scope.addMe = "";

        }
        $scope.removeItem = function (x) {
            $scope.errortext = "";
            $scope.products.splice(x, 1);
        }
    })
    .controller('PopoverDemoCtrl', function ($scope) {
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