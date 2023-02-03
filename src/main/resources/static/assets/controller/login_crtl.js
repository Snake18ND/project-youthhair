app = angular.module("login_app", [])
app.controller("login_ctrl", function ($scope, $http) {

    $scope.getAccount = function () {
        $http.get("rest//").then(resp => {
            $scope.bookingSty.push(resp.data);

        })
    }


});