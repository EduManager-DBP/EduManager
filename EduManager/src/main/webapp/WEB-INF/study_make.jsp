<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/study_make.css" />
<title>EduManager</title>
<script src="${pageContext.request.contextPath}/js/study_make.js"></script>
</head>
<body>
	<div class="page">
		<%-- 		<header>
			<img src='${pageContext.request.contextPath}/images/eduLogo.png' />
			<nav>
				<ul>
					<li class="menu"><a href="main.html">홈</a></li>
					<li class="menu"><a href="myStudyGroups.html">강의/스터디 신청</a></li>
					<li class="menu"><a href="#">마이 페이지</a></li>
					<li class="menu"><a href="">로그아웃</a></li>
				</ul>
			</nav>
		</header> --%>
		<jsp:include page="./navigation/navigation.jsp" />
		<div id="makeStudy_container">
			<div id="makeStudy_form">
				<div class="subTitle">스터디 그룹 만들기</div>
				<hr style="margin: 20px 0px">
				<section class="study">
					<span>스터디명</span><br /> <input type="text" />
				</section>
				<section class="study">
					<span>스터디 소개</span><br /> <input type="text" />
				</section>
				<section class="study" style="display: inline-block">
					<span>모집인원</span> <br /> <input class="small" type="number"
						min="1" max="99" />
				</section>
				<section class="study" style="display: inline-block">
					<span>카테고리</span><br />
					<button class="category_select">영어</button>
					<button class="category_select">영어</button>
					<button class="category_select">영어</button>
					<button class="category_select">영어</button>
					<button class="category_select">영어</button>
					<button class="category_select">영어</button>
					<button class="category_select">영어</button>
				</section>
				<br />
				<section id="schedule" class="study" style="display: inline-block">
					<span>정기 모임 일정</span><br />
					<article class="schedule">
						<span>요일</span> <input class="small" type="text" /> <span>시간</span>
						<input type="time" /> - <input type="time" />
					</article>
					<button id="plus_btn" onClick="addSchedule()">+</button>
				</section>

				<section>
					<button id="submit">스터디 그룹 만들기</button>
				</section>
			</div>
		</div>
	</div>
</body>
</html>
