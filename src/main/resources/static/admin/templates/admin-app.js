const app = angular.module("admin_app", ["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/", {
		templateUrl:"/admin/templates/dashboard.html",
		controller:"booking-ctrl"
	})
	.when("/booking", {
		templateUrl:"/admin/templates/booking/index.html",
		controller:"booking-ctrl"
	})
	.when("/checkbooking", {
		templateUrl:"/admin/templates/booking/bookingcheck.html",
		controller:"booking-ctrl"
	})
	.when("/services", {
		templateUrl:"/admin/templates/service/index.html",
		controller:"service-ctrl"
	})
	.when("/contacts", {
		templateUrl:"/admin/templates/contact/index.html",
		controller:"contact-ctrl"
	})
	.when("/customers", {
		templateUrl:"/admin/templates/customer/index.html",
		controller:"customer-ctrl"
	})
	.when("/employees", {
		templateUrl:"/admin/templates/employee/index.html",
		controller:"employee-ctrl"
	})
	.when("/vouchers", {
		templateUrl:"/admin/templates/voucher/index.html",
		controller:"voucher-ctrl"
	})
	.when("/billpaid", {
		templateUrl:"/admin/templates/bill/index.html",
		controller:"bill-ctrl"
	})
	.otherwise({
		templateUrl:"/admin/templates/404.html"
	})
})

app.controller("main-ctrl",function($scope,$http, $interval){
	$scope.bookingUCF = [];
	$scope.alertBookingUCF = [];
	$scope.doanhThu = 0;
	$scope.lienHe = 0;
	$scope.lichhenAll=0;
	$scope.lichhenCPM=0;
	$scope.monthYear=moment(new Date()).format('yyyy-MM');
	$scope.authority={};
	
	$scope.initialize=function (){
		$http.get("/rest/booking/alertBookingUCF").then(resp=>{
			$scope.alertBookingUCF = resp.data;
		})
		
		$http.get("/rest/booking/UCF").then(resp=>{
			$scope.bookingUCF = resp.data;
		})
		
		//thong ke
		$http.get(`/rest/thongKeDT?monthYear=${$scope.monthYear}`).then(resp=>{
			$scope.doanhThu=resp.data;
		})
		
		$http.get(`/rest/thongKeLichHenCPM?monthYear=${$scope.monthYear}`).then(resp=>{
			$scope.lichhenCPM=resp.data;
		})
		
		$http.get(`/rest/thongKeLichHen?monthYear=${$scope.monthYear}`).then(resp=>{
			$scope.lichhenAll=resp.data;
		})

		$http.get(`/rest/lienHeTk?monthYear=${$scope.monthYear}`).then(resp=>{
			$scope.lienHe=resp.data;
		})
		
		//phan quyen
		$http.get('/rest/booking/author').then(resp=>{
			$scope.authority=resp.data;
		})
	}
	
	$scope.getMonthYear= function (){
		var item=angular.copy($scope.monthYear);
		$scope.monthYear=moment(new Date(item)).format('yyyy-MM');
		$scope.initialize();
	}	
		
	$scope.initialize();
	$interval($scope.initialize, 10000);
})
