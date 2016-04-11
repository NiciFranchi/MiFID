/**
 * Created by abator on 4/9/2016.
 */

angular.module('questionnairenamevalidator', []).directive('questionnairenamevalidator', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {

            ctrl.$validators.duplicate = function(modelValue, viewValue) {
                var names = angular.copy(scope.questionnaireNames);
                //ha ki van választva egy elem, elfogadott annak a kérdőív névnek a validálása
                if(scope.quest.selected != ''){
                    names.splice(names.indexOf(scope.quest.selected),1);

                }
                if (ctrl.$isEmpty(modelValue)) {
                    // consider empty models to be valid
                    return true;
                }
                for (var i=0; i<names.length; i++ ){
                    if(viewValue ==  names[i]){
                        return false;
                    }
                }
                return true;
            };
            ctrl.$validators.isempty = function(modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue)) {
                    // consider empty models to be valid
                    return false;
                } else {
                    return true;
                }

            };

        }
    };
});