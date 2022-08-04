'use strict';

angular.module('carForm')
    .controller('PetFormController', ['$http', '$state', '$stateParams', function ($http, $state, $stateParams) {
        var self = this;
        var ownerId = $stateParams.ownerId || 0;

        $http.get('api/customer/carTypes').then(function (resp) {
            self.types = resp.data;
        }).then(function () {

            var carId = $stateParams.carId || 0;

            if (carId) { // edit
                $http.get("api/customer/owners/" + ownerId + "/cars/" + carId).then(function (resp) {
                    self.car = resp.data;
                    self.car.dateOfPurchase = new Date(self.car.dateOfPurchase);
                    self.carTypeId = "" + self.car.type.id;
                });
            } else {
                $http.get('api/customer/owners/' + ownerId).then(function (resp) {
                    self.car = {
                        owner: resp.data.firstName + " " + resp.data.lastName
                    };
                    self.carTypeId = "1";
                })

            }
        });

        self.submit = function () {
            var id = self.car.id || 0;

            var data = {
                id: id,
                name: self.car.name,
                dateOfPurchase: self.car.dateOfPurchase,
                typeId: self.carTypeId
            };

            var req;
            if (id) {
                req = $http.put("api/customer/owners/" + ownerId + "/cars/" + id, data);
            } else {
                req = $http.post("api/customer/owners/" + ownerId + "/cars", data);
            }

            req.then(function () {
                $state.go('ownerDetails', {ownerId: ownerId});
            });
        };
    }]);
