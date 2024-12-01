package controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.lecture.Lecture;
import model.service.LectureManager;

public class ExcludingLectureListController implements Controller {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }

        String stuId = "admin";
      LectureManager manager = LectureManager.getInstance();
        
      
      List<Lecture> lectureList = manager.getLecturesExcludingStudent(stuId);
      
      System.out.println("강의 목록:");
      for (Lecture lecture : lectureList) {
          System.out.println("강의 ID: " + lecture.getLectureId() +
                             ", 강의 이름: " + lecture.getName() +
                             ", 카테고리: " + lecture.getCategory());
      }
      
      // 강의 목록을 request 객체에 저장
      request.setAttribute("curUserId", MemberSessionUtils.getLoginMemberId(request.getSession()));
      request.setAttribute("lectureList", lectureList);


      return "/registration/registration.jsp";
        
        

        
        
       
    }

}