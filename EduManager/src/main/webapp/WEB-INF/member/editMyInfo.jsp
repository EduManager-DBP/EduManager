<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <link rel=stylesheet href="<c:url value='/css/editMyInfo.css' />" type="text/css">
    <title>회원 정보 수정</title>
</head>
<body>
    <div class="page" >
          <jsp:include page="/WEB-INF/navigation/navigation.jsp" />    
          <div id="form-container">
              <div id="sign-up-container">
                  <h3>회원가입</h3>
                  <form>
                    
                      <label for="password">비밀번호</label>
                      <input type="password" name="pwd" id="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;">
                      <label for="password-confirm">비밀번호 확인</label>
                      <input type="password" name="password-confirm" id="password-confirm" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;" />
                      
					  <label for="email">전화번호</label>
                      <input type="text" name="phoneNumber" id="phoneNumber" placeholder="01012345678">
                      <div id="form-controls">
                          <button type="button" id="updateBt">수정하기</button>
                      </div>
                  </form>
              </div>
          </div>
    </div>
  </body>
</html>

