<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asset</title>
<jsp:include page="/common/common.jsp"></jsp:include>
<link rel="stylesheet" href="${path}/css/login.css">
</head>
<body>
	<div class="login-main">
		<div class="login-container-signin">
			<form action="${path}/login/signin.do" method="post" class="login-container-form">
				<h2 class="login-container-form-title">로그인</h2>
				<input type="text" name="admin_id" id="admin_id" class="login-container-form-el login-id"
					placeholder="아이디를 입력하세요." /> 
				<input type="password" name="admin_password" id="admin_password" class="login-container-form-el login-pw"
					placeholder="비밀번호를 입력하세요." />
				<div id="login-state-message"></div>
				<button class="loginPage-btn">관리자 로그인</button>
				<a href="javascript:void()" class="signup-link">관리자 회원가입</a>
			</form>
		</div>
	</div>
	<jsp:include page="/common/spinner.jsp"></jsp:include>
</body>
</html>