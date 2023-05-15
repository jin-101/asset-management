$(function(){
	const PATH = getContextPath();
	const btnTypeInfo = getBtnTypeInformation();
	const apiPath = {
		'list-btn1' : "rentalPossibleEquipment.do",
		'list-btn2' : "allEquipmentType.do",
		'list-btn3' : "allEquipmentModel.do",
		'list-btn4' : "usingEquipment.do",
		'list-btn5':"",
		'list-btn6':"",
		'list-btn7' : "equipmentInsert.do",
		'list-btn8':"",
		'update-btnPath': "equipmentDetail.do"
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
	
	//장비추가 페이지로 이동
	$("#list-btn7").click(function(){
		console.log(apiPath[$(this).attr('id')])
		location.href = PATH+"/equi/"+ apiPath[$(this).attr('id')]
	});
	
	
	// 장비내역수정 페이지으로 이동
	$(".eq-items").click(function(){
		location.href = PATH+"/equi/"+apiPath['update-btnPath']+"?eqid=" + $(this).attr("data-id");
	});
});