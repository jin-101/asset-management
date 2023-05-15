<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>장비상세보기</title>
<jsp:include page="/common/common.jsp"></jsp:include>
<%-- <link rel="stylesheet" href="${path}/css/empDetail.css"> --%>
<script defer src="${path}/js/equiDetail.js"></script>
</head>

<style>
	header{
		display:flex;
	}
</style>

<body>
	<header>
		<div>장비상세보기</div>
		<button id="go-home">홈으로</button>
	</header>
	<main>
		<form id="detail-form" class="row g-3">
			<div class="col-12">
				<label for="equipmentId">장비번호 : </label> 
				<input type="text" id="equipmentId" name="equipmentId" value="${equipment.equipmentId}"
					readonly>
			</div>
			<div class="col-12">
				<label for="equiType" class="form-label">장비유형 : </label> 
				<select name="equiType">
					<c:forEach items="${equiTypeList}" var="eqType">
						<option value="${eqType.typeId}"
						${equipment.getEquiType().getTypeId() == eqType.typeId ? "selected": ""}>${eqType.typeName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-12">
				<label for="equiCom" class="form-label">제조회사 : </label> 
				<select name="equiCom">
					<c:forEach items="${equiCompanyList}" var="eqCom">
						<option value="${eqCom.coId}"
						${equipment.getEquiCompany().getCoId() == eqCom.coId ? "selected": ""}>${eqCom.coName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-12">
				<label for="model" class="form-label">모델명 :</label> 
				<input type="text" name="model" class="form-control" id="model"
					value="${equipment.model}">
			</div>
			<div class="col-12">
				<label for="serialNo" class="form-label">시리얼번호 :</label> 
				<input type="text" name="serialNo" class="form-control" id="serialNo"
					value="${equipment.serialNo}">
			</div>
			<div>
				<label for="purchaseDate">구매일 : </label>
				<input type="date" name="purchaseDate" id="purchaseDate" required value="${equipment.purchaseDate}">
			</div>
			<div class="col-12">
				<label for="price" class="form-label">가격(만원):</label> 
				<input type="text" name="price" class="form-control" id="price" value="${equipment.price}">
			</div>
			<div class="submit">
				<input type="button" id="update-btn" class="btn btn-success" value="장비정보 수정"/>
			</div>
		</form>
	</main>
</body>
</html>