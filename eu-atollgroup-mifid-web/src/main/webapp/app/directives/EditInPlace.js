/**
 * Created by u95599 on 2016.03.25.
 */

angular.module('editInPlace', []).directive('editInPlace', function() {
    return {
        restrict: 'E',
        scope: { value: '=' },
        template: '<span ng-click="edit()" ng-bind="value"></span><input ng-model="value"></input>',
        link: function ( $scope, element, attrs ) {
            // Let's get a reference to the input element, as we'll want to reference it.
            var inputElement = angular.element( element.children()[1] );

            // This directive should have a set class so we can style it.
            element.addClass( 'edit-in-place' );

            // Initially, we're not editing.
            $scope.editing = false;
            console.log(element.html());

            // ng-click handler to activate edit-in-place
            $scope.edit = function () {
                console.log(this.value);
                $scope.editing = true;

                // We control display through a class on the directive itself. See the CSS.
                element.addClass( 'active' );


                // And we must focus the element.
                // `angular.element()` provides a chainable array, like jQuery so to access a native DOM function,
                // we have to reference the first element in the array.
                inputElement[0].focus();
            };

            // When we leave the input, we're done editing.
            inputElement.prop( 'onblur', function() {
                //console.log(this.value);
                $scope.editing = false;
                element.removeClass( 'active' );
                
                if($scope.$parent.answer != null){
                    console.log("előtte");
                    console.log($scope.$parent.$parent.question.answers[$scope.$parent.index]);
                    console.log(this.value);
                    $scope.$parent.$parent.question.answers[$scope.$parent.$index]=this.value;
                    console.log("utána");
                    console.log($scope.$parent.$parent.question.answers[$scope.$parent.index]);
                }
            });
        }
    };
});