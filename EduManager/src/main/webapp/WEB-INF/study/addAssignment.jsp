<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>과제 추가하기</title>
<link rel="stylesheet" href="<c:url value='/css/addAssignment.css' />" />
</head>
<body>
	<div class="main-container">
	<jsp:include page="../navigation/navigation.jsp" />
		<form action="/submit-assignment" method="POST">
			<span class="title">과제 추가하기</span>
			<div class="form">
				<!-- 과제 명 -->
				<div class="task-name-input">
					<label for="assignment-name" class="assignment-name">과제 명</label> 
					<input type="text" name="assignmentName"
						placeholder="과제" class="input" required />
				</div>
				<!-- 마감일 -->
				<div class="deadline-input">
					<label for="deadline" class="deadline">마감일</label> 
					<input type="date" id="deadline" name="deadline" class="input-field"
						required/>
				</div>
				<!-- 세부 내용 -->
				<div class="detail-input">
					<label for="details" class="detail-text">세부 내용</label>
					<textarea id="details" name="details" placeholder="세부 내용을 입력하세요."
						class="input-field-1" required></textarea>
				</div>
			</div>
			<!-- 제출 버튼 -->
			<button type="submit" class="complete-button">제출</button>
		</form>
	</div>
</body>
</html>