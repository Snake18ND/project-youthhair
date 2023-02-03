app.controller("voucher-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.form = {};
    $scope.disabledId = false;
    $scope.disabledBtnUpdate = true;
    $scope.disabledBtnCreate = false;
    $scope.seachVoucher={
        id:''
    };
    $scope.initialize = function () {
        $http.get(`/rest/voucher/seachVoucher?id=${$scope.seachVoucher.id}`).then(resp => {
            $scope.items = resp.data;
        })
    }
    $scope.form.condition = "";
    $scope.form.id = "";
    $scope.form.price = "";
    $scope.form.note = "";


    $scope.doSubmitForm = function(event) {
        alert("OK: " + $scope.userForm.$submitted);
        // Code to Submit form!
    }

    $scope.initialize();

    $scope.reset = function () {
        $scope.form = {};
        $scope.disabledId = false;
        $scope.disabledBtnCreate = false;
        $scope.disabledBtnUpdate = true;
    }
    //hien thi len form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');
        $scope.disabledId = true;
        $scope.disabledBtnUpdate = false;
        $scope.disabledBtnCreate = true;
    }

    //them voucher moi
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/voucher`, item).then(resp => {
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công!");
            $(".nav-tabs a:eq(1)").tab('show');
        }).catch(error => {
            alert("Thêm mới không thành công!");
            console.log("Error", error);
        });
    }
    //cap nhat voucher
    $scope.update = function () {
        var item = angular.copy($scope.form);
        if (confirm("Bạn có muốn chỉnh sửa thông tin voucher này không?")) {
            $http.put(`/rest/voucher/${item.id}`, item).then(resp => {
                var index = $scope.items.findIndex(p => p.id === item.id);
                $scope.items[index] = item;
                $scope.reset();
                alert("Chỉnh sửa thông tin voucher thành công!");
                $(".nav-tabs a:eq(1)").tab('show');
            }).catch(error => {
                alert(" Chỉnh sửa thông tin voucher không thành công!");
                console.log("Error", error);
            });
        }
    }
    // $scope.delete = function (item) {
    //     if (confirm("Bạn có muốn xoá nhân viên này không?")) {
    //         $http.delete(`/rest/voucher/${item.id}`).then(resp => {
    //             var index = $scope.items.findIndex(p => p.id == item.id);
    //             $scope.items.splice(index, 1);
    //             $scope.reset();
    //             alert("Xóa nhân viên thành công!");
    //         }).catch(error => {
    //             alert("Lỗi xóa nhân viên!");
    //             console.log("Error", error);
    //         });
    //     }
    // }

    $scope.sizePage = [3, 5, 10, 15, 20];
    $scope.pager = {
        page: 0,
        size: 3,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size)
        },
        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.first();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.last();
            }
        },
        last() {
            this.page = this.count - 1;
        }
    }

    //tim kiem
    $scope.seachVoucherByName=function (){
        var item=angular.copy($scope.seachVoucher);
        $scope.seachVoucher.id =item.id;
        $scope.pager.first();
        $scope.initialize();
    }
})






