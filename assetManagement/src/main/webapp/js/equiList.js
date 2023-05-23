const PATH = getContextPath();
const btnTypeInfo = getBtnTypeInformation();
const ajaxParamsInfo = {
		'list-btn1' : {path:"rentalPossibleEquipment.do", successF:listAllSuccess},
		'list-btn2' : {path:"allEquipmentType.do", successF:listSearchSuccess},
		'list-btn3' : {path:"allEquipmentModel.do", successF:listSearchSuccess},
		'list-btn4' : {path:"usingEquipment.do", successF:listAllSuccess},
		'list-btn5': {path:"allEmpAndDept.do", successF:listSearchSuccess},
		'list-btn6': {path:"countAllEquipment.do", successF:modifySuccess},
		'list-btn7' : {path:"equipmentInsert.do", successF:modifySuccess},
		'list-btn8': {path:"rentalPossibleEquipment.do", successF:listAllSuccess}, //rentalPossibleEquipment.do
		'eq-items': {path:"equipmentDetail.do", successF:modifySuccess}
}

$(function(){
	//리스트 클릭 시 실행 함수
	$(".list-btn").click(function(){
		const titleText = $(this).text();
		$("#change-List-title").html(titleText);
		const currentButtonInfo = ajaxParamsInfo[$(this).attr('id')];
		$.ajax({
			url: PATH + "/equi/" + currentButtonInfo.path,
			method:"GET",
			beforeSend : () => {
				$("#my-spinner").show();
			},
			success: currentButtonInfo.successF.bind(this),
			error:(err)=>{
				console.log(err);
				$("#my-spinner").hide();
			}
		});
	});
	
	jqueryUpdateAction(); //update시 실행되는 함수
	
	//홈으로 (전체대여장비 창으로 이동)
	$("#go-home").click(function(){
		location.href =  PATH + "/equi/equiList.do";
	});
	
});




//equiList 공통함수 ----------------------------------------------------------------

//update시 실행되는 함수
function jqueryUpdateAction(){
	$(function(){
		// 장비내역수정 페이지으로 이동
		$(".eq-items").click(function(){
			$("#change-List-title").html("장비내역 수정");
			const currentButtonInfo = ajaxParamsInfo[$(this).attr('class')];
			$.ajax({
				url: PATH + "/equi/" + currentButtonInfo.path,
				method:"GET",
				data:{
					eqid:$(this).attr("data-id")
				},
				beforeSend : () => {
					$("#my-spinner").show();
				},
				success: currentButtonInfo.successF,
				error:(err)=>{
					console.log(err);
					$("#my-spinner").hide();
				}
			});
		});
	});
}

//버튼정보 가져오는 함수
function getBtnTypeInformation () {
	const btnTypeInfo = {
			rentalBtn : { btnText:'대여', btnClass:'btn-primary', ajaxPath:'equipmentRental.do', ajaxMethod:'POST'},
			returnBtn : { btnText:'반납', btnClass:'btn-danger', ajaxPath:'equipmentReturn.do', ajaxMethod:'POST'},
			removeBtn : { btnText:'삭제', btnClass:'btn-danger', ajaxPath:'equipmentDelete.do', ajaxMethod:'POST'}
	}
	return btnTypeInfo;
}

//list타입별 ajax success함수
//list-all, delete
function listAllSuccess(res){
	const btnType = $(this).attr("data-btnType");
	const {btnText, btnClass} = btnTypeInfo[btnType];
	$("#change-List-contents").html(res);
	$(".changeType-btn").html(btnText).addClass(btnClass).attr("data-btnType",btnType);
	$("#my-spinner").hide();
}

//list-search
function listSearchSuccess(res){
	const btnType = $(this).attr("data-btnType");
	const dataTitle = $(this).attr("data-selector-title");
	const dataName = $(this).attr("data-name");
	$("#change-List-contents").html(res);//새로운 html 넣기
	$("#selector-name").html(dataTitle + " :");
	
	const stringData = $("#hidden-data").html();
	const params = {
		parentElement: $("#div-select"),
		selectorId : "optionSelect",
		callback: () => {
			$("#my-spinner").hide();
		}
	};
	if($(this).attr("data-res")==="emp") makeSelectBoxByEmp({ dataArr:JSON.parse(stringData), ...params});
	else makeSelectBoxByString({ dataArr:stringData.replace("[","").replace("]","").split(","), ...params});
	
	$("#optionSelect").attr("name",dataName);
	$(".search-btn").attr("data-btnType",btnType);
	$("#my-spinner").hide();
	$("#hidden-data")?.remove(); //데이터값 지우기
}
//insert, update, inputSearchEquipment
function modifySuccess(res){
	$("#change-List-contents").html(res);
	$("#my-spinner").hide();
}