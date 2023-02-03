app.controller("bill-ctrl",function($scope,$http){
	
	$scope.items=[];
	$scope.form={};
	$scope.statusBooking = 'CPM';
	$scope.seachBooking={
		statusBooking:'CPM',
		toDate:undefined,
		formDate:undefined,
		cusName:''
	};
	
	$scope.initialize = function (){
		//load contacts
		$http.get(`/rest/booking/seachBooking?statusId=${$scope.seachBooking.statusBooking}&toDateStr=${$scope.seachBooking.toDate}&formDateStr=${$scope.seachBooking.formDate}&cusName=${$scope.seachBooking.cusName}`).then(resp=>{
			$scope.items = resp.data;
		});
	}	
	
	$scope.showDetail = function(item){
		$scope.form={};
		$scope.form = angular.copy(item);
	}
	
	$scope.loadTableCPM = function(){
		var item=angular.copy($scope.seachBooking);
		$scope.seachBooking.statusBooking = item.statusBooking;
		$scope.pager.first();
		$scope.initialize();
	}
	
	$scope.loadTableCAN = function(){
		var item=angular.copy($scope.seachBooking);
		$scope.seachBooking.statusBooking = item.statusBooking;
		$scope.pager.first();
		$scope.initialize();
	}
	
	$scope.sizePage = [5,10,15,20];
	//phan trang
	$scope.pager = {
		page: 0,
		size: 5,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start,start + this.size);
		},
		get count(){
			return Math.ceil(1.0 *$scope.items.length / this.size)
		},
		first(){
			this.page = 0;
		},
		prev(){
			this.page--;
			if(this.page <= 0){
				this.first();
			}
		},
		next(){
			this.page++;
			if(this.page+1 >= this.count){
				this.last();
			}
		},
		last(){
			this.page = this.count - 1;
		}
	}
	
	
	//start
	$scope.initialize();

	//tim kiem
	$scope.loadTableToDate = function(){
		var item = angular.copy($scope.seachBooking);
		var a = new Date(item.formDate);
		if(item.toDate!=undefined) {
			if(item.formDate==undefined){
				$scope.seachBooking.formDate=undefined;
			}else{
				$scope.seachBooking.formDate= moment(new Date(item.formDate)).format('MM/DD/yyyy');
			}
			$scope.seachBooking.toDate = moment(item.toDate).format('MM/DD/yyyy');
			$scope.pager.first();
			$scope.initialize();
		}else {
			$scope.seachBooking.toDate= undefined;
			$scope.pager.first();
			$scope.initialize();
		}
	}

	$scope.loadTableFormDate = function(){
		var item = angular.copy($scope.seachBooking);
		if(item.formDate!=undefined) {
			if(item.toDate==undefined){
				$scope.seachBooking.toDate=undefined;
			}else{
				$scope.seachBooking.toDate= moment(new Date(item.toDate)).format('MM/DD/yyyy');
			}
			$scope.seachBooking.formDate = moment(item.formDate).format('MM/DD/yyyy');
			$scope.pager.first();
			$scope.initialize();
		}else {
			$scope.seachBooking.formDate= undefined;
			$scope.pager.first();
			$scope.initialize();
		}
	}

	$scope.seachBookingByCusName = function (){
		var item=angular.copy($scope.seachBooking);
		$scope.seachBooking.cusName =item.cusName;
		$scope.pager.first();
		$scope.initialize();
	}

	$scope.resetSeach = function(){
		$scope.seachBooking.toDate =undefined;
		$scope.seachBooking.formDate =undefined;
		$scope.pager.first();
		$scope.initialize();
	}
})