package controller.studyGroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.Assignment;
import model.domain.Notice;
import model.service.StudyManager;

public class ViewStudyAssignmentsController implements Controller {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }

        int groupId = Integer.parseInt(request.getParameter("groupId"));
        StudyManager studyGroupManager = StudyManager.getInstance();

      

            List<Assignment> studyGroupAssignmentList = studyGroupManager.findAssignmentsByStudyId(groupId);

            request.setAttribute("studyGroupAssignmentList", studyGroupAssignmentList);
            
            request.setAttribute("groupId", groupId);
          

        // 스터디 목록을 request 객체에 저장

        return "/study/listAssignment.jsp";

    }
}
