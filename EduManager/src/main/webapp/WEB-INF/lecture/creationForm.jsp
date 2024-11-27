<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/study_make.css" />
<title>EduManager</title>
<script src="${pageContext.request.contextPath}/js/study_make.js">
function selectLectureCategory(button) {
    const hiddenInput = document.getElementById('categories');
    let selectedCategories = hiddenInput.value ? hiddenInput.value.split(',') : [];
    const index = button.getAttribute('data-index');

    // 선택된 번호가 이미 있다면 제거, 없으면 추가
    if (selectedCategories.includes(index)) {
        selectedCategories = selectedCategories.filter(item => item !== index);
        button.classList.remove('selected'); // 선택 표시 제거
    } else {
        selectedCategories.push(index);
        button.classList.add('selected'); // 선택 표시 추가
    }

    // 숨겨진 input의 value 업데이트
    hiddenInput.value = selectedCategories.join(',');
}
</script>
<!-- 수정해야하는 부분 -->
</head>
<body>
	<div class="page">
		<jsp:include page="../navigation/navigation.jsp" />
		<div id="makeStudy_container">
			<form id="makeStudy_form" method="post"
				action="${pageContext.request.contextPath}/main/main">
				<!-- 나중에 다른 uri로 바꿔 줄것임. -->
				<div class="subTitle">강의 만들기</div>
				<hr style="margin: 20px 0px">
				<section class="study">
					<span>강의명</span><span class="required">*</span><br /> <input
						type="text" required />
				</section>
				<section class="study">
					<span>강의 소개</span><br /> <input type="text" />
				</section>
				<section class="study" style="display: inline-block; width: 40%;">
					<span>강사명</span><span class="required">*</span><br /> <input
						type="text" required />
				</section>
				<section class="study" style="display: inline-block; width: 40%;">
					<span>모집인원</span><span class="required">*</span> <br /> <input
						type="number" required min="1" max="99"
						style="padding-left: 15px; width: 100%;" />
				</section>

				<section class="study">
					<span>카테고리</span><br />
					<button class="category" data-index="1">영어</button>
					<button class="category" data-index="2">수학</button>
					<button class="category" data-index="3">과학</button>
					<button class="category" data-index="4">역사</button>
					<button class="category" data-index="5">프로그래밍</button>
					<button class="category" data-index="6">영어</button>
					<button class="category" data-index="7">수학</button>
					<button class="category" data-index="8">과학</button>
					<button class="category" data-index="9">역사</button>
					<button class="category" data-index="10">프로그래밍</button>
					<input type="hidden" name="categories" id="categories" value="" />
				</section>


				<section id="schedule" class="study" style="display: inline-block">
					<span>정기 수업 일정</span><span class="required">*</span><br />
					<article class="schedule">
						<span>요일</span> 
						<select class="small" name="day" required>
							<option value="월">월</option>
							<option value="화">화</option>
							<option value="수">수</option>
							<option value="목">목</option>
							<option value="금">금</option>
							<option value="토">토</option>
							<option value="일">일</option>
						</select> 
						<span>시간</span> 
						<input type="time" /> ~ <input type="time" />
						<button class="delete_btn" onClick="deleteSchedule(this)">삭제</button>
					</article>
					<button id="plus_btn" onClick="addSchedule()">+</button>
				</section>

				<section>
					<button id="submit">강의 만들기</button>
				</section>
			</form>
		</div>
	</div>
</body>
</html>
