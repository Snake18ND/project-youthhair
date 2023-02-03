app = angular.module("contact_app", [])
app.controller("contact_ctrl", function ($scope, $http) {

	$scope.form = {};

	$scope.saveContact = function() {
		var contacts = angular.copy($scope.form);
		contacts.createDate = new Date();
		contacts.status = false;
		if($scope.form.fullName == null
		|| $scope.form.email == null
		|| $scope.form.phone == null
		){
			alert("Vui lòng nhập thông tin đầy đủ");
		}else{
			$http.post("/rest/contact", contacts).then(resp => {
	            alert("Bạn đã gửi thông tin thành công! Chúng tôi sẽ liên hệ lại với bạn trong vòng 24 giờ tới!" + $scope.form.phone);				           
	            location.href = "/";
	        }).catch(error => {
	            alert("Gửi liên hệ thất bại!")
	            // $scope.form.data = null;
	            console.log(error);
	        })
		}
		
	}

});