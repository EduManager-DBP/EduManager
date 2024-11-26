<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EduManager</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/onboarding.css">
<script src="${pageContext.request.contextPath}/js/onboarding/role.js"
	defer></script>
</head>
<body>
	<jsp:include page="../navigation/navigation.jsp" />
	<div class="container">
		<div style="text-align: center;">
			<div class="title">역할을 선택해주세요</div>
			<div style="color: #A6A9AF; height: 20px; margin-top: 20px;">
				역할에 맞는 페이지를 제공합니다.</div>
		</div>
		<!-- 성별 선택 -->
		<div class="role">
			<button id="teacherButton" class="role-button"
				onclick="selectRole('TEACHER')">강사</button>
			<button id="studentButton" class="role-button"
				onclick="selectRole('STUDENT')">학생</button>
		</div>

		<!-- 다음 버튼 -->
		<a href="${pageContext.request.contextPath}/onboarding/gender">
			<button class="styled-button" onclick="saveRole()">다음</button>
		</a>

		<!-- 하단 바 -->
		<img src="${pageContext.request.contextPath}/images/slidebar2.png"
			alt="bar" style="margin-top: 30px; width: 50px">
	</div>
</body>
</html>