<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../../css/signUp.css' />" type="text/css">
    <title>EduManager</title>
  </head>
  <body>
    <div class="page" >
              <header>
               <img src='../../images/eduLogo.png' />
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
                        <h3>로그인 </h3>
                        <form>
                            <div class="input-group">
                            <label for="email">아이디(이메일)</label>
                      <input type="email" name="email" id="email" placeholder="Email">
                     </div>
                            <label for="password">비밀번호</label>
                            <input type="password" name="password" id="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;">
                            <div id="form-controls">
                                <button type="button" id="nextBt">로그인하기</button>
                            </div>
                        </form>
                        
                    </div>
                </div>
    </div>
  </body>
  </html>