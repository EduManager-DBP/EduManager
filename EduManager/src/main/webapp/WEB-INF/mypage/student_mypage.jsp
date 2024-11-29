<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/studentMypage.css' />"
	type="text/css">
<title>EduManager</title>
</head>
<body>
	<div class="page">
		<jsp:include page="../navigation/navigation.jsp" />

		<div class="subTitle">마이 페이지</div>
		<div id="mypage_container">
			<div id="profile_img_container">
				<img id="profile_img"src="<c:url value='/images/profileImg.svg' />" >
			</div>
			<div id="mypage_name">
				<p>${curUserId} 학생</p>
			</div>
			<div id="mypage_btn_container">
				<button class="mypageBtn setting">설정</button>
				<button class="mypageBtn myinfo">내 정보</button>
				<button class="mypageBtn myclass">내 강의</button>
				<button class="mypageBtn mystudyroom" onclick="window.location.href='<c:url value='/study/list' />'">
					내스터디그룹</button>
			</div>
		</div>
	</div>
</body>
</html>
