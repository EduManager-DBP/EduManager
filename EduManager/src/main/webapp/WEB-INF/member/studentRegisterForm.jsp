<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel=stylesheet href="<c:url value='/css/registerForm.css' />" type="text/css">
    <title>EduManager registerForm</title>
  </head>
  <body>
    <div class="page" >
          <header>
	    	  <nav>
		          <a href="<c:url value='/member/login'/>" id="logo-link">
		   		 	<img src="<c:url value='/images/eduLogo.png' />" alt="Edu Logo" />
			  	  </a>
		  	  </nav>

	  	  </header>  
          <div id="form-container">
              <div id="sign-up-container">
                  <h3>학생 회원가입</h3>
                  <form name="form" method="POST" action="<c:url value='/student/register' />">
                      <div class="input-group">
                      	<label for="id">아이디</label>
                			<input type="text" name="id" id="id" placeholder="id">
                			<button type="button" id="checkDuplicate">중복 확인</button>
              		  </div>
                      <label for="password">비밀번호</label>
                      <input type="password" name="pwd" id="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;">
                      <label for="password-confirm">비밀번호 확인</label>
                      <input type="password" name="password-confirm" id="password-confirm" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;" />
                      <label for="name">이름</label>
                      <input type="text" name="name" id="name" placeholder="Name">
					  <label for="email">이메일</label>
                      <input type="email" name="email" id="email" placeholder="Email">
                      <label for="email">전화번호</label>
                      <input type="tel" name="phone" id="phone" placeholder="PhoneNumber" pattern="[0-9]{3}-[0-9]{*}-[0-9]{*}" required>
                     
                      <div id="form-controls">
                          <button type="button" id="nextBt">다음</button>
                      </div>
                  </form>
                  <!-- 하단 바 -->
				<img src="<c:url value='/images/slidebar2.png' />"
					alt="bar" style="margin-top: 30px; width: 50px; justify-self=center;">
              </div>
          </div>
    </div>
  </body>
  </html>