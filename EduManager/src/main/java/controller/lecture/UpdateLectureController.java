package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.lecture.Lecture;
import model.service.LectureManager;
import model.service.MemberManager;

public class UpdateLectureController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateLectureController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
		LectureManager manager = LectureManager.getInstance();
		HttpSession session = request.getSession();

		String teacherId = MemberSessionUtils.getLoginMemberId(request.getSession());
		System.out.print("내 아이디 : 선생:" + teacherId);

//		Long updateLectureId = Long.parseLong(request.getParameter("lectureId"));
		//임시
		Long updateLectureId = 8L;

		log.debug("UpdateForm Request : {}", updateLectureId);
		if (request.getMethod().equals("GET")) {

			// GET request: 회원정보 수정 form 요청

			Lecture lecture = manager.findLectureById(updateLectureId);// 수정하려는 강의 정보 검색
			log.debug("UpdateForm Request : {}", lecture);

//    		if (MemberSessionUtils.isLoginMember(teacherId, session)) { 
			if (MemberSessionUtils.isLoginMember(lecture.getTeacherId(), session)
					&& lecture.getTeacherId().equals(teacherId)) {
				// 현재 로그인한 사용자가 해당 강의의 강사인 경우 -> 수정 가능
				// 강의 일정 리스트 검색 해 올것.
//    				List<Community> commList = manager.findCommunityList();	
//    				request.setAttribute("scheduleList", scheduleList);	

				// teacher name을 넘겨줘야함.

				MemberManager memberManager = MemberManager.getInstance();
				String teacherName = memberManager.findName(teacherId);
				lecture.setTeacherName(teacherName);
				
				request.setAttribute("lecture", lecture);
				return "/lecture/updateForm.jsp"; // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송
			}
		}

		// POST request (회원정보가 parameter로 전송됨)
		Lecture updateLecture = new Lecture(Long.parseLong(request.getParameter("lectureId")),request.getParameter("name"), request.getParameter("img"),
				request.getParameter("category"), Long.parseLong(request.getParameter("capacity")), // String -> long 변환
				Integer.parseInt(request.getParameter("level")), request.getParameter("description"), teacherId, // String
				Integer.parseInt(request.getParameter("lectureRoom"))// String -> Integer 변환
		);
		// 강의 일정 리스트도 updateLecutreId이용해서 update

		log.debug("Update Lecture : {}", updateLecture);

		manager.updateLecture(updateLecture);
		return "redirect:/main/main";

	}
}
