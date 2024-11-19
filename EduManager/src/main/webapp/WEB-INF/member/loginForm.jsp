<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='../../css/login.css' />" type="text/css">
    <title>EduManager LoginForm</title>
  <script>
  function login() {
		if (form.userId.value == "") {
			alert("사용자 ID를 입력하십시오.");
			form.userId.focus();
			return false;
		} 
		if (form.password.value == "") {
			alert("비밀번호를 입력하십시오.");
			form.password.focus();
			return false;
		}		
		form.submit();
	}

	function userCreate(targetUri) {
		form.action = targetUri;
		form.method="GET";		// register form 요청
		form.submit();
	}
  </script>
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
                        <form name="loginForm" method="POST" action="<c:url value='/member/login' />">
                            <div class="input-group">
	                            <label for="email">아이디(이메일)</label>
	                      		<input type="email" name="email" id="email" placeholder="Email">
                     		
	                            <label for="password">비밀번호</label>
	                            <input type="password" name="password" id="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;">
                            </div>
                            <div id="form-controls">
                                <button type="button" id="nextBt" onClick="login()">로그인</button>
                            </div>
                            <div id="form-controls">
                                <button type="button" id="nextBt" onClick="userCreate('<c:url value='/member/register'/>')">회원가입</button>
                            </div>
                        </form>
                        
                    </div>
                </div>
    </div>
  </body>
  </html>