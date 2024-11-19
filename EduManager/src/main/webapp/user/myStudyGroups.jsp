<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../css/myStudyGroups.css' />" type="text/css">
    <title>Edu Manager</title>
    <script src="../js/myStudyGroups.js"></script>
  </head>
  <body>
    <div class="page">
        <header>
            <img src="../images/eduLogo.png">
            <nav>
                <ul>
                    <li class="menu"><a href="main.jsp">홈</a></li>
                    <li class="menu"><a href="registration.jsp">강의/스터디 신청</a></li>
                    <li class="menu"><a href="studentMypage.jsp">마이페이지</a></li>
                    <li class="menu"><a href="">로그아웃</a></li>
                </ul>
            </nav>
        </header>
        

      <div class="subTitle">내 스터디</div>
      <div class="tab-container">
        <div class="tabs on" onclick="openTab('Tab1')">
           <div> <img src="../images/leader.svg" id="tabIcon"></div>
           <div>팀장</div> 
        </div>
        <div class="tabs" onclick="openTab('Tab2')">
            <div> <img src="../images/follower.svg" id="tabIcon"></div>
            <div>팀원</div> 
        </div>
    </div>
    <div class="hr-wrapper">
        <hr id="myStudyGroups_mainHr">
        <hr id="myStudyGroups_hr1">
        <hr id="myStudyGroups_hr2">
      </div>
    <div class="tab_wrap">
      <div id="Tab1" class="tab on">
        <div id="leaderRoom1" class="leaderRoom">
          <img src="../images/white.png" class="groupGallery">
          <button class="leaderRoomBtn">가입 요청 확인하기</button>
        </div>
        <div id="leaderRoom2" class="leaderRoom">
          <img src="../images/white.png" class="groupGallery">
          <button class="leaderRoomBtn">가입 요청 확인하기</button>
          </div>
          <div id="leaderRoom3" class="leaderRoom">
          <img src="../images/white.png" class="groupGallery">
          <button class="leaderRoomBtn">가입 요청 확인하기</button>
          </div>

      </div>
      <div id="Tab2" class="tab">
        <div id="studyRoom1" class="studyRoom">
            <img src="../images/white.png" class="groupGallery">
          </div>
          <div id="studyRoom2" class="studyRoom">
            <img src="../images/white.png" class="groupGallery">
            </div>
            <div id="studyRoom3" class="studyRoom">
            <img src="../images/white.png" class="groupGallery">
      </div>
      

  </body>
  </html>
