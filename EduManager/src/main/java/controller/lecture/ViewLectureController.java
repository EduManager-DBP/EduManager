package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.lecture.Lecture;
import model.service.LectureManager;

public class ViewLectureController  implements Controller {
   
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }

      
      LectureManager manager = LectureManager.getInstance();
        
      
      Long lectureId =18L;
        // 강의 목록 조회
        Lecture lecture = manager. findLectureById(lectureId);
        
        System.out.println("강의 목록:");
      
            System.out.println("강의 ID: " + lecture.getLectureId() +
                               ", 강의 이름: " + lecture.getName() +
                               ", 카테고리: " + lecture.getCategory()+
                               ", 강의실" + lecture.getLectureRoom()+
                               ", 강사이름: " + lecture.getTeacherName()+
                               ", 강사 번호: " + lecture.getPhone()+
                               ", 카테고리: " + lecture.getCategory());
        
     
        // 강의 목록을 request 객체에 저장
        request.setAttribute("curUserId", MemberSessionUtils.getLoginMemberId(request.getSession()));
        request.setAttribute("lectureName", lecture.getLectureRoom());
        request.setAttribute("teacherName", lecture.getTeacherName());
        request.setAttribute("teacherPhone", lecture.getPhone());
        request.setAttribute("lectureroom", lecture.getLectureRoom());
        request.setAttribute("description", lecture.getDescription());
        request.setAttribute("lectureroom", lecture.getLectureRoom());
        

        
        
        return "/lecture/lecture_overview.jsp";
    }

}
