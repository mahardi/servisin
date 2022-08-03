'use strict';

angular.module('workshopList', ['ui.router'])
    .config(['$stateProvider', function ($stateProvider) {
        $stateProvider
            .state('workshops', {
                parent: 'app',
                url: '/workshops',
                template: '<workshop-list></workshop-list>'
            })
    }]);