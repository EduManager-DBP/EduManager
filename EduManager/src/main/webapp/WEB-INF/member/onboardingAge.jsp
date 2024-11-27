<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EduManager</title>
<link rel="stylesheet" href="<c:url value='/css/onboarding.css'/>">
<script src="<c:url value='/js/onboarding/age.js'/>"></script>

</head>
<body>
	<header>
    	  <nav>
	          <a href="<c:url value='/member/login'/>" id="logo-link">
	   		 	<img src="<c:url value='/images/eduLogo.png' />" alt="Edu Logo" />
		  	  </a>
	  	  </nav>
	</header> 
		<!-- 연령 선택 -->
		<!-- action은 임시로 해놓은거라서 변경하면 됩니다. -->
		<form id="ageForm" class="container" method="POST" action="<c:url value='/onboarding/category'/>">
			<div style="text-align: center;height:100px">
			<div class="title">연령대를 선택해주세요</div>
			<div style="color: #A6A9AF; height: 20px; margin-top: 20px;"></div>
		</div>
			<input type="hidden" id="ageInput" name="age" value="" /> <!-- 선택된 연령대를 저장 -->

			<div class="age">
				<button type="button" id="teenButton" class="age-button"
					onclick="selectAge('teen')">10대</button>
				<button type="button" id="twentiesButton" class="age-button"
					onclick="selectAge('twenties')">20대</button>
				<button type="button" id="thirtiesButton" class="age-button"
					onclick="selectAge('thirties')">30대</button>
				<button type="button" id="fortyPlusButton" class="age-button"
					onclick="selectAge('fortyPlus')">40대 이상</button>
			</div>

			<!-- 다음 버튼 -->
			<button type="button" class="styled-button" onclick="submitAge()">다음</button>
		</form>


<%-- 		<!-- 하단 바 -->
		<img src="${pageContext.request.contextPath}/images/slidebar3.png"
			alt="bar" style="margin-top: 30px; width: 50px; justify-self=center;"> --%>
<!-- 	</div> -->

</body>
</html>
