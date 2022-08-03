'use strict';

angular.module('visits', ['ui.router'])
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('visits', {
                parent: 'app',
                url: '/owners/:ownerId/cars/:carId/visits',
                template: '<visits></visits>'
            })
    }]);
