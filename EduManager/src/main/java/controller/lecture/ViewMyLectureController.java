package controller.lecture;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.domain.Assignment;
import model.domain.Notice;
import model.domain.Schedule;
import model.domain.lecture.Lecture;
import model.domain.studyGroup.StudyGroup;
import model.service.LectureManager;
import model.service.StudyManager;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import controller.Controller;
import controller.member.MemberSessionUtils;


public class ViewMyLectureController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewMyLectureController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form"; // login form 요청으로 redirect
		}
        LectureManager manager = LectureManager.getInstance();


		
		 // 클라이언트에서 보낸 날짜 받기
        String selectedDateStr = request.getParameter("selectedDate");
        Integer lectureId = Integer.parseInt(request.getParameter("lectureId"));
//        Integer studyId = 10;
        LocalDate selectedDate;
        if (selectedDateStr != null && !selectedDateStr.isEmpty()) {
            selectedDate = LocalDate.parse(selectedDateStr); // 날짜 포맷: YYYY-MM-DD
        }else {
            selectedDate = LocalDate.now(); // 오늘 날짜로 설정
        }
            log.debug("선택된 날짜: " + selectedDate);
 
            List<Assignment> assignmentList = manager.findAssignmentsByLectureIdAndDueDate(lectureId, selectedDate);
            log.debug("과제목록: " + assignmentList);

            List<Notice> noticeList = manager.findNoticesByLectureIdAndDate(lectureId, selectedDate);
            log.debug("공지목록: " + noticeList);
            
//            LocalDate today = LocalDate.now();
            String DayOfWeek = selectedDate.getDayOfWeek().toString(); // 오늘 요일 (예: "MONDAY")
            List<Schedule> regularSchedules = manager.findSchedulesByFilters(lectureId, selectedDate, "regular", DayOfWeek);
            log.debug("정기일정: " + regularSchedules);
            log.debug("요일 " + DayOfWeek);
            
            List<Schedule> specialSchedules = manager.findSchedulesByFilters(lectureId, selectedDate, "special", null);
            log.debug("특수일정: " + specialSchedules);
            
            
            // 필요한 비즈니스 로직 수행 (예: DB 조회)
            request.setAttribute("selectedDate", selectedDate);
            request.setAttribute("assignmentList", assignmentList);
            request.setAttribute("noticeList", noticeList);
            request.setAttribute("regularSchedules", regularSchedules);
            request.setAttribute("specialSchedules", specialSchedules);

            Lecture lectureInfo = manager.findLectureById(lectureId);
            log.debug("lectureInfo: " + lectureId);

            List<String> members = manager.findLectureMembers(lectureId);
            log.debug("members: " + members);

            String teacherId = MemberSessionUtils.getLoginMemberId(request.getSession());
    		Boolean isTeacher= (teacherId.equals(lectureInfo.getTeacherId())) ? true : false;
            
    		//study 기본 정보
            request.setAttribute("lectureInfo", lectureInfo);
            request.setAttribute("isTeacher", isTeacher);
            request.setAttribute("members", members);
        // JSP 페이지로 포워딩 (예: 결과 표시)
        return "/lecture/lecture_details.jsp"; // 뷰로 이동
	}
}
