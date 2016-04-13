/**
 * Created by u95599 on 2016.04.12.
 */

angular.module('answerscorevalidator', []).directive('answerscorevalidator', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {

            // ctrl.$validators.isempty = function(modelValue, viewValue) {
            //     if (ctrl.$isEmpty(modelValue)) {
            //         // consider empty models to be valid
            //         return false;
            //     }
            //     return true;
            // };
            var INTEGER_REGEXP = /^\-?\d+$/;
            ctrl.$validators.integer = function(modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue)) {
                    // consider empty models to be valid
                    return true;
                }
                if (INTEGER_REGEXP.test(viewValue)) {
                    // it is valid
                    return true;
                }
                // it is invalid
                return false;
            };

        }
    };
});