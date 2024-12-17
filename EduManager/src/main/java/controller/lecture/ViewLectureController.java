package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.lecture.Lecture;
import model.service.LectureManager;

public class ViewLectureController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // 로그인하지 않았다면 로그인 폼으로 리다이렉트
        }

        // PathVariable을 사용하여 lectureId를 URL 경로에서 받도록 수정
        Long lectureId = Long.parseLong(request.getParameter("groupId"));

        // LectureManager를 통해 강의 정보 조회
        LectureManager manager = LectureManager.getInstance();
        Lecture lecture = manager.findLectureById(lectureId);

        // 강의 정보를 request에 저장
     

        // 강의 상세 정보 출력 (디버깅용)
        System.out.println("강의 ID: " + lecture.getLectureId() +
                           ", 강의 이름: " + lecture.getName() +
                           ", 카테고리: " + lecture.getCategory() +
                           ", 강의실: " + lecture.getLectureRoom() +
                           ", 강사 이름: " + lecture.getTeacherName() +
                           ", 강사 번호: " + lecture.getPhone());

        // 로그인한 사용자 ID를 request에 저장
        request.setAttribute("curUserId", MemberSessionUtils.getLoginMemberId(request.getSession()));
        request.setAttribute("lectureName",  lecture.getName());
        request.setAttribute("teacherName", lecture.getTeacherName());
        request.setAttribute("teacherPhone", lecture.getPhone());
        request.setAttribute("lectureroom", lecture.getLectureRoom());
        request.setAttribute("description", lecture.getDescription());
        request.setAttribute("lectureroom", lecture.getLectureRoom());
        // 강의 상세 페이지로 이동
        return "/lecture/lecture_overview.jsp";
    }
}
        
        
