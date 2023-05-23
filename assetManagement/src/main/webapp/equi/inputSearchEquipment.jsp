<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장비 id로 검색</title>
<link rel="stylesheet" href="${path}/css/selectorOptionContainer.css">
<script defer src="${path}/js/inputSearchEquipment.js"></script>
</head>
<body>
	<div id="change-List-contents">
		<div id="selector-search-header">
			<div id="div-select" class="selector-search-left">
				<label id="selector-name">장비 ID : </label>
				<input type="number" id="eq-id" min="1" max="${maxSize}"/>
			</div>
		    <div class="selector-search-right">
		    	<button class="search-btn btn btn-primary">검색</button>
		    </div>
		</div>
	    <div id="input-search-content"></div>
	</div>
</body>
</html>