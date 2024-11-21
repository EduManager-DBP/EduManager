<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../css/studentMypage.css' />" type="text/css">
    <title>EduManager</title>
  </head>
  <body>
    <div class="page">
        <header>
            <img src="../images/eduLogo.png">
            <nav>
                 <ul>
                    <li class="menu"><a href="main.jsp">홈</a></li>
                    <li class="menu"><a href="registration.jsp">강의/스터디 신청</a></li>
                    <li class="menu"><a href="#">마이 페이지</a></li>
                    <li class="menu"><a href="">로그아웃</a></li>
                </ul>
            </nav>
        </header>

        <div class="subTitle">마이 페이지</div>
        <div id="mypage_container">
            <div id="profile_img_container">
                <img id="profile_img" src="../images/profileImg.svg">
            </div>
            <div id="mypage_name">
                <p>000학생</p>
            </div>
            <div id="mypage_btn_container">
                <button class="mypageBtn setting">
                    설정
                </button>
                <button class="mypageBtn myinfo">
                    내 정보
                </button>
                <button class="mypageBtn myclass">
                    내 강의
                </button>
                <button class="mypageBtn mystudyroom" onclick="window.location.href='myStudyGroups.jsp';">
                   내 스터디그룹
                </button>
            </div>
        </div>
  </body>
  </html>
