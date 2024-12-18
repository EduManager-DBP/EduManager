<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value='/css/study_request.css' />"
	type="text/css">
<title>EduManager</title>
</head>
<body>
	<div class="page">
		<!-- 네비게이션 포함 -->
		<jsp:include page="../navigation/navigation.jsp" />

		<!-- 제목 -->
		<div class="subTitle">스터디 그룹 참여 요청</div>
		<div class="requestListContainer">
		  <c:forEach var="studyGroup" items="${requestList}">
				   <div class="requestContainer">
				<div class="requestProfileContainer">
					<img src="<c:url value='/images/profileImg.svg' />" class="requestProfile" />
					<div class="requestProfileName">${studyGroup.memberName}</div>
				</div>
				<div class="buttonContainter">
					<input type="button" id="acceptBtn" value="수락" /> <input
						type="button" id="rejectBtn" value="거절" />
				</div>
			</div>
        </c:forEach>
			

		</div>

	</div>
</body>
</html>
