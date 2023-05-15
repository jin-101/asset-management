$(function() {
	const PATH = getContextPath();
	$("#update-btn").click(function(){
		makeModal({
			text : "수정을 진행하시겠습니까?",
			callback: () => {
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
			}
		});
	});
	
	
	//홈으로 (전체대여장비 창으로 이동)
	$("#go-home").click(function(){
		location.href =  PATH + "/equi/equiList.do";
	});
});