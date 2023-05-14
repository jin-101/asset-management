<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택메뉴</title>
<jsp:include page="/common/common.jsp"></jsp:include>
<link rel="stylesheet" href="${path}/css/menu.css">
<script type="text/javascript" defer src="${path}/js/menu.js"></script>
</head>
<body>
	<main>
		<div class="container">
			<div class="title-container">
				<div class="h1-text">
					<h1>메뉴 선택</h1>
				</div>
			</div>
			<div class="menu-container">
				<div class="imgBoxBtn equipMenuBtn">
					<div class="imgDiv">
						<img class="equipImg" alt="장비" src="${path}/images/testImage.png">
					</div>
					<div class="imgTitle">장비관리 메뉴</div>
				</div>
				<div class="imgBoxBtn empMenuBtn">
					<div class="imgDiv">
						<img class="empImg" alt="회원" src="${path}/images/testImage.png">
					</div>
					<div class="imgTitle">회원관리 메뉴</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>