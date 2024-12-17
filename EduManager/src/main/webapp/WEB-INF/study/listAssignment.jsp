<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.domain.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>과제 리스트</title>
<link rel="stylesheet" href="<c:url value='/css/listAssignment.css' />"
	type="text/css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Pretendard:wght@400;600;900&amp;display=swap" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&amp;display=swap" />
</head>
<body>
	<!-- Navigation Bar -->
	<div style="width: 90%; justify-self: center;"><jsp:include
			page="../navigation/navigation.jsp" /></div>


	<!-- Main Container -->
	<div class="main-container">
		<h2 class="page-title">과제 리스트</h2>

		<!-- 검색창 -->
		<div class="search-container">
			<form action="/study/listAssignment" method="GET">
				<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요"
					class="search-input" />
				<button type="submit" class="search-button">검색</button>
			</form>
		</div>

		<!-- 과제 리스트 -->
		<table class="assignment-table">
			<thead>
				<tr>
					<th class="table-header">제목</th>
					<th class="table-header">올린 사람</th>
					<th class="table-header">등록일</th>
					<th class="table-header">조회수</th>
				</tr>
			</thead>
			<tbody>
				<!-- JSTL 반복문으로 리스트 출력 -->
				<c:forEach var="assignment" items="${assignmentList}">
					<tr class="assignment-row">
						<td class="assignment-title"><a
							href="<c:url value='/study/assignmentDetail?id=${assignment.id}' />">${assignment.title}</a>
						</td>
						<td class="assignment-writer">${assignment.writer}</td>
						<td class="assignment-date">${assignment.date}</td>
						<td class="assignment-views">${assignment.views}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
