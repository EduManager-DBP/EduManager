package controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;

import model.service.member.StudentManager;

public class ViewMyPageController  implements Controller {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }

      String stuId = MemberSessionUtils.getLoginMemberId(request.getSession());
        
      StudentManager studentManager = StudentManager.getInstance();
     // 학생인지 강사인지 구분
     boolean existStudent = studentManager.existingStudent(stuId);
     request.setAttribute("existStudent", existStudent);
     

      return "/mypage/myPage.jsp"; 
        
    }
   }
