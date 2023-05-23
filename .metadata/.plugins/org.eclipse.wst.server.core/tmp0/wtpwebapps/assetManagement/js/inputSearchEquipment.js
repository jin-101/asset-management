$(function(){
	$(".search-btn").click(function() {
		const eqId = $("#eq-id").val();
		$.ajax({
			url: PATH + "/equi/searchEmployeeByEquipmentId.do",
			method:"GET",
			data:{
				eqId:eqId
			},
			beforeSend : () => {
				$("#my-spinner").show();
			},
			success:(res)=>{
				$("#input-search-content").html(res);
				$("#my-spinner").hide();
			},
			error:(err)=>{
				console.log(err);
				$("#my-spinner").hide();
			}
		}); 
	});
});