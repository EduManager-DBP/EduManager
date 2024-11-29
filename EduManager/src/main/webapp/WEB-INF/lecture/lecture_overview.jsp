<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="<c:url value='/css/lecture_overview.css' />" type="text/css">
<title>EduManager</title>
</head>
<body>
	<div class="page">
		<!-- 네비게이션 포함 -->
		<jsp:include page="../navigation/navigation.jsp" />

		<!-- 제목 -->
		<div class="subTitle">강의 소개</div>
		<div class="sectionContainer">
			<div class="section1">
				<div>
					<img src="<c:url value='/images/white.png"' />"
						id="lectureOverviewImg">
				</div>
				<div class="overViewInfo">
					<div class="overViewInfoText" id="lectureTeacherName">000 강사님</div>
					<div class="overViewInfoText" id="lectureTeacherPhone">
						<img src="<c:url value='/images/phoneIcon.svg"' />"
							class="infoIcon" />000-0000-0000
					</div>
					<div class="overViewInfoText" id="lectureTeacherRoom">
						<img src="<c:url value='/images/roomIcon.svg"' />"
							class="infoIcon" />000호
					</div>
				</div>
			</div>
			<div class="section2">
				<div id="lectureOverviewTitle">강의명</div>
				<div id="lectureOverviewDescription">강의소개</div>

				<div class="section3">
					<div class="likeButtonContainer">
						<img src="<c:url value='/images/likeButton.svg"' />"
							class="likeButton" /> <img
							src="<c:url value='/images/EmptylikeButton.svg"' />"
							class="emptyLikeButton" />
					</div>
					<div>
						<input type="button" class="applyButton" value="수강신청하기">
					</div>
				</div>
			</div>

		</div>
		<div class="section4">
			<div class="reviewIconContainer">
				<img src="<c:url value='/images/reviewIcon.svg"' />"
					class="reviewIcon" />
				<div class="reviewIconText">수강 후기</div>
			</div>
			<div class="reviewListContainer">
				<div class="reviewContainer">
					<img src="<c:url value='/images/profileImg.svg"' />"
						class="reviewProfileImg" />
					<div class="reviewTextContainer">
						<div class="reviewUserName">OOO학생</div>
						<div class="reviewText">수강 후기</div>
					</div>
				</div>

			</div>
		</div>

	</div>
</body>
</html>
