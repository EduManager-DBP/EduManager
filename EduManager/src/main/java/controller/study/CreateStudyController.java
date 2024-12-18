package controller.study;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.Schedule;
import model.domain.studyGroup.StudyGroup;
import model.service.StudyManager;

public class CreateStudyController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateStudyController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form"; // login form 요청으로 redirect
		}

		String leaderId = MemberSessionUtils.getLoginMemberId(request.getSession());
		System.out.print("내 아이디 : 스터디 리더:" + leaderId);

		// GET요청
		if (request.getMethod().equals("GET")) {
			return "/study/creationForm.jsp";
		}

		// POST요청
		StudyGroup study = new StudyGroup(0L, request.getParameter("name"), request.getParameter("img"),request.getParameter("description"), Long.parseLong(request.getParameter("capacity")),
				request.getParameter("category"), null, leaderId);
	

		try {
			StudyManager manager = StudyManager.getInstance();
			study = manager.createStudy(study);
			log.debug("Create Lecture : {}", study.getStudyGroupId());

			int scheduleCount = Integer.parseInt(request.getParameter("scheduleCount"));//처음에 value를 안정해줌. jsp에서 오류계속 났었음.
//			// 일정의 개수
//			log.debug("scheduleCount : {}", scheduleCount);
			for (int i = 0; i < scheduleCount; i++) { // 각 일정 항목의 값들을 받아오기 String
				String dayOfWeek = request.getParameter("schedule[" + i + "][day]");
//				log.debug("dayOfWeek : {}", dayOfWeek);

				LocalTime startTime = LocalTime.parse(request.getParameter("schedule[" + i + "][startTime]"));
				LocalTime endTime = LocalTime.parse(request.getParameter("schedule[" + i + "][endTime]"));
//				log.debug("startTime : {} endTime:{}", startTime, endTime);
				
				Schedule schedule = new Schedule(dayOfWeek, startTime, endTime, null, 0L, "regular",
						null);
				schedule.setStudyGroupId(study.getStudyGroupId());
				log.debug("Schedule{} : {}", i, schedule);

				int scheduleId = manager.createSchedule(schedule);
				log.debug("Create Schedule : {}", scheduleId);
			}

			return "redirect:/main/main";
		} catch (Exception e) { // 예외 발생 시 입력 form으로 forwarding
			request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			System.out.print(e);

			request.setAttribute("study", study);
			return "redirect:/member/login/form";
		}
	}
}
