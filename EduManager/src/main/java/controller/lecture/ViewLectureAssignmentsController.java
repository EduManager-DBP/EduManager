package controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.Assignment;
import model.service.LectureManager;

public class ViewLectureAssignmentsController implements Controller {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }

        int groupId = Integer.parseInt(request.getParameter("groupId"));
        LectureManager lectureManager = LectureManager.getInstance();

        List<Assignment> lectureAssignmentList = lectureManager.findAssignmentsByLectureId(groupId);

        request.setAttribute("lectureAssignmentList", lectureAssignmentList);

        request.setAttribute("groupId", groupId);

        return "/lecture/listAssignment.jsp";

    }
}
