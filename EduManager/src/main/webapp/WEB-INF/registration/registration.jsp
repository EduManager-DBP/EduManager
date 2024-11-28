<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value='/css/registration.css' />"
	type="text/css">
<title>EduManager</title>
</head>
<script src="<c:url value='/js/registration.js' />"></script>
<body>
	<div class="page">
		<!-- 네비게이션 포함 -->
		<jsp:include page="../navigation/navigation.jsp" />

		<!-- 제목 -->
		<div class="subTitle">강의/스터디 신청하기</div>
		<div>
			<div class="search">
				<input type="text" placeholder="검색어 입력"> <img
					src="<c:url value='/images/searchIcon.svg"' />">
			</div>
		</div>

		<div id="tabBtn-container">
			<div class="tab-container">
				<div class="tabs on " onclick="openTab('Tab1')">
					<div>
						<img src="<c:url value='/images/class.svg"' />" id="tab1Icon">
					</div>
					<div>강의</div>
				</div>
				<div class="tabs" onclick="openTab('Tab2')">
					<div>
						<img src="<c:url value='/images/studyIcon.svg"' />" id="tab2Icon">
					</div>
					<div>스터디</div>
				</div>
			</div>
			<div id="makeStudyBtn-container">
				<button id="makeStudyBtn" onclick="">
					<img src="<c:url value='/images/plus.svg"' />" id="plusIcon">
					스터디 만들기
				</button>
			</div>
		</div>
		<div class="hr-wrapper">
			<hr id="registration_mainHr">
			<hr id="registration_hr1">
			<hr id="registration_hr2">
		</div>
		<div class="tab_wrap">
			<div id="Tab1" class="tab on">
				<div id="leaderRoom1" class="class">

					<div class="groupGallery">
						<img src="<c:url value='/images/white.png"' />">
						<div class="groupGalleryTitle">이름</div>
						<div class="groupGalleryCategory">카테고리</div>

					</div>
				</div>

			</div>
			<div id="Tab2" class="tab">
				<div id="studyRoom1" class="studyGroup">
					<div class="groupGallery">
						<img src="<c:url value='/images/white.png"' />">
						<div class="groupGalleryTitle">이름</div>
						<div class="groupGalleryCategory">카테고리</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
