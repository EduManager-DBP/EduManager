<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.domain.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="<c:url value='/css/study_details.css' />"
	type="text/css">
<script src="<c:url value='/js/study_calendar.js' />"></script>
<title>스터디 상세보기</title>
</head>
<body>
	<jsp:include page="../navigation/navigation.jsp" />

	<div class="study-container">
		<div class="study-detail">
			<h2 class="study-title">스터디 상세보기</h2>
			<div class="study-info-box"></div>
			<table class="study-location">
				<tr class="icon">
					<td class="location-icon"></td>
					<td class="location-inform">301호</td>
				</tr>
				<tr class="icon">
					<td class="time-icon"></td>
					<td class="location-inform">수요일 6시 반</td>
				</tr>
			</table>
			<div class="team-members-box">
				<div class="team-header">
					<div class="team-icon"></div>
					<span class="team-count">팀원들 (6/10)</span>
				</div>
				<ul class="member-list">
				<li class="member-item">
							<div class="member-icon"></div> <span class="member-name">${studyInfo.leaderName}</span>
						</li>
			<%-- 		<c:forEach var="member" items="${memberList}">
						<li class="member-item">
							<div class="member-icon"></div> <span class="member-name">${member.name}</span>
						</li>
					</c:forEach> --%>
				</ul>
			</div>
		</div>

		<div class="mainInform">
			<div class="title">${studyInfo.name}</div>
			<div id="calendarHeader">
				<span class="month"> <img
					src="<c:url value='/images/previousMonth.svg' />"
					id="previousMonthIcon" alt="" /> <span>11</span> <img
					src="<c:url value='/images/nextMonth.svg'  />" id="nextMonthIcon"
					alt="" />
				</span> <span class="year">2024</span>
			</div>
			<table class="calendarTable">
				<thead>
					<tr>
						<th class="sunday">일</th>
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th>토</th>
					</tr>
				</thead>
				<tbody></tbody>
				<!-- JavaScript에서 동적으로 채움 -->
			</table>
			<form id="dateForm" action="<c:url value='/mystudy/view' />"
				method="post">
				<input type="hidden" name="selectedDate" id="selectedDate" value="${selectedDate}">
			</form>
			<div class="main-container">
				<div class="rectangle-1">
					<div class="schedule">
						<div class="schedule_title">일정</div>
						<div class="schedule_content">
							<c:forEach var="schedule" items="${regularSchedules}">
								<li class="schedule-item">
									${schedule.title} : ${schedule.startTime}~ ${schedule.endTime}
									<!-- 다른 schedule 속성들도 필요에 따라 추가 -->
								</li>
							</c:forEach>
						</div>
					</div>
					<div class="notice">
						<div class="notice_title">공지 사항</div>
						<div class="notice_content">
							<c:forEach var="notice" items="${noticeList}">
								<li class="notice-item">
									${notice.title}
								</li>
							</c:forEach>
						</div>
					</div>
					<div class="assignment">
						<div class="assignment_title">과제</div>
						<div class="assignment_content">

							<c:forEach var="assignment" items="${assignmentList}">
								<li class="assignment-item">
									${assignment.title}
								</li>
							</c:forEach>

						</div>
					</div>
					<div class="schedule-add-button">
						<a href="<c:url value='/study/addSchedule' />"> <img
							src="<c:url value='/images/addNotification.png' />" alt="추가 버튼"
							class="button-image">
						</a>
					</div>

					<div class="notice-add-button">
						<a href="<c:url value='/study/addNotice' />"> <img
							src="<c:url value='/images/addNotification.png' />" alt="추가 버튼"
							class="button-image">
						</a>
					</div>

					<div class="assignment-add-button">
						<a href="<c:url value='/study/addAssignment' />"> <img
							src="<c:url value='/images/addNotification.png' />" alt="추가 버튼"
							class="button-image">
						</a>
					</div>
				</div>
			</div>
			<div class="rectangle">
				<div class="flex-column-fc">
					<div class="flex-column">
						<div class="notice_main">공지사항</div>
						<a href="<c:url value='/study/listNotice' />" class="more-link">더보기</a>
					</div>
					<div class="important-notice">
						<li>아주아주아주아주아주아주 중요한 공지</li>
					</div>
					<div class="important-notice">
						<li>아주아주아주아주아주아주 중요한 공지</li>
					</div>
				</div>
			</div>
			<div class="rectangle">
				<div class="flex-column-fc">
					<div class="flex-column">
						<div class="notice_main">과제</div>
						<a href="<c:url value='/study/listAssignment' />"
							class="more-link">더보기</a>
					</div>
					<div class="important-notice">
						<li>토익 필수 영문법 23~36p</li>
					</div>
					<div class="important-notice">
						<li>토익 필수 영문법 23~36p</li>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
