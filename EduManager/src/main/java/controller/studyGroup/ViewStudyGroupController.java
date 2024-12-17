package controller.studyGroup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.studyGroup.StudyGroup;
import model.service.StudyGroupManager;

public class ViewStudyGroupController implements Controller {

    private final StudyGroupManager studyGroupManager;

    public ViewStudyGroupController() {
        this.studyGroupManager = StudyGroupManager.getInstance();  // 싱글톤 인스턴스 가져오기
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // 로그인하지 않았다면 로그인 폼으로 리다이렉트
        }

        // PathVariable을 사용하여 lectureId를 URL 경로에서 받도록 수정
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        String stuId = MemberSessionUtils.getLoginMemberId(request.getSession());
        // LectureManager를 통해 강의 정보 조회
        StudyGroupManager manager = StudyGroupManager.getInstance();
        StudyGroup group = manager.findStudyGroupById(groupId);

        // 강의 정보를 request에 저장
     

        // 강의 상세 정보 출력 (디버깅용)
        System.out.println("그룹 ID: " + group.getStudyGroupId()+
                           ", 그룹 이름: " + group.getName() +
                           ", 카테고리: " + group.getCategory() +
                           ", 설명: " + group.getDescription() 
                           );

        // 로그인한 사용자 ID를 request에 저장
        request.setAttribute("groupId", groupId);
        request.setAttribute("groupName",  group.getName());
        request.setAttribute("description", group.getDescription());
        
        boolean isLiked = studyGroupManager.isLikedByUser(stuId, groupId); // 인스턴스를 통해 호출
        System.out.println("좋아요 여부: "+ isLiked );
        request.setAttribute("isLiked", isLiked);
   
        // 강의 상세 페이지로 이동
        return "/study/study_overview.jsp";
    }
}
        
        
