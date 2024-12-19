package controller.lecture;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.Schedule;
import model.domain.lecture.Lecture;
import model.service.LectureManager;
import model.service.member.MemberManager;

public class CreateLectureController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateLectureController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form"; // login form 요청으로 redirect
		}

		String teacherId = MemberSessionUtils.getLoginMemberId(request.getSession());
		System.out.print("내 아이디 : 선생일 때:" + teacherId);

		// GET요청
		if (request.getMethod().equals("GET")) {
			MemberManager memberManager = MemberManager.getInstance();
			String teacherName = memberManager.findName(teacherId);

			request.setAttribute("teacherName", teacherName);
			return "/lecture/creationForm.jsp";
		}

		// POST요청
		Lecture lecture = new Lecture(0L, request.getParameter("name"), request.getParameter("img"),
				request.getParameter("category"), Long.parseLong(request.getParameter("capacity")), // String -> long 변환
				Integer.parseInt(request.getParameter("level")), request.getParameter("description"), teacherId, // String
				Integer.parseInt(request.getParameter("lectureRoom"))// String -> Integer 변환
		);

		try {
			LectureManager manager = LectureManager.getInstance();
			lecture = manager.createLecture(lecture);
			log.debug("Create Lecture : {}", lecture.getLectureId());
//
			int scheduleCount = Integer.parseInt(request.getParameter("scheduleCount"));//처음에 value를 안정해줌. jsp에서 오류계속 났었음.
//			// 일정의 개수
//			log.debug("scheduleCount : {}", scheduleCount);
			for (int i = 0; i < scheduleCount; i++) { // 각 일정 항목의 값들을 받아오기 String
				String dayOfWeek = request.getParameter("schedule[" + i + "][day]");
//				log.debug("dayOfWeek : {}", dayOfWeek);

				LocalTime startTime = LocalTime.parse(request.getParameter("schedule[" + i + "][startTime]"));
				LocalTime endTime = LocalTime.parse(request.getParameter("schedule[" + i + "][endTime]"));
//				log.debug("startTime : {} endTime:{}", startTime, endTime);


//				Schedule schedule = new Schedule(dayOfWeek, startTime, endTime, null, 19L, "regular",
//						null);
//				log.debug("Schedule{} : {}", i, schedule);
				
				Schedule schedule = new Schedule(dayOfWeek, startTime, endTime, null, lecture.getLectureId(), "regular",
						null);
				schedule.setStartDate(LocalDate.now());

				log.debug("Schedule{} : {}", i, schedule);

				int scheduleId = manager.createSchedule(schedule);
				log.debug("Create Schedule : {}", scheduleId);
			}

		 return "redirect:/main/main";
		} catch (Exception e) { // 예외 발생 시 입력 form으로 forwarding
			request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			System.out.print(e);

			request.setAttribute("lecture", lecture);
			return "redirect:/member/login/form";
		}
	}
}
