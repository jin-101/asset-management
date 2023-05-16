<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장비등록하기</title>
<jsp:include page="/common/common.jsp"></jsp:include>
<%-- <link rel="stylesheet" href="${path}/css/empInsert.css"> --%>
<script defer src="${path}/js/equiInsert.js"></script>

<style>
	header{
		display:flex;
	}
</style>

</head>
<body>
	<header>
		<div>장비추가하기</div>
		<button id="go-home">홈으로</button>
	</header>
	<main>
		<form id="insert-form" class="row g-3">
			<div class="col-12">
				<label for="equiType" class="form-label">장비유형 : </label> 
				<select name="equiType">
					<option selected disabled>선택하세요</option>
					<c:forEach items="${equiTypeList}" var="eqType">
						<option value="${eqType.typeId}">${eqType.typeName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-12">
				<label for="equiCom" class="form-label">제조회사 : </label> 
				<select name="equiCom">
					<option selected disabled>선택하세요</option>
					<c:forEach items="${equiCompanyList}" var="eqCom">
						<option value="${eqCom.coId}">${eqCom.coName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-12">
				<label for="model" class="form-label">모델명 :</label> 
				<input type="text" name="model" class="form-control" id="model" required>
			</div>
			<div class="col-12">
				<label for="serialNo" class="form-label">시리얼번호 :</label> 
				<input type="text" name="serialNo" class="form-control" id="serialNo" required>
			</div>
			<div>
				<label for="purchaseDate">구매일 : </label>
				<input type="date" name="purchaseDate" id="purchaseDate" required>
			</div>
			<div class="col-12">
				<label for="price" class="form-label">가격(만원):</label> 
				<input type="text" name="price" class="form-control" id="price">
			</div>
			<div class="submit">
				<input type="button" id="insert-btn" class="btn btn-success" value="장비추가"/>
			</div>
		</form>
	</main>
</body>
</html>