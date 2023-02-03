// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        "language": {
			"paginate": {
	        	"previous": "Trước",
				"next": "Sau"
	        },
            "lengthMenu": "Hiển thị _MENU_ ",
            "zeroRecords": "Dữ liệu trống",
            "info": "Trang _PAGE_ / _PAGES_",
            "infoEmpty": "Không có dữ liệu",
            "infoFiltered": "(filtered from _MAX_ total records)",
			"search": "Tìm Kiếm: _INPUT_ "
        }
    });
});
