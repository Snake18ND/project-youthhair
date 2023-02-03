app.controller("employee-ctrl",function($scope,$http){

    
	$scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.dsphanca = [];
	$scope.calamviec = [];	
    
	$scope.form.fullName = "";
	$scope.form.nickname = "";
    $scope.form.gender = "";
    $scope.form.salary = "";
    $scope.form.phone = "";
    $scope.form.address = "";
	$scope.form.statusWork = "";
	$scope.form.role = "";
	$scope.form.startDate = "";

    $scope.seachEmployee={
        fullName:''
    }

    $scope.doSubmitForm = function(event) {
        alert("OK: " + $scope.myForm.$submitted);

    }
 
	$scope.getMinMaxTime = {
		today: new Date(),
		minDate: '',
		
		FuncMinDate(){
			var input = document.getElementById("datePhanCa");
	        var dd = this.today.getDate() + 1;
	        var mm = this.today.getMonth() + 1;
	        var yyyy = this.today.getFullYear();
	        
			if (this.today.getHours() > 21){
				dd = this.today.getDate() + 2;
	        }

			if(dd > 31){
				dd = this.today.getDate() - 30;
				mm = this.today.getMonth() + 2;
			}else{
				mm = this.today.getMonth() + 1;
			}
						
	        if (mm < 10) {
				if(mm == 2){
					if(dd > 28){
						dd = this.today.getDate() - 27;
						mm = this.today.getMonth() + 2;
					}
					
				}
	            mm = '0' + mm;
	        }
	        
	        if (dd < 10) {
	            dd = '0' + dd;
	        }
	        this.minDate = yyyy + '-' + mm + '-' + dd;
	        input.setAttribute("min", this.minDate);
	        //document.getElementById("dateUpdatePhanCa").setAttribute("min", this.minDate);
			return this.minDate;
		}	
	}
	
	$scope.getMinMaxTime.FuncMinDate();
    
    $scope.disabledBtnReset = false;
	$scope.disabledBtnUpdate = false;
	$scope.disabledBtnDelete = false;
	$scope.disabledBtnCreate = false;
	


    $scope.initialize = function(){
        //load product
        $http.get(`/rest/employee/seachEmployee?fullName=${$scope.seachEmployee.fullName}`).then(resp => {
            $scope.items = resp.data;
            $scope.reset();
            $scope.items.forEach(item => {
                item.startDate = new Date(item.startDate);
            })
        });
       
        //load categories
        $http.get("/rest/role").then(resp => {
            $scope.cates = resp.data;
        });
   		 
   		//load Workassign
        $http.get("/rest/Workassign").then(resp => {
            $scope.dsphanca = resp.data;
        });

		//load shifts
        $http.get("/rest/shifts").then(resp => {
            $scope.calamviec = resp.data;
        });
		
    }
    
        
    //khoi dau
    $scope.initialize();
    
    

    //xoa form
    $scope.reset= function(){
		$scope.form = {
		startDate:new Date(),
		image:'undraw_profile.svg',
		statusWork:true,
		
		};
		
		
		$scope.disabledBtnUpdate = true;
		$scope.disabledBtnDelete = true;
		$scope.disabledBtnReset = false;
		$scope.disabledBtnCreate = false;
		
    }
    
    
    //hien thi len form,sau do quay ve tab 0
    $scope.edit = function(item){
        item.createDate = new Date(item.createDate);
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');
        
        $scope.disabledBtnReset = false;
        $scope.disabledBtnCreate = true;
		$scope.disabledBtnUpdate = false;
		$scope.disabledBtnDelete = false;
		
    }
    
    
    //them sp moi
    $scope.create = function(){
	    var item = angular.copy($scope.form);
        $http.post(`/rest/employee`,item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công!");
            location.reload(); 
            $(".nav-tabs a:eq(1)").tab('show');
            
        })
    }

    
    //cap nhat sp
    $scope.update = function(){
	    var item = angular.copy($scope.form);
        $http.put(`/rest/employee/${item.id}`,item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;            
            $scope.reset();
            alert("Cập nhật nhân viên thành công!");
            location.reload();
            
            $(".nav-tabs a:eq(1)").tab('show');
        })
    }
     
    
    
    //xoa sp
    
    $scope.delete = function(item){
    if(confirm("Bạn có muốn xoá liên hệ này không?")){
        $http.delete(`/rest/employee/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index,1);
            $scope.reset();
            alert("Xóa nhân viên thành công!");
            location.reload(); 
            $(".nav-tabs a:eq(1)").tab('show');
        }).catch(error => {
            alert("Không thể xóa nhân viên này!");
            console.log("Error",error);
        });
    }
    }
    
    
    
    
    
    
    //upload hinh
    $scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file',files[0]);
		$http.post('/rest/upload/images',data,{
            transformRequest: angular.identity,
            headers: {'Content-Type':undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Upload Image False!");
            console.log("Error",error);
        })
    }    
    
    
    $scope.disabledBtnFisrt = false;
	$scope.disabledBtnLast = false;
	$scope.disabledBtnNext = false;
	$scope.disabledBtnPrev = false;
    
    
    $scope.sizePage = [5,10,15,20];
    
    //phan trang
    $scope.pager = {
        page: 0,
        size:5,
        
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start,start + this.size);
        },
        get count(){
        //tong so sp chia kich thuoc trang
            return Math.ceil(1.0 *$scope.items.length / this.size);
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
        	if(this.page<=0){
        		this.first();
        	}
        },
        next(){
        	this.page++;
        	if(this.page+1>=this.count){
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
    $scope.seachEmployeeByName=function (){
        var item=angular.copy($scope.seachEmployee);
        $scope.seachEmployee.fullName =item.fullName;
        $scope.pager.first();
        $scope.initialize();
    }
	

	 //phan trang list phan ca
    $scope.pagerPhanCa = {
        page: 0,
        size:5,
        
        get items(){
            var start = this.page * this.size;
            return $scope.dsphanca.slice(start,start + this.size);
        },
        get count(){
        //tong so sp chia kich thuoc trang
            return Math.ceil(1.0 *$scope.dsphanca.length / this.size);
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
        	if(this.page<=0){
        		this.first();
        	}
        },
        next(){
        	this.page++;
        	if(this.page+1>=this.count){
        		this.last();
        	}
        },
        last(){
        	this.page = this.count - 1;
        	$scope.disabledBtnFisrt = false;
			$scope.disabledBtnLast = true;
        }
	}
	
	
	$scope.formPhanCa = {
		date: new Date($scope.getMinMaxTime.minDate)
	};
	
	//show modal ca lam
	$scope.showModalPhanCa = function(item){        
        $scope.formPhanCa.employee = angular.copy(item);
    }
	
	// them ca lam
	$scope.saveCaLam = function(){
	    var item = angular.copy($scope.formPhanCa);
		const valueDate = moment($scope.formPhanCa.date).format('yyyy-MM-DD');
		item.date = valueDate;
		$http.get(`/rest/checkWorkassignNull?id=${item.employee.id}`).then(resp => {
			var indCheck = resp.data.findIndex(a => a.date == item.date);
			console.log(item.shifts)			
			if(indCheck == -1){
				if(item.shifts.id != null){
					$http.post(`/rest/Workassign`, item).then(resp => {
                        var index = $scope.dsphanca.findIndex(c => c.id === item.id);
                        $scope.dsphanca[index] = item;			
                        $scope.dsphanca.push(resp.data);
                        $scope.initialize();
						$scope.formPhanCa = {
							date: new Date($scope.getMinMaxTime.minDate)
						};        
                        alert("Thêm ca làm " + item.shifts.id + " thành công cho nhân viên "+ item.employee.fullName +"!");
                        $("#closePhanCaModal").click(); 
                    }).catch(error => {
                        alert("Thêm ca làm không thành công!");
                        console.log("Error", error);
                    });
                    
                }else{			
                    alert("Bạn chưa chọn ca để thêm!")
                }
			}else{
				alert("Nhân viên này đã đăng ký ca làm cho ngày "+ item.date +"!")
			}
        });

		
    }

	//sua ca lam
	$scope.formEditCaLam = {
		//date: new Date($scope.getMinMaxTime.minDate)
	}
	$scope.editCaLam = function(item){
        $scope.formEditCaLam = angular.copy(item);
    }
	
	$scope.updateCaLam = function(){
	    var item = angular.copy($scope.formEditCaLam);

		if(item.shifts.id == null){
			alert("Bạn chưa chọn ca để thêm!")
		}else{			
			$http.put(`/rest/Workassign`, item).then(resp => {
				var index = $scope.dsphanca.findIndex(c => c.id === item.id);
				$scope.dsphanca[index] = item;			
	            $scope.dsphanca.push(resp.data);
				//$scope.initialize();        
	            alert("Sửa ca làm " + item.shifts.id + " thành công cho nhân viên "+ item.employee.fullName +"!");
				$("#closeUpdatePhanCaModal").click(); 
	        }).catch(error => {
	            alert("Sửa ca làm không thành công!");
	            console.log("Error", error);
	        });
		}
    }


})