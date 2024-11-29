<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EduManager</title>
<link rel="stylesheet" href="<c:url value='/css/onboarding.css'/>">
<script src="<c:url value='/js/onboarding/category.js'/>"></script>
<%--  <input type="hidden" name="age" value="<%= request.getParameter("age") %>" />
 --%>
</head>
<body>
	<header>
		<nav>
			<a href="<c:url value='/member/login'/>" id="logo-link"> <img
				src="<c:url value='/images/eduLogo.png' />" alt="Edu Logo" />
			</a>
		</nav>
	</header>
	<div class="container">
		<!-- 분야 선택 -->
		<!-- 분야는 db에서 받아와야 할 것 같긴 함.-->
		<!-- action 링크 임시로 해놨습니다 -->
		<form id="category" id="categoryForm" method="POST"
			action="<c:url value='/student/register3'/>">
			<div style="text-align: center; height: 100px">
				<div class="title">관심있는 분야를 모두 선택해주세요</div>
				<div style="color: #A6A9AF; margin-top: 20px;">
					관심있는 분야를 <span style="color: #616161; font-weight: bold">3가지</span>
					이하로 선택해주세요 <br /> 당신에게 맞는 강의/스터디를 추천해 드릴게요
				</div>
			</div>
			<div class="category">

				<label> <input type="checkbox" name="categories" value="1" onclick="updateCategoryStyle(this)" />
					토익
				</label> 
				<label> <input type="checkbox" name="categories" value="2" onclick="updateCategoryStyle(this)"/>
					토플
				</label> 
				<label> <input type="checkbox" name="categories" value="3" onclick="updateCategoryStyle(this)"/>
					수능
				</label> 
				<label> <input type="checkbox" name="categories" value="4" onclick="updateCategoryStyle(this)"/>
					취업
				</label> 
				<label> <input type="checkbox" name="categories" value="5" onclick="updateCategoryStyle(this)"/>
					공무원
				</label> 
				<label> <input type="checkbox" name="categories" value="6" onclick="updateCategoryStyle(this)"/>
					자격증
				</label> 
				<label> <input type="checkbox" name="categories" value="7" onclick="updateCategoryStyle(this)"/>
					IT
				</label> 
				<label> <input type="checkbox" name="categories" value="8" onclick="updateCategoryStyle(this)"/>
					외국어
				</label> 
				<label> <input type="checkbox" name="categories" value="9" onclick="updateCategoryStyle(this)"/>
					자기계발
				</label> 
				<label> <input type="checkbox" name="categories" value="10" onclick="updateCategoryStyle(this)"/>
					기타
				</label>
			</div>
			<input type="hidden" name="age"
				value="<%=request.getParameter("age")%>" />
			<button type="submit" class="styled-button">에듀매니저 시작하기</button>
		</form>

		<%-- <!-- 회원가입 완료 -->
		<a href="${pageContext.request.contextPath}/main/main">
			<button class="styled-button" onclick="saveCategory()">에듀매니저
				시작하기</button>
		</a> --%>

		<!-- 하단 바 -->
		<img src="<c:url value='/images/slidebar1.png'/>" alt="bar" style="margin-top: 30px; width: 50px">

	</div>
</body>
</html>