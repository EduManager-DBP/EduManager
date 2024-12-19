<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/my_study_list.css' />"
	type="text/css">
<title>EduManager</title>
<script src="<c:url value='/js/myStudyGroups.js' />"></script>
</head>
<body>
	<div class="page">
		<!-- 네비게이션 포함 -->
		<jsp:include page="../navigation/navigation.jsp" />

		<div class="subTitle">내 강의</div>

		<div id="Tab1" class="tab on">
			<div class="class">
				<c:forEach var="group" items="${lectureList}">
					<div class="groupGallery">
						<a
							href="<c:url value='/lecture/over-view'> <c:param name='lectureId' value='${group.lectureId}'/>
			 	 </c:url>">
							<img src="<c:url value='/images/white.png' />" alt="Group Image">
							<div class="groupGalleryTitle">${group.name}</div>
							<div class="groupGalleryCategory">${group.category}</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
