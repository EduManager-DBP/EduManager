<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EduManager</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/onboarding.css">
<script src="${pageContext.request.contextPath}/js/onboarding/age.js"
	defer></script>
</head>
<body>
	<header>
    	  <nav>
	          <a href="<c:url value='/member/login'/>" id="logo-link">
	   		 	<img src="<c:url value='/images/eduLogo.png' />" alt="Edu Logo" />
		  	  </a>
	  	  </nav>
	</header> 
	<div class="container">
		<div style="text-align: center;">
			<div class="title">연령대를 선택해주세요</div>
			<div style="color: #A6A9AF; height: 20px; margin-top: 20px;"></div>
		</div>
		<!-- 연령 선택 -->
		<div class="age">
			<button id="teenButton" class="age-button"
				onclick="selectAge('teen')">10대</button>
			<button id="twentiesButton" class="age-button"
				onclick="selectAge('twenties')">20대</button>
			<button id="thirtiesButton" class="age-button"
				onclick="selectAge('thirties')">30대</button>
			<button id="fortyPlusButton" class="age-button"
				onclick="selectAge('fortyPlus')">40대 이상</button>
		</div>

		<!-- 다음 버튼 -->
		<a href="${pageContext.request.contextPath}/onboarding/category">
			<button class="styled-button" onclick="saveAge()">다음</button>
		</a>

		<!-- 하단 바 -->
		<img src="${pageContext.request.contextPath}/images/slidebar3.png"
			alt="bar" style="margin-top: 30px; width: 50px; justify-self=center;">
	</div>
</body>
</html>
