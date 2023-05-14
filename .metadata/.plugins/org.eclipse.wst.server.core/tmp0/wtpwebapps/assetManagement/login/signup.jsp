<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="/common/common.jsp"></jsp:include>
</head>
<body>
	<div class="login-main">
		<div class="login-container-comm login-container-signup">
			<form action="" method="post" class="login-container-form">
				<h2 class="login-container-form-title">회원가입</h2>
				<div id="admin-id-group">
					<input type="text" name="admin_id" class="login-form-el-input"
						placeholder="관리자 아이디" /> <input type="button"
						name="admin_id_check" id="idDupCheck"
						class="form-el-btn loginPage-btn" value="중복체크" />
				</div>
				<span id="id-check-message"></span> <input type="password"
					name="admin_password" class="login-container-form-el"
					placeholder="관리자 비밀번호" />
				<button class="loginPage-btn">관리자 등록</button>
			</form>
		</div>
	</div>
</body>
</html>