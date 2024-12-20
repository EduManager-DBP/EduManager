package controller.lecture;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.Assignment;
import model.domain.Notice;
import model.domain.Schedule;
import model.domain.studyGroup.StudyGroup;
import model.service.LectureManager;
import model.service.StudyManager;

public class CreateLectureAssignmentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateLectureAssignmentController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form"; // login form 요청으로 redirect
		}

		String leaderId = MemberSessionUtils.getLoginMemberId(request.getSession());
		System.out.print("내 아이디 : 스터디 리더:" + leaderId);

		// GET요청
		if (request.getMethod().equals("GET")) {
			request.setAttribute("lectureId", request.getParameter("lectureId"));
			request.setAttribute("startDate", LocalDate.parse(request.getParameter("selectedDate")));
			return "/lecture/addAssignment.jsp";
		}
		;

		// POST요청
		try {
			Assignment assignment = new Assignment();

			assignment.setTitle(request.getParameter("title"));
			assignment.setDescription(request.getParameter("description"));
			assignment.setDueDate(LocalDate.parse(request.getParameter("dueDate")));
			assignment.setLectureId(Integer.parseInt(request.getParameter("lectureId")));

			LectureManager manager = LectureManager.getInstance();
			 manager.createAssignment(assignment);

			return "redirect:/mylecture/view?lectureId=" + Long.parseLong(request.getParameter("lectureId"))
					+ "&selectedDate=" + LocalDate.parse(request.getParameter("startDate"));

		} catch (Exception e) { // 예외 발생 시 입력 form으로 forwarding
			request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			System.out.print(e);

			return "redirect:/member/login/form";
		}
	}
}
