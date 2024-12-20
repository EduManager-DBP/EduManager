<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>공지사항 리스트</title>
<link rel=stylesheet href="<c:url value='/css/listAssignmentAndNotice.css' />"
	type="text/css">
</head>
<body>
	<div class="page">
		<jsp:include page="../navigation/navigation.jsp" />
		<div class="subTitle">과제함</div>
 
		<table class="table">
			<thead>
				<tr>
					<th class="table-header">제목</th>
					<th class="table-header">내용</th>
					<th class="table-header">마감일</th>
				</tr>
			</thead>
			<tbody>
				<!-- JSTL 반복문으로 리스트 출력 -->
				<c:forEach var="assignment" items="${lectureAssignmentList}">
					<tr class="notice-row">
						<td class="title">${assignment.title}</td>
						<td class="description">${assignment.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
