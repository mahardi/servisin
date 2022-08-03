'use strict';

angular.module('carForm', ['ui.router'])
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('carNew', {
                parent: 'app',
                url: '/owners/:ownerId/new-car',
                template: '<car-form></car-form>'
            })
            .state('carEdit', {
                parent: 'app',
                url: '/owners/:ownerId/cars/:carId',
                template: '<car-form></car-form>'
            })
    }]);
