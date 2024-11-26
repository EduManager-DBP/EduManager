package controller.lecture;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.lecture.Lecture;
import model.service.LectureManager;

public class ListLectureController implements Controller {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // LectureManager 인스턴스 생성
        
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }
        
        LectureManager manager = LectureManager.getInstance();
        
        // 강의 목록 조회
        List<Lecture> lectureList = manager.findLectureList();
        
        System.out.println("강의 목록:");
        for (Lecture lecture : lectureList) {
            System.out.println("강의 ID: " + lecture.getLectureId() +
                               ", 강의 이름: " + lecture.getName() +
                               ", 카테고리: " + lecture.getCategory());
        }
        
        // 강의 목록을 request 객체에 저장
        request.setAttribute("curUserId", MemberSessionUtils.getLoginMemberId(request.getSession()));
        request.setAttribute("lectureList", lectureList);
        
        // 강의 목록을 request 객체에 저장
        request.setAttribute("curUserId", MemberSessionUtils.getLoginMemberId(request.getSession()));
        request.setAttribute("lectureList", lectureList);
        
        // 강의 목록을 출력할 JSP 페이지로 포워딩
        return "/registration/registration.jsp";
    }
}