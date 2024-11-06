<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../css/signUp.css' />" type="text/css">
    <title>Edu Manager</title>
  </head>
  <body>
    <div class="page" >
              <header>
               <img src='../images/eduLogo.png' />
            <nav>
                <ul>
                    <li class="menu"><a href="main.jsp">홈</a></li>
                    <li class="menu"><a href="registration.jsp">강의/스터디 신청</a></li>
                    <li class="menu"><a href="studentMypage.jsp">마이 페이지</a></li>
                    <li class="menu"><a href="#">로그인/회원가입</a></li>
                </ul>
            </nav>

         </header>
                <div id="form-container">
                    <div id="sign-up-container">
                        <h3>회원가입</h3>
                        <form>
                            <div class="input-group">
                            <label for="email">아이디(이메일)</label>
                      <input type="email" name="email" id="email" placeholder="Email">
                      <button type="button" id="checkDuplicate">중복 확인</button>
                     </div>
                            <label for="password">비밀번호</label>
                            <input type="password" name="password" id="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;">
                            <label for="password-confirm">비밀번호 확인</label>
                            <input type="password" name="password-confirm" id="password-confirm" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;" />
                            <label for="name">이름</label>
                            <input type="text" name="name" id="name" placeholder="Name">
                            <div id="form-controls">
                                <button type="button" id="nextBt">다음</button>
                            </div>
                        </form>
                        <div class="page-indicator">
                      <div class="circle active"></div>
                      <div class="circle"></div>
                         <div class="circle"></div>
                  </div>
                    </div>
                </div>
    </div>
  </body>
  </html>