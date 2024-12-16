<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.domain.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel=stylesheet href="<c:url value='/css/study_details.css' />"
	type="text/css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Pretendard:wght@400;600;900&display=swap" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" />
</head>
<body>
	<div class="main-container">
		<jsp:include page="../navigation/navigation.jsp" />
		<span class="inform">
			<section class="study-detail">
				<h2 class="study-title">스터디 상세보기</h2>
				<div class="study-info-box"></div>
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
				<div class="study-location">
					<div class="location-icon"></div>
					<span>301호</span>
				</div>
				<div class="study-time">
					<div class="time-icon"></div>
					<span>수요일 6시 반</span>
				</div>
			</section>

		</span> 
		<span class="mainInform">
			<div class="title">단기간 토익 점수 상승을 위한 스터디</div>
			<table>
				<div id="calendarHeader">
					<span class="month"> <img
						src="<c:url value='/images/previousMonth.svg' />"
						id="previousMonthIcon" /> <span>11</span> <img
						src="<c:url value='/images/nextMonth.svg'  />" id="nextMonthIcon" />
					</span> <span class="year">2024</span>
				</div>
				<thead>
					<th class="sunday">일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토</th>
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
      <div class="rectangle"></div>
      <div class="schedule">
        <span class="schedule-1">일정 </span
        ><span class="emergency-rescue-operation"
          >비상비상 발등튀김 구출작전</span
        >
        <div class="add-button"></div>
      </div>
      <div class="notice">
        <span class="notice-item">공지 사항</span
        ><span class="important-notice">아주 중요한 공지</span>
        <div class="add-button-2"></div>
      </div>
      <div class="assignment">
        <span class="assignment-3">과제</span
        ><span class="toeic-grammar">토익 필수 영문법 23~36p</span
        ><span class="toeic-vocabulary">토익 필수 영단어 Day7~9 암기</span>
        <div class="add-button-4">
          <div class="basil-plus-solid"></div>
          <div class="rectangle-5"></div>
        </div>
      </div>
    </div>
			<div class="flex-row">
				<div class="rectangle-6c">
					<div class="flex-column-fc">
						<span class="announcement">공지사항</span><span
							class="very-important-notice">아주아주아주아주아주아주 중요한 공지</span><span
							class="very-important-notice-6d">아주아주아주아주아주아주 중요한 공지</span>
					</div>
					<div class="flex-column-df">
						<div class="ant-design-notification-outlined"></div>
						<div class="mdi-dot"></div>
						<div class="mdi-dot-6e"></div>
					</div>
				</div>
				<span class="see-more">더보기</span><span class="text-58">3시간 전</span><span
					class="text-59">3시간 전</span>
			</div>
			<div class="flex-row-ec">
				<div class="rectangle-6f">
					<div class="flex-column-def">
						<span class="assignment-70">과제</span><span
							class="toeic-grammar-page-23-36-71">토익 필수 영문법 23~36p</span><span
							class="toeic-vocabulary-day-7-9-72">토익 필수 영단어 Day7~9 암기</span><span
							class="mock-test-wrong-answer-note">제 n회 모의고사 오답노트</span>
					</div>
					<div class="flex-column">
						<div class="tabler-book"></div>
						<div class="mdi-dot-73"></div>
						<div class="mdi-dot-74"></div>
						<div class="mdi-dot-75"></div>
					</div>
				</div>
				<span class="see-more-76">더보기</span><span class="d-day">D-Day</span><span
					class="d-day-77">D-Day</span><span class="d-3">D-3</span>
			</div>
		</span>
	</div>
</body>
</html>
