<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EduManager</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/onboarding.css">
<script src="${pageContext.request.contextPath}/js/onboarding/category.js"
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
			<div class="title">관심있는 분야를 모두 선택해주세요</div>
			<div style="color: #A6A9AF; height: 20px; margin-top: 20px;">
				관심있는 분야를 <span style="color: #616161; font-weight: bold">3가지</span>
				이하로 선택해주세요 <br /> 당신에게 맞는 강의/스터디를 추천해 드릴게요
			</div>
		</div>
		<!-- 분야 선택 -->
		<section id="category">
			<div class="category">
				<button id="category1" class="category-button"
					onclick="selectInterestCategory('1')">토익</button>
				<button id="category2" class="category-button"
					onclick="selectInterestCategory('2')">토플</button>
				<button id="category3" class="category-button"
					onclick="selectInterestCategory('3')">수능</button>
				<button id="category4" class="category-button"
					onclick="selectInterestCategory('4')">취업</button>
				<button id="category5" class="category-button"
					onclick="selectInterestCategory('5')">공무원</button>
				<button id="category6" class="category-button"
					onclick="selectInterestCategory('6')">자격증</button>
				<button id="category7" class="category-button"
					onclick="selectInterestCategory('7')">IT</button>
				<button id="category8" class="category-button"
					onclick="selectInterestCategory('8')">외국어</button>
				<button id="category9" class="category-button"
					onclick="selectInterestCategory('9')">자기계발</button>
				<button id="category10" class="category-button"
					onclick="selectInterestCategory('10')">기타</button>

			</div>
		</section>


		<!-- 회원가입 완료 -->
		<a href="${pageContext.request.contextPath}/main/main">
			<button class="styled-button" onclick="saveCategory()">에듀매니저
				시작하기</button>
		</a>

		<!-- 하단 바 -->
		<img src="${pageContext.request.contextPath}/images/slidebar4.png"
			alt="bar" style="margin-top: 30px; width: 50px">
	</div>
</body>
</html>