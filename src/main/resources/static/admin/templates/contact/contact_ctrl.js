app.controller("contact-ctrl",function($scope,$http){
	
	$scope.items = [];
	$scope.stylists = [];
	$scope.form={};
	$scope.statusContact = '';
	$scope.seachContact = {
		status:'true',
		fullName:''
	};

	$scope.initialize=function (){
		//load contacts
		$http.get(`/rest/contact/seachContact?fullName=${$scope.seachContact.fullName}&status=${$scope.seachContact.status}`).then(resp=>{
			$scope.items = resp.data;
		});
		
		//load services
		$http.get("/rest/booking/checkedService").then(resp=>{
			$scope.db=resp.data;
			$scope.servicesChecked=$scope.db.services;
		})
		
		//load all stylist
		$http.get("/rest/employee/allStylist").then(resp=>{
			$scope.stylists=resp.data;
		})
	}

	//show data into form
	$scope.showDetail = function(item){
		$scope.form = angular.copy(item);
		var input = document.getElementsByName("status");
		if($scope.form.status == true){		
			input[0].setAttribute("disabled", "disabled");
		}else{
			input[0].removeAttribute("disabled")
		}
	}
	
	$scope.loadTableDXL = function(){
		$scope.statusContact = 'DXL';
		$scope.initialize();
		$scope.pager.first();
	}
	
	$scope.loadTableCXL = function(){
		$scope.statusContact = 'CXL';
		$scope.initialize();
		$scope.pager.first();
	}
	
	//update contact
    $scope.update = function(){
	    var item = angular.copy($scope.form);
			
        $http.put(`/rest/contact/${item.id}`,item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật liên hệ thành công!");
			$scope.pager.first();
			$scope.initialize();
			$(".close").click();
        }).catch(error => {
            alert("Lỗi cập nhật liên hệ!");
            console.log("Error",error);
        });
    }

	//delete contact
	$scope.delete = function(item){
		if(confirm("Bạn có muốn xoá liên hệ này không?")){
	        $http.delete(`/rest/contact/${item.id}`).then(resp => {
	            var index = $scope.items.findIndex(p => p.id == item.id);
	            $scope.items.splice(index,1);
	            alert("Xóa liên hệ thành công!");
				$scope.pager.first();
				$scope.initialize();
	        }).catch(error => {
	            alert("Lỗi xóa liên hệ!");
	            console.log("Error",error);
	        });
		}
    }
	
	$scope.sizePage = [3,6,9,11];
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

	$scope.loadContactByCusName = function (){
		var item=angular.copy($scope.seachContact);
		$scope.seachContact.fullName =item.fullName;
		$scope.pager.first();
		$scope.initialize();
	}
	$scope.loadTableByStatus = function(){
		var item=angular.copy($scope.seachContact);
		$scope.seachContact.status = item.status;
		$scope.initialize();
		$scope.pager.first();
	}
	
	//Them Lich Hen MOi	
	$scope.formBooking = {
		createDate: new Date(),
		listSer: [],
	};
	
	$scope.showBookingSave = function(item){
		$scope.formBooking.fullName = item.fullName;
		$scope.formBooking.email = item.email;
		$scope.formBooking.phone = item.phone;		
	};
	
	//Lấy list service người dùng chọn
	$scope.cart = {
		items: [],
		//Them service vao list

		add(id) {
			var item = this.items.find(item => item.id == id);
			var index = this.items.findIndex(item => item.id == id);
			if (item) {
				this.items.splice(index, 1);
			} else {
				$http.get(`/rest/services/${id}`).then(resp => {
					this.items.push(resp.data);
				})
			}
		},
		// Xóa sạch list
		clear() {
			this.items = [];
		},
		// Tông thành tiền các service trong list
		get amount() {
			return this.items
				.map(item => item.price)
				.reduce((total, price) => toprice = (total += price), 0,);

		},
		//tổng time trong list
		get totalTime() {
			var convertDate1 = null;
			var totalHour = 0;
			var totalMinutes = 0;
			var totalSeconds = 0;
			for (var i = 0; i < $scope.cart.items.length; i++) {
				convertDate1 = new Date("1970-01-01 " + $scope.cart.items[i].time);
				totalHour += convertDate1.getHours();
				totalMinutes += convertDate1.getMinutes();
				totalSeconds += convertDate1.getSeconds();
			}
			if (totalSeconds > 59) {
				totalSeconds -= 60;
				totalMinutes += 1;
			} else if (totalMinutes > 59) {
				totalMinutes -= 60;
				totalHour += 1;
			}
			var convertTotal = String(totalHour + ":" + totalMinutes + ":" + totalSeconds);
			var newDateByTotal = new Date("1970-01-01 " + convertTotal)
			const value = moment(new Date(newDateByTotal)).format('HH:mm');
			var value1 = moment(new Date(newDateByTotal)).format('HH:mm:ss');
			totime = value1;
			return value.replace(":", " Giờ ");
		},
	}
	
	var totime;
    var toprice;
	$scope.saveBooking = function() {
		var bookings = angular.copy($scope.formBooking);
		const value1 = moment($scope.formBooking.time).format('DD/MM/yyyy HH:mm:ss');
		bookings.timeBooking=value1;
		const value = moment($scope.formBooking.createDate).format('YYYY-MM-DD');
		if (toprice > 0) {
			//bookings.timeBooking = totime;
			bookings.totalPrice = toprice;
			bookings.createDate = value;
			bookings.listSer = $scope.cart.items;
			bookings.stylistId=$scope.formBooking.stylistId;

		} else {
			bookings.totalTime = 0;
			bookings.totalPrice = 0;
		}
		if (bookings.fullName == null || bookings.email == null
			|| bookings.createDate == null || bookings.phone == null
			|| bookings.createDate == undefined || bookings.totalPrice==0 ||
			bookings.stylistId == undefined) {
			console.log($scope.formBooking)
			console.log($scope.cart.items)
			alert("Vui lòng nhập thông tin đầy đủ")

		} else {
			//checkBooking UCF by phone
			//$http.get(`rest/checkBooking/${bookings.phone}`).then(resp => {
			//	$scope.bookingUCF = {}
			//	$scope.bookingUCF= resp.data;
			//	console.log( $scope.bookingUCF)
			//})
			
			//add data => BE
				$http.post("/rest/bookingContact", bookings).then(resp => {
					alert("Xác nhận thành công !");
					$scope.cart.clear();
					$scope.initialize();
					$("#closeModalBookingContact").click();
				}).catch(error => {
					alert("Cập nhật thất bại!")
					// $scope.form.data = null;
					console.log(error);
				})
		}
	}
	
})