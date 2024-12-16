<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.domain.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="<c:url value='/css/study_details.css' />"
	type="text/css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Pretendard:wght@400;600;900&amp;display=swap" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&amp;display=swap" />
</head>
<body>
	<div><jsp:include page="../navigation/navigation.jsp" /></div>
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
					<td class="time-inform">수요일 6시 반</td>
				</tr>
			</table>
			<div class="team-members-box">
				<div class="team-header">
					<div class="team-icon"></div>
					<span class="team-count">팀원들 (6/10)</span>
				</div>
				<ul class="member-list">
					<li class="member-item">
						<div class="member-icon"></div> <span class="member-name">조은향</span>
					</li>
					<li class="member-item">
						<div class="member-icon"></div> <span class="member-name">김희선</span>
					</li>
					<li class="member-item">
						<div class="member-icon"></div> <span class="member-name">손다현</span>
					</li>
					<li class="member-item">
						<div class="member-icon"></div> <span class="member-name">김지은</span>
					</li>
					<li class="member-item">
						<div class="member-icon"></div> <span class="member-name">김솜솜</span>
					</li>
					<li class="member-item">
						<div class="member-icon"></div> <span class="member-name">양갱이</span>
					</li>
				</ul>
			</div>
		</div>

		<div class="mainInform">
			<div class="title">단기간 토익 점수 상승을 위한 스터디</div>
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
					<th class="sunday">일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토 </th>
				</thead>
				<tbody>
					<tr>
						<td class="previousMonth">31</td>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
						<td>5</td>
						<td>6</td>
					</tr>
					<tr>
						<td class="sunday">7</td>
						<td>8</td>
						<td>9</td>
						<td id="today">10</td>
						<td>11</td>
						<td>12</td>
						<td>13</td>
					</tr>
					<tr>
						<td class="sunday">14</td>
						<td>15</td>
						<td>16</td>
						<td>17</td>
						<td>18</td>
						<td>19</td>
						<td>20</td>
					</tr>
					<tr>
						<td class="sunday">21</td>
						<td>22</td>
						<td>23</td>
						<td>24</td>
						<td>25</td>
						<td>26</td>
						<td>27</td>
					</tr>
					<tr>
						<td class="sunday">28</td>
						<td>29</td>
						<td>30</td>
						<td>31</td>
						<td class="nextMonth">1</td>
						<td class="nextMonth">2</td>
						<td class="nextMonth">3</td>
					</tr>
				</tbody>
			</table>
			<div class="main-container">
				<div class="rectangle-1">
					<div class="schedule">
						<div class="schedule_title">일정</div>
						<div class="schedule_content">
							<li>content</li>
						</div>
					</div>
					<div class="notice">
						<div class="notice_title">공지 사항</div>
						<div class="notice_content">
							<li>content</li>
						</div>
					</div>
					<div class="assignment">
						<div class="assignment_title">과제</div>
						<div class="assignment_content">
							<li>content</li>
						</div>
						<div class="assignment_content2">
							<li>content</li>
						</div>
					</div>
					<div class="schedule-add-button">
						<img src="<c:url value='/images/addNotification.png' />"
							alt="추가 버튼" class="button-image">
					</div>
					<div class="notice-add-button">
						<img src="<c:url value='/images/addNotification.png' />"
							alt="추가 버튼" class="button-image">
					</div>
					<div class="assignment-add-button">
						<img src="<c:url value='/images/addNotification.png' />"
							alt="추가 버튼" class="button-image">
					</div>
				</div>
			</div>
			<div class="rectangle">
				<div class="flex-column-fc">
					<div class="flex-column">
						<div class="notice_main">공지사항</div>
						<div class="more-link">더보기</div>
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
						<div class="more-link">더보기</div>
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
