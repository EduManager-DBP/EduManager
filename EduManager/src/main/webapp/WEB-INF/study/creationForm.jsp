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
				<div style="display: flex;">
					<section class="study" style="width: 20%;">
						<span>스터디 장소</span><br /> <input type="text" name="place" />
					</section>
					<section class="study" style="width: 20%;">
						<span>모집인원</span><span class="required">*</span> <br /> <input
							type="number" name="capacity" required min="1" max="99" />
					</section>
				</div>


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



				<!-- 스타일은 추후에 만질예정-->
				<section id="schedule" class="study" style="display: inline-block">
					<span>정기 모임 요일</span><span class="required">*</span><br />
					<article class="schedule">
							<label> <input type="checkbox" name="dayOfWeek"
								value="MONDAY"> 월
							</label> <label> <input type="checkbox" name="dayOfWeek"
								value="TUESDAY"> 화
							</label> <label> <input type="checkbox" name="dayOfWeek"
								value="WEDNESDAY"> 수
							</label> <label> <input type="checkbox" name="dayOfWeek"
								value="THURSDAY"> 목
							</label> <label> <input type="checkbox" name="dayOfWeek"
								value="FRIDAY"> 금
							</label> <label> <input type="checkbox" name="dayOfWeek"
								value="SATURDAY"> 토
							</label> <label> <input type="checkbox" name="dayOfWeek"
								value="SUNDAY"> 일
							</label>

					</article>
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
