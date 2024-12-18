package controller.studyGroup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.StudyGroupManager;

public class AcceptedRequestController implements Controller {

    private final StudyGroupManager studyGroupManager;

    public AcceptedRequestController() {
        this.studyGroupManager = StudyGroupManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long applicationId = Long.parseLong(request.getParameter("studyGroupApplicationId"));
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        System.out.print(applicationId);

        studyGroupManager.acceptApplication(applicationId);


        // 상태 변경 후 해당 페이지로 리다이렉트
        return "redirect:/study/requests?groupId=" + groupId; // 페이지 새로고침
    }
}
