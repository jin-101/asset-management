$(function(){
	const apiPath = {
			'model' : "searchEquipmentByModel.do",
			'type_name': "searchEquipmentByType.do",
			"emp_name" : "searchEquipmentByEmployee.do"
  	};
	
	$(".search-btn").click(function() {
		const select = $("#optionSelect").val();
		const btnType = $(this).attr("data-btnType");
		const {btnText, btnClass} = btnTypeInfo[btnType];
		const key = $("#optionSelect").attr("name");
		const makeData = {
			index :  $("#optionSelect option").index($("#optionSelect option:selected"))
		}
		makeData[key] = select;
		$.ajax({
			url: PATH + "/equi/" + apiPath[key],
			method:"GET",
			data: makeData,
			beforeSend : () => {
				$("#my-spinner").show();
			},
			success:(res)=>{
				$("#selector-search-content").html(res);
				$(".changeType-btn").html(btnText).addClass(btnClass).attr("data-btnType",btnType);
				$("#my-spinner").hide();
			},
			error:(err)=>{
				console.log(err);
				$("#my-spinner").hide();
			}
		}); 
	});
});