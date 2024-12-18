<%@page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="java.util.*, model.domain.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// 현재 연도와 월 가져오기
java.util.Calendar calendar = java.util.Calendar.getInstance();
int currentYear = calendar.get(java.util.Calendar.YEAR);
int currentMonth = calendar.get(java.util.Calendar.MONTH); // 0부터 시작 (0 = 1월)

// 이전/다음 달 이동 시 파라미터 처리
String yearParam = request.getParameter("year");
String monthParam = request.getParameter("month");
if (yearParam != null && monthParam != null) {
	currentYear = Integer.parseInt(yearParam);
	currentMonth = Integer.parseInt(monthParam) - 1; // 0부터 시작하는 월로 변환
}

// 해당 월의 총 일수와 시작 요일 계산
calendar.set(currentYear, currentMonth, 1);
int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
int firstDayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />"
	type="text/css">
<script>
	// 이전/다음 달 이동 함수
	function changeMonth(offset) {
		const currentYear = parseInt(document.getElementById("currentYear").value);
		const currentMonth = parseInt(document.getElementById("currentMonth").value);
		let newYear = currentYear;
		let newMonth = currentMonth + offset;

		if (newMonth < 0) { // 이전 년도로 이동
			newMonth = 11;
			newYear--;
		} else if (newMonth > 11) { // 다음 년도로 이동
			newMonth = 0;
			newYear++;
		}

		// 새로운 URL로 이동
		window.location.href = `/main/main?year=${newYear}&month=${newMonth + 1}`;
	}
</script>
<title>EduManager</title>
</head>
<body>
	<div class="page">
		<jsp:include page="../navigation/navigation.jsp" />
		<div id="body">
			<div id="schedule">
				<div id="todaySchedule">
					<div class="ScheduleText today">Today Schedule</div>
					<ul class="todaySchedule-list">
						<li class="todaySchedules list1">강의명 14:00 ~ 16:00</li>
						<li class="todaySchedules list2">강의 명 18:00 ~ 20:00</li>
					</ul>
				</div>
				<div id="assignment">
					<div class="ScheduleText assignment">Assignment</div>

					<ul class="assignment-list">
						<li class="assignments list1">영단어 암기 Day20~23</li>
						<li class="assignments list2">SQL 30강 문제풀기</li>
					</ul>
				</div>
			</div>
			<div id="calendar">
				<div id="calendarHeader">
					<!-- 현재 연도와 월을 숨겨서 JavaScript에서 사용 -->
					<input type="hidden" id="currentYear" value="<%=currentYear%>" />
					<input type="hidden" id="currentMonth" value="<%=currentMonth%>" />
					<img src="<c:url value='/images/previousMonth.svg' />"
						id="previousMonthIcon" onclick="changeMonth(-1)" /> <span
						class="month"><%=currentMonth + 1%>월</span> <img
						src="<c:url value='/images/nextMonth.svg' />" id="nextMonthIcon"
						onclick="changeMonth(1)" /> <span class="year"><%=currentYear%>년</span>
				</div>
				<table>
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
					<tbody>
						<%
						int day = 1;
						boolean started = false;
						for (int i = 0; i < 6; i++) { // 최대 6줄 (달력 한 페이지 기준)
							out.println("<tr>");
							for (int j = 1; j <= 7; j++) { // 한 주의 7일
								if (!started && j == firstDayOfWeek) {
							started = true; // 달의 첫 시작점
								}
								if (started && day <= daysInMonth) {
							out.println("<td>" + day + "</td>");
							day++;
								} else {
							out.println("<td></td>");
								}
							}
							out.println("</tr>");
							if (day > daysInMonth)
								break; // 모든 날짜 출력 완료
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
