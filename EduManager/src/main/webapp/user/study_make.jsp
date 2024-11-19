<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../css/study_make.css' />" type="text/css">
    <title>Edu Manager</title>
  </head>
  <body>
    <div class="page">
      <header>
        <img src="../images/eduLogo.png" />
       <nav>
          <ul>
            <li class="menu"><a href="main.jsp">홈</a></li>
            <li class="menu">
              <a href="myStudyGroups.jsp">강의/스터디 신청</a>
            </li>
            <li class="menu"><a href="#">마이 페이지</a></li>
            <li class="menu"><a href="">로그아웃</a></li>
          </ul>
        </nav>
      </header>

         <div class="subTitle">스터디 그룹 만들기</div>
      <section>

        <div id="makeStudy_container">
            <div id="makeStudy_form">
          <section class="study">
            <span>스터디명</span><br />
            <input type="text" />
          </section>
          <section class="study">
            <span>스터디 소개</span><br />
            <input type="text" />
          </section>
          <section class="study" style="display: inline-block">
            <span>모집인원</span> <br /><input class="small" type="number" />
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
          <section class="study" style="display: inline-block">
            <span>정기 모임 일정</span><br />
            <article class="schedule">
              <span>요일</span> <input class="small" type="text" />
              <span>시간</span>
              <input type="time" /> - <input type="time" />
            </article>
            <button id="plus_btn">+</button>
          </section>
     
        <section>
          <button id="submit">스터디 그룹 만들기</button>
        </section>
    </div>
        </div>
        </section>
      </section>
    </div>
  </body>
</html>
