<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/study_make.css" />
<title>EduManager</title>
<script src="${pageContext.request.contextPath}/js/updateLecture.js"></script>
<script>
	// 서버에서 전달된 category 값을 전역 변수로 정의
	const selectedCategory = "${study.category}";
</script>
<!-- 수정해야하는 부분 -->
</head>
<body>
	<div class="page">
		<jsp:include page="../navigation/navigation.jsp" />
		<div id="makeStudy_container">
			<form id="makeStudy_form" method="post"
				action="${pageContext.request.contextPath}/study/update">
				<div class="subTitle">스터디 그룹 정보 수정하기</div>
				<hr style="margin: 20px 0px">
				<section class="study">
					<span>스터디명</span><span class="required">*</span><br /> <input
						type="text" name="name" value="${study.name}" required />
				</section>

				<!-- 스터디 이미지 (임시 값 추가) -->
				<input type="hidden" name="img" value="${study.img}" />

				<!-- 스터디 Id-->
				<input type="hidden" name="studyId" value="${study.studyGroupId}" />

				<section class="study">
					<span>스터디 소개</span><br /> <input type="text" name="description"
						value="${study.description}" />
				</section>
				<section class="study" style="width: 15%;">
					<span>모집인원</span><span class="required">*</span> <br /> <input
						type="number" name="capacity" required min="1" max="99" value="${study.capacity}"/>
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
					<c:forEach var="schedule" items="${scheduleList}"
						varStatus="status">
						<article class="schedule">
							<span>요일</span> <select class="small"
								name="schedule[${status.index}][day]" required>
								<option value="월" ${schedule.dayOfWeek == '월' ? 'selected' : ''}>월</option>
								<option value="화" ${schedule.dayOfWeek == '화' ? 'selected' : ''}>화</option>
								<option value="수" ${schedule.dayOfWeek == '수' ? 'selected' : ''}>수</option>
								<option value="목" ${schedule.dayOfWeek == '목' ? 'selected' : ''}>목</option>
								<option value="금" ${schedule.dayOfWeek == '금' ? 'selected' : ''}>금</option>
								<option value="토" ${schedule.dayOfWeek == '토' ? 'selected' : ''}>토</option>
								<option value="일" ${schedule.dayOfWeek == '일' ? 'selected' : ''}>일</option>
							</select> <span>시간</span> <input type="time"
								name="schedule[${status.index}][startTime]"
								value="${schedule.startTime}" required/> ~ <input type="time"
								name="schedule[${status.index}][endTime]"
								value="${schedule.endTime}" required />
							<button type="button" class="delete_btn"
								onClick="deleteSchedule(this)">삭제</button>
							<input id="scheduleId"  type="hidden"
								value="${schedule.scheduleId}" name="schedule[${status.index}][scheduleId]">
						</article>
					</c:forEach>
					<button type="button" id="plus_btn" onClick="addSchedule()">+</button>
				</section>

				<section>
					<input id="scheduleCountInput" type="hidden"
						value="${scheduleCount}" name="scheduleCount">

					<button id="submit">스터디 그룹 정보 수정하기</button>
				</section>
			</form>
		</div>
	</div>
</body>
</html>
