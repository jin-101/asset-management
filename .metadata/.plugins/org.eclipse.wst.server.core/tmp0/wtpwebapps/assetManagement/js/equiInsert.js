$(function() {
	 const PATH = getContextPath();
	 $("#insert-btn").click(function() {
		const arr = $("#insert-form").serializeArray();
		const obj = {};
		$.each(arr, (index, item)=>{
			obj[item.name] = item.value;
		});
		$.ajax({
			url : PATH + "/equi/equipmentInsert.do",
			method:"POST",
			data: obj,
			beforeSend : () => {
				$("#my-spinner").show();
			},
			success:(res)=>{
				$("#my-spinner").hide();
				if (res === '1') {
					location.href =  PATH + "/equi/equiList.do";
				}else{
					alert("추가 실패");
				}
			},
			error:(err)=>{
				$("#my-spinner").hide();
				console.error(err);
			}
		});
	});
});