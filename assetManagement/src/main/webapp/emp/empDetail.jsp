<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 상세 정보</title>
</head>
<body>
	<div id="change-List-contents">
		<table class="table table-hover" border="1">
			<thead>
				<tr class="table-list">
					<th class="col0">직원ID</th>
					<th class="col1">성</th>
					<th class="col2">이름</th>
					<th class="col3">이메일</th>
					<th class="col4">전화번호</th>
					<th class="col5">입사일</th>
					<th class="col6">직급</th>
					<th class="col7">연봉</th>
					<th class="col8">팀</th>
					<th class="col9">파트</th>
					<th class="col10">직책</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empInfo}" var="emp" varStatus="status">
					<tr>
						<td class="col0">${emp.employeeId}</td>
						<td class="col1">${emp.firstName}</td>
						<td class="col2">${emp.lastName}</td>
						<td class="col3">${emp.email}</td>
						<td class="col4">${emp.phoneNumber}</td>
						<td class="col5">${emp.hireDate}</td>
						<td class="col6">${emp.jobs.getJobTitle()}</td>
						<td class="col6">${emp.salary}</td>
						<td class="col6">${emp.subpart.getDept().getDepartmentName()}</td>
						<td class="col6">${emp.subpart.getPartName()}</td>
						<td class="col6">${emp.position.getPositionTitle()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>