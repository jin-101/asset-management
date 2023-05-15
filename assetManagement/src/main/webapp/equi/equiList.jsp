<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/common.jsp"></jsp:include>
<link rel="stylesheet" href="${path}/css/equiList.css">
<script defer src="${path}/js/equiList.js" ></script>
</head>
<body>
<header>
	<div class="container">
		<div class="container-btn">
			<div class="content content-back-btn">
				<button class="btn btn-primary" onclick="location.href='${path}/login/menu.do'">뒤로가기</button>
			</div>
			<div class="content content-logout-btn">
				<button class="btn btn-primary" onclick="">로그아웃</button>
			</div>
		</div>
		<div class="toggle-container">
			<div class="toggle rentPossible-eq">
				<div class="toggle-Title">대여가능조회</div>
				<div class="toggle-list hidden">
	        		<div class="list-item">
	        			<button id="list-btn1" class="list-all list-btn" type="button" data-btnType="rentalBtn">대여가능장비 전체조회</button>
	        		</div>
	        		<div class="list-item">
	        			<button id="list-btn2" class="list-search list-btn" type="button" data-name="type_name" data-selector-title="장비유형"  data-btnType="rentalBtn">유형별 대여가능 장비조회</button>
 	       			</div>
 	       			<div class="list-item">
	        			<button id="list-btn3" class="list-search list-btn" type="button" data-name="model" data-selector-title="모델명"  data-btnType="rentalBtn">모델별 대여가능 장비조회</button>
 	       			</div>
        		 </div>
			</div>
			<div class="toggle using-eq">
				<div class="toggle-Title">사용장비조회</div>
				<div class="toggle-list hidden">
	        		<div class="list-item">
	        			<button id="list-btn4" class="list-all list-btn" type="button" data-btnType="returnBtn">사용중인장비 전체조회</button>
	        		</div>
	        		<div class="list-item">
	        			<button id="list-btn5" class="list-search list-btn" type="button" data-btnType="returnBtn">사용자별 사용중인 장비조회</button>
 	       			</div>
 	       			<div class="list-item">
	        			<button id="list-btn6" class="list-search list-btn" type="button" data-btnType="returnBtn">장비ID별 현재 사용자 조회</button>
 	       			</div>
        		 </div>
			</div>
			<div class="toggle using-eq">
				<div class="toggle-Title">장비내역</div>
				<div class="toggle-list hidden">
	        		<div class="list-item">
	        			<button id="list-btn7" class="list-all list-btn" type="button">신규장비등록</button>
	        		</div>
	        		<div class="list-item">
	        			<button id="list-btn8" class="list-search list-btn" type="button">기존장비삭제</button>
 	       			</div>
        		 </div>
			</div>
		</div>
	</div>
</header>
<main>
    <div class="container main-container">
		<h2 id="change-List-title">전체장비 조회</h2>
		<div id="change-List-contents">
			<table class="table table-hover" border=1>
            <thead>
                <tr class="table-list">
                	<th class="col0">장비번호</th>
                    <th class="col1">유형번호</th>
                    <th class="col2">제조회사번호</th>
                    <th class="col3">모델명</th>
                    <th class="col4">시리얼번호</th>
                    <th class="col5">구매일</th>
                    <th class="col6">가격(만원)</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${eqAll}" var="equipment" varStatus="status">
                 <tr class="eq-items" data-id="${equipment.equipmentId}">
                 	<th class="col0">${equipment.equipmentId}</th>
                     <td class="col1">${equipment.equiType.getTypeId()}</td>
                     <td class="col2">${equipment.equiCompany.getCoId()}</td>
                     <td class="col3">${equipment.model}</td>
                     <td class="col4">${equipment.serialNo}</td>
                     <td class="col5">${equipment.purchaseDate}</td>
                     <td class="col6">${equipment.price}</td>
                  </tr>
                 </c:forEach>
             </tbody>
       	</table>
		</div>
   		
     </div>
</main>
 <jsp:include page="/common/spinner.jsp"></jsp:include>
</body>
</html>