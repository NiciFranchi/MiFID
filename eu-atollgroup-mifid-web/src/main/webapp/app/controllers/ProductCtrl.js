/**
 * Created by u95599 on 2016.04.15.
 */

angular.module('ProductCtrl',[]).controller('ProductCtrl', function ($scope, $rootScope, ProductsService) {
    $scope.isCollapsed = true;

    $scope.product = {
        id: '',
        name: '',
        description: '',
        isQuestionnaireNeeded: ''
    }

    refreshProductSelector();
    
    $scope.addProduct = function () {
        $scope.clearForm();
        $scope.isCollapsed = false;
    }
    
    $scope.selectUpdate = function () {
        if ($scope.prod.selected != '') {
            $scope.isCollapsed = false;

            ProductsService.query(function (allProducts) {
                for (var i = 0; i < allProducts.length; i++) {
                    if (allProducts[i].name == $scope.prod.selected) {
                        $scope.product.id = allProducts[i].id;
                        $scope.product.name = allProducts[i].name;
                        $scope.product.description = allProducts[i].description;
                        $scope.product.isQuestionnaireNeeded = allProducts[i].isQuestionnaireNeeded;
                    }
                }
            });
        }
        console.log($scope.product);
    }

    $scope.refreshContent = function () {
        console.log("refreshContent called");
        refreshProductSelector();
    };

    $scope.$on('refreshContent', function () {
        $scope.refreshContent();
    });

    $scope.clearForm = function () {
        var emptyProduct = {
            id: '',
            name: '',
            description: '',
        }

        $scope.prod.selected = '';
        $scope.product = angular.copy(emptyProduct);
        // Resets the form validation state.
        $scope.productForm.$setPristine();
    };

    $scope.cancelProduct = function () {
        $scope.clearForm();
        $scope.isCollapsed = true;
    }

    $scope.deleteProduct = function () {
        ProductsService.delete({id: $scope.product.id}).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshContent');
                // Broadcast the event to display a save message.
                $rootScope.$broadcast('productDeleted');
                $scope.clearForm();
                $scope.isCollapsed = true;
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    }

    $scope.submitProductForm = function () {
        ProductsService.save($scope.product).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshContent');
                // Broadcast the event to display a save message.
                $rootScope.$broadcast('productSaved');
                $scope.clearForm();
                $scope.isCollapsed = true;
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    };

    function refreshProductSelector(){
        $scope.producteNames = [];
        ProductsService.query(function (allProducts) {
            $scope.producteNames.push("");
            for (var i = 0; i < allProducts.length; i++) {
                $scope.producteNames.push(allProducts[i].name);
            }
        });

        $scope.prod = {
            options: $scope.producteNames,
            selected: ""
        };
    }
    
});