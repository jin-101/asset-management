<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<button onclick="location.href='${path}/login/menu.do'">뒤로가기</button>
		 <div>장비관련 선택화면 토글만들기</div>
	</header>
 	<main>
        <div id="tables">
            <table class="table table-hover" border="1">
                <thead>
                    <tr class="list">
                        <th class="col0">직원번호</th>
                        <th class="col1">이름</th>
                        <th class="col2">성</th>
                        <th class="col3">이메일</th>
                        <th class="col4">전화번호</th>
                        <th class="col5">입사일</th>
                        <th class="col6">직급코드</th>
                        <th class="col7">급여</th>
                        <th class="col8">파트 번호</th>
                        <th class="col9">팀 번호</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${empAll}" var="emp" varStatus="status">
	                    <tr class="items">
	                        <td class="col0">${emp.employee_id}</td>
	                        <td class="col1">${emp.first_name}</td>
	                        <td class="col2">${emp.last_name}</td>
	                        <td class="col3">${emp.email}</td>
	                        <td class="col4">${emp.phone_number}</td>
	                        <td class="col5">${emp.hire_date}</td>
	                        <td class="col6">${emp.jobs_JOB_ID}</td>
	                        <td class="col7">${emp.salary}</td>
	                        <td class="col8">${emp.subpart_PART_NO}</td>
	                        <td class="col9"> ${emp.position_POSITION_ID}</td>
	                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
</main> 
</body>
</html>