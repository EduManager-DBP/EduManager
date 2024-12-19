<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/study_make.css" />
<title>EduManager</title>
<script src="${pageContext.request.contextPath}/js/study_make.js"></script>
<!-- 수정해야하는 부분 -->
</head>
<body>
	<div class="page">
		<jsp:include page="../navigation/navigation.jsp" />
		<div id="makeStudy_container">
			<form id="makeStudy_form" method="post"
				action="${pageContext.request.contextPath}/study/create">
				<!-- 나중에 다른 uri로 바꿔 줄것임. -->
				<div class="subTitle">스터디 그룹 만들기</div>
				<hr style="margin: 20px 0px">
				<section class="study">
					<span>스터디명</span><span class="required">*</span><br /> <input
						type="text" name="name" required />
				</section>

				<!-- 강의 이미지 (임시 값 추가) -->
				<input type="hidden" name="img" />

				<!-- 강의 Id-->
				<input type="hidden" name="lectureId" />

				<section class="study">
					<span>스터디 소개</span><br /> <input type="text" name="description" />
				</section>
				<section class="study" style="width: 15%;">
					<span>모집인원</span><span class="required">*</span> <br /> <input
						type="number" name="capacity" required min="1" max="99" />
				</section>



				<section class="study">
					<span>카테고리</span><br />
					<button type="button" class="category" data-index="1">영어</button>
					<button type="button" class="category" data-index="2">수학</button>
					<button type="button" class="category" data-index="3">과학</button>
					<button type="button" class="category" data-index="4">역사</button>
					<button type="button" class="category" data-index="5">프로그래밍</button>
					<button type="button" class="category" data-index="6">영어</button>
					<button type="button" class="category" data-index="7">수학</button>
					<button type="button" class="category" data-index="8">과학</button>
					<button type="button" class="category" data-index="9">역사</button>
					<button type="button" class="category" data-index="10">프로그래밍</button>
					<input type="hidden" name="category" id="categories" value="" />
				</section>


				<!-- 정기 수업 일정은 일단 요청 따로 처리 -->
				<section id="schedule" class="study" style="display: inline-block">
					<span>정기 모임 일정</span><span class="required">*</span><br />
					<article class="schedule">
						<span>요일</span> <select class="small" name="schedule[0][day]" required>
							<option value="MONDAY">월</option>
							<option value="TUESDAY">화</option>
							<option value="WEDNESDAY">수</option>
							<option value="THURSDAY">목</option>
							<option value="FRIDAY">금</option>
							<option value="SATURDAY">토</option>
							<option value="SUNDAY">일</option>
						</select> <span>시간</span> <input type="time" name="schedule[0][startTime]"/> ~ <input type="time" name="schedule[0][endTime]"/>
						<button type="button" class="delete_btn"
							onClick="deleteSchedule(this)">삭제</button>
					</article>
					<button type="button" id="plus_btn" onClick="addSchedule()">+</button>
				</section>


				<section>
					<button id="submit">스터디 그룹 만들기</button>
				</section>
				<input id="scheduleCountInput" type="hidden" value="1" name="scheduleCount">
				<!-- 일정의 개수 -->
			</form>
		</div>
	</div>
</body>
</html>
