package controller.study;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.domain.Assignment;
import model.service.StudyManager;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import controller.Controller;
import controller.member.MemberSessionUtils;


public class ViewMyStudyController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewMyStudyController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form"; // login form 요청으로 redirect
		}
//		StudyManager manager = StudyManager.getInstance();

		 // 클라이언트에서 보낸 날짜 받기
        String selectedDateStr = request.getParameter("selectedDate");
//        Integer studyId = Integer.parseInt(request.getParameter("studyId"));
        Integer studyId = 10;
        if (selectedDateStr != null && !selectedDateStr.isEmpty()) {
            LocalDate selectedDate = LocalDate.parse(selectedDateStr); // 날짜 포맷: YYYY-MM-DD
            log.debug("선택된 날짜: " + selectedDate);
            
//            List<Assignment> assignmentList = manager.findAssignmentsByStudyIdAndDueDate(studyId, selectedDate);
//            log.debug("과제목록: " + assignmentList);

            // 필요한 비즈니스 로직 수행 (예: DB 조회)
            request.setAttribute("selectedDate", selectedDate);
//            request.setAttribute("assignmentList", assignmentList);

        }

        // JSP 페이지로 포워딩 (예: 결과 표시)
        return "/study/study_details.jsp"; // 뷰로 이동
	}
}
