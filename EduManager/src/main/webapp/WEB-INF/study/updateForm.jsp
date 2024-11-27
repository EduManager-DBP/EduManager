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
		<jsp:include page="../navigation/navigation.jsp" />
		<div id="makeStudy_container">
			<form id="makeStudy_form" method="post"
				action="${pageContext.request.contextPath}/main/main">
				<!-- 나중에 다른 uri로 바꿔 줄것임. -->
				<div class="subTitle">스터디 그룹 만들기</div>
				<hr style="margin: 20px 0px">
				<section class="study">
					<span>스터디명</span><span class="required">*</span><br /> <input
						type="text" required />
				</section>
				<section class="study">
					<span>스터디 소개</span><br /> <input type="text" />
				</section>
				<section class="study" style="display: inline-block">
					<span>모집인원</span><span class="required">*</span> <br /> <input
						class="small" type="number" min="1" max="99" required />
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
					<span>정기 모임 일정</span><span class="required">*</span><br />
					<article class="schedule">
						<span>요일</span> <select class="small" name="day" required>
							<option value="월">월</option>
							<option value="화">화</option>
							<option value="수">수</option>
							<option value="목">목</option>
							<option value="금">금</option>
							<option value="토">토</option>
							<option value="일">일</option>
						</select> <span>시간</span> <input type="time" /> ~ <input type="time" />
						<button class="delete_btn" onClick="deleteSchedule(this)">삭제</button>
					</article>
					<button id="plus_btn" onClick="addSchedule()">+</button>
				</section>

				<section>
					<button id="submit">스터디 그룹 만들기</button>
				</section>
			</form>
		</div>
	</div>
</body>
</html>
