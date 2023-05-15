$(function() {
	const PATH = getContextPath();
	const btnTypeInfo = getBtnTypeInformation();

	//대여 or 반납 버튼을 눌렀을 때
	$(".rentalType-btn").click(function(e) {
		e.stopPropagation();
		const btnType = $(this).attr("data-btnType");
		if (btnType === "rentalBtn") {
			//장비대여로직
			$.ajax({
				url: PATH + "/emp/allEmpAndDept.do",
				method: "GET",
				beforeSend: () => {
					$("#my-spinner").show();
					$("#rental-user").html("");
				},
				success: (res) => {
					const userArr = JSON.parse(res);
					$("#rental-user").append("<option>선택하세요</option>");
					$.each(userArr, (index, el) => {
						const dept = el.subpart.dept.departmentName;
						$("#rental-user").append("<option>" + el.firstName + " " + el.lastName + " " + (dept ? "(" + dept + ")" : '') + "</option>");
					});
					$("#my-spinner").hide();
				},
				error: (err) => {
					console.log(err);
					$("#my-spinner").hide();
				}
			});

			// 팝업띄우기
			$("#modal-input-eqId").val($(this).attr("data-equipmentId"));
			$("#modal-input-eqModel").val($(this).attr("data-model"));
			$("html").css("overflow", "hidden");
			$(".modal").css("display", "block");
		} else {
			//장비반납로직
			const { ajaxPath, ajaxMethod } = btnTypeInfo[btnType];
			const returnData = {
				eqId: $(this).attr("data-equipmentid")
			};
			console.log(returnData)
			$.ajax({
				url: PATH + "/equi/" + ajaxPath,
				method: ajaxMethod,
				data: returnData,
				beforeSend: () => {
					$("#my-spinner").show();
				},
				success: (res) => {
					$("#my-spinner").hide();
					if (res === '1') {
						alert("반납성공");
						location.href = PATH + "/equi/equiList.do"
					}
				},
				error: (err) => {
					console.log(err);
					$("#my-spinner").hide();
				}
			});
		}

	});

	//모달-대여하기버튼 클릭시
	$(".rental-btn").click(function() {
		const empId = $("#rental-user option").index($("#rental-user option:selected"));
		const btnType = $(".rentalType-btn").attr("data-btnType");
		const { ajaxPath, ajaxMethod } = btnTypeInfo[btnType];
		if (empId !== 0) {
			const rentalData = {
				eqId: $("#modal-input-eqId").val(),
				empId: empId
			}
			$.ajax({
				url: PATH + "/equi/" + ajaxPath,
				method: ajaxMethod,
				data: rentalData,
				beforeSend: () => {
					$("#my-spinner").show();
				},
				success: (res) => {
					$("#my-spinner").hide();
					if (res === '1') {
						$(".modal").css("display", "none");
						$("html").css("overflow", "auto");
						alert("대여성공");
						location.href = PATH + "/equi/equiList.do"
					}
					console.log(res);
				},
				error: (err) => {
					console.log(err);
					$("#my-spinner").hide();
				}
			});
		}
	});

	//모달-취소버튼 클릭시
	$(".cancel-btn").click(function() {
		$(".modal").css("display", "none");
		$("html").css("overflow", "auto");
	});
})