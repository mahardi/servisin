'use strict';

angular.module('workshopList')
    .controller('workshopListController', ['$http', function ($http) {
        var self = this;

        $http.get('api/workshop/workshops').then(function (resp) {
            self.workshopList = resp.data;
        });
    }]);
