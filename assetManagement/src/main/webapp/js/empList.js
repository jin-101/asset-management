$(function(){
	const PATH = getContextPath();
	const btnTypeInfo = getBtnTypeInformation();
	const apiPath = {
		'list-btn1' : "rentalPossibleEquipment.do",
		'list-btn2' : "allEquipmentType.do",
		'list-btn3' : "allEquipmentModel.do",
		'list-btn4' : "usingEquipment.do"
	};
	
	$(".list-all").click(function(){
		const titleText = $(this).text();
		const btnType = $(this).attr("data-btnType");
		const {btnText, btnClass} = btnTypeInfo[btnType];
		
		$("#change-List-title").html(titleText);
		
		$.ajax({
			url: PATH + "/equi/" + apiPath[$(this).attr('id')],
			method:"GET",
			beforeSend : () => {
				$("#my-spinner").show();
			},
			success:(res)=>{
				$("#change-List-contents").html(res);
				$(".rentalType-btn").html(btnText).addClass(btnClass).attr("data-btnType",btnType);
				$("#my-spinner").hide();
			},
			error:(err)=>{
				console.log(err);
				$("#my-spinner").hide();
			}
		});
	});
	
	$(".list-search").click(function(){
		const titleText = $(this).text();
		const dataTitle = $(this).attr("data-selector-title");
		const dataName = $(this).attr("data-name");
		const btnType = $(this).attr("data-btnType");
		$("#change-List-title").html(titleText);
		$.ajax({
			url: PATH + "/equi/" + apiPath[$(this).attr('id')],
			method:"GET",
			beforeSend : () => {
				$("#my-spinner").show();
			},
			success:(res)=>{
				$("#change-List-contents").html(res);
				$("#selector-name").html(dataTitle + " :");
				$("#optionSelect").attr("name",dataName);
				$(".search-btn").attr("data-btnType",btnType);
				$("#my-spinner").hide();
			},
			error:(err)=>{
				console.log(err);
				$("#my-spinner").hide();
			}
		});
	});
	
});