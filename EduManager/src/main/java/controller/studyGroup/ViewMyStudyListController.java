package controller.studyGroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.studyGroup.StudyGroup;
import model.service.StudyGroupManager;

public class ViewMyStudyListController implements Controller{

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }

      String stuId = MemberSessionUtils.getLoginMemberId(request.getSession());
        
      StudyGroupManager studyGroupManager = StudyGroupManager.getInstance();
      
      List<StudyGroup> studyGroupListByLeader = studyGroupManager.StudyGroupListByLeader(stuId);


      System.out.println("팀장 스터디그룹 목록:");
      for (StudyGroup studyGroup : studyGroupListByLeader) {
          System.out.println("강의 ID: " + studyGroup.getStudyGroupId() +
                             ", 강의 이름: " + studyGroup.getName() +
                             ", 카테고리: " + studyGroup.getCategory());
      }
      
      // 강의 목록을 request 객체에 저장
      request.setAttribute("curUserId", stuId);
     
      request.setAttribute("studyGroupList", studyGroupListByLeader);

      return "/study/my_study_list.jsp";
        

       
    

}
}
