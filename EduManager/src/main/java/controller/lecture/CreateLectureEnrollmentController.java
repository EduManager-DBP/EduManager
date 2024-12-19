package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.LectureManager;

public class CreateLectureEnrollmentController implements Controller {

    private final LectureManager lectureManager;
    
    public CreateLectureEnrollmentController() {
        this.lectureManager = LectureManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String memberId = request.getParameter("memberId");
        Long lectureId = Long.parseLong(request.getParameter("lectureId"));

        //가입 요청 생성
        lectureManager.createLectureEnrollment(memberId, lectureId);

        // 상태 변경 후 해당 페이지로 리다이렉트
        return "redirect:/lecture/over-view?lectureId=" + lectureId; // 페이지 새로고침
    }
}