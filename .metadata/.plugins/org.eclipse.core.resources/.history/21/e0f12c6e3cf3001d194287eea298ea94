$(function() {
	const PATH = getContextPath();
	$("#update-btn").click(function(){
		const arr = $("#detail-form").serializeArray();
		const obj = {};
		$.each(arr, (index, item)=>{
			obj[item.name] = item.value;
		});
		$.ajax({
			url : PATH + "/equi/equipmentDetail.do",
			method:"POST",
			data: obj,
			beforeSend : () => {
				$("#my-spinner").show();
			},
			success:(res)=>{
				$("#my-spinner").hide();
				if (res === '1') {
					alert("업데이트 성공");
					location.href =  PATH + "/equi/equiList.do";
				}else {
					alert("업데이트 실패");
				}
				
			},
			error:(err)=>{
				$("#my-spinner").hide();
				console.error(err);
			}
		});
	});
});