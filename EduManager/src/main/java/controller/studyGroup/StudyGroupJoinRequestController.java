package controller.studyGroup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.StudyGroupManager;

public class StudyGroupJoinRequestController implements Controller {

    private final StudyGroupManager studyGroupManager;

    public StudyGroupJoinRequestController() {
        this.studyGroupManager = StudyGroupManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String memberId = request.getParameter("memberId");
        Long groupId = Long.parseLong(request.getParameter("groupId"));

        //가입 요청 생성
        studyGroupManager.createApplication(memberId, groupId);

        // 상태 변경 후 해당 페이지로 리다이렉트
        return "redirect:/study/over-view?groupId=" + groupId; // 페이지 새로고침
    }
}
