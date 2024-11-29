<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <link rel="stylesheet" href="<c:url value='/css/myInfo.css' />" type="text/css">
    <title>내 정보 확인</title>
</head>
<body>
    <div class="page">
        <jsp:include page="/WEB-INF/navigation/navigation.jsp" />  
        <div id="form-container">
            <div id="info-container">
                <div id="info-title">내 정보</div>
                
                <!-- 아이디 -->
                <div>
                    <label class="info-label" for="id">아이디</label>
                    <div class="info-box" id="id">
                        <c:out value="${member.id}" />
                    </div>
                </div>
                
                <!-- 비밀번호 -->
                <div>
                    <label class="info-label" for="password">비밀번호</label>
                    <div class="info-box" id="password">
                        ********
                    </div>
                </div>
                
                <!-- 이름 -->
                <div>
                    <label class="info-label" for="name">이름</label>
                    <div class="info-box" id="name">
                        <c:out value="${member.name}" />
                    </div>
                </div>
                
                 <!-- 이메일 추가 부분 -->
                <div>
                    <label class="info-label" for="email">이메일</label>
                    <div class="info-box" id="email"><c:out value="${member.email}" /></div> <!-- 이메일 출력 -->
                </div>
                
                <!-- 전화번호 -->
                <div>
                    <label class="info-label" for="phoneNumber">전화번호</label>
                    <div class="info-box" id="phoneNumber">
                        <c:out value="${member.phone}" />
                    </div>
                </div>
                
                <div id="button-container">
                    <button class="footer-button" id="deleteAccount">탈퇴하기</button>
                    <button class="footer-button" id="editInfo">수정하기 > </button>
                </div>
                
                <!-- 모달 -->
                <div id="confirmationModal" class="modal">
                    <div class="modal-content">
                      <h4>정말 탈퇴하시겠습니까?</h4>
                      <div class="modal-actions">
                        <button id="cancelBtn" class="btn">취소</button>
                        <button id="confirmBtn" class="btn">확인</button>
                      </div>
                    </div>
                  </div>
                
                  <script>
                    const deleteAccountBtn = document.getElementById('deleteAccount');
                    const confirmationModal = document.getElementById('confirmationModal');
                    const cancelBtn = document.getElementById('cancelBtn');
                    const confirmBtn = document.getElementById('confirmBtn');
                
                    deleteAccountBtn.addEventListener('click', () => {
                      confirmationModal.style.display = 'flex'; 
                    });
                
                    cancelBtn.addEventListener('click', () => {
                      confirmationModal.style.display = 'none'; 
                    });
                
                    confirmBtn.addEventListener('click', () => {
                      alert("탈퇴가 완료되었습니다.");
                      confirmationModal.style.display = 'none'; 
                    });
                  </script>
             
            </div>
        </div>
    </div>
</body>
</html>
