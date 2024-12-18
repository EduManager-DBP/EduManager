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
					<div class="overViewInfoText" id="lectureTeacherName"> ${teacherName} 강사님</div>
					<div class="overViewInfoText" id="lectureTeacherPhone">
						<img src="<c:url value='/images/phoneIcon.svg"' />"
							class="infoIcon" />${teacherPhone}
					</div>
					<div class="overViewInfoText" id="lectureTeacherRoom">
						<img src="<c:url value='/images/roomIcon.svg"' />"
							class="infoIcon" />${lectureroom}호
					</div>
				</div>
			</div>
			<div class="section2">
				<div id="lectureOverviewTitle">${lectureName}</div>
				<div id="lectureOverviewDescription">${description}</div>
					<div class="section3">
					<div class="likeButtonContainer">
						<form action="<c:url value='/lecture/like' />" method="post"
							id="likeForm">
							<input type="hidden" name="lectureId" value="${lectureId}" /> 
							<input type="hidden" name="memberId" value="${userId}" />
							<c:choose>
								<c:when test="${isLiked}">
									<img src="<c:url value='/images/likeButton.svg' />"
										class="likeButton"
										onclick="document.getElementById('likeForm').submit();"
										style="cursor: pointer;" />
								</c:when>
								<c:otherwise>
									<img src="<c:url value='/images/EmptylikeButton.svg' />"
										class="emptyLikeButton"
										onclick="document.getElementById('likeForm').submit();"
										style="cursor: pointer;" />
								</c:otherwise>
							</c:choose>
						</form>
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
			<div class="writeReviewContainer">
				<textarea class="reviewTextArea"></textarea>
				<input type="submit" class="reviewSubmit" value="작성"/>

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
</body>
</html>
