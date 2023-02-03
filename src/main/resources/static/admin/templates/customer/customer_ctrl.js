app.controller("customer-ctrl",function($scope,$http){
	$scope.items=[];
	$scope.vouchers=[];
	$scope.voucherDetails=[];
	$scope.form={};
	$scope.formVoucherGift={
		status: true,
		customer: null,
		voucher: {
            id: ""
        }
	};
	$scope.seachCustomer={
		fullName:''
	};
	$scope.initialize=function (){
		//load customer
		$http.get(`/rest/customer/seachCustomer?fullName=${$scope.seachCustomer.fullName}`).then(resp=>{
			$scope.items = resp.data;
		})
		//load voucher
		$http.get("/rest/voucher").then(resp=>{
			$scope.vouchers = resp.data;
		})
	}
	
	

	$scope.initialize();
	
	//hien thi len form
	$scope.showDetail = function(item){
		$scope.form = angular.copy(item);
	}
	
	$scope.openGiftForm = function(item){
		$scope.formVoucherGift.customer = angular.copy(item);
	}
	
	//Tang voucher
	$scope.giftVoucher = function(){
		var item = angular.copy($scope.formVoucherGift);
		if(item.voucher.id == null){
			alert("Bạn chưa chọn voucher để tặng!")
		}else{			
			$http.post(`/rest/voucherDetail`, item).then(resp => {
				var index = $scope.vouchers.findIndex(v => v.id === item.voucher.id);
				$scope.vouchers[index] = item.voucher;			
	            $scope.voucherDetails.push(resp.data);        
	            alert("Tặng voucher " + item.voucher.id + " thành công cho khách hàng "+ item.customer.fullName +"!");
				$(".close").click(); 
	        }).catch(error => {
	            alert("Tặng voucher không thành công!");
	            console.log("Error", error);
	        });
		}
		
	}

	
	//cap nhat 
	$scope.update = function(){
		var item = angular.copy($scope.form);
		if(item.phone != null && item.email != null){
			$http.put(`/rest/customer/${item.id}`,item).then(resp => {
				var index = $scope.items.findIndex(p => p.id === item.id);
				$scope.items[index] = item;
				alert("Chỉnh sửa thông tin thành công!");
				$(".close").click(); 
			}).catch(error => {
				alert(" Chỉnh sửa thông tin không thành công!");
				console.log("Error",error);
			});
		}	
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
		get setPage(){
			return this.first();
		},
		first(){
			this.page = 0;
			$scope.disabledBtnFisrt = true;
			$scope.disabledBtnLast = false;
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
			$scope.disabledBtnFisrt = false;
			$scope.disabledBtnLast = true;
		}
	}

	//tim kiem
	$scope.seachCustomerByName=function (){
		var item=angular.copy($scope.seachCustomer);
		$scope.seachCustomer.fullName =item.fullName;
		$scope.pager.first();
		$scope.initialize();
	}
})