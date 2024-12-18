package controller.study;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.Schedule;
import model.domain.lecture.Lecture;
import model.domain.studyGroup.StudyGroup;
import model.service.LectureManager;
import model.service.StudyManager;
import model.service.member.MemberManager;

public class UpdateStudyController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateStudyController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form"; // login form 요청으로 redirect
		}
		StudyManager manager = StudyManager.getInstance();
		HttpSession session = request.getSession();

		String leaderId = MemberSessionUtils.getLoginMemberId(request.getSession());
		System.out.print("내 아이디 : 스터디 리더:" + leaderId);

//		Long updateLectureId = Long.parseLong(request.getParameter("lectureId"));
		// 임시
		Long updateStudyId = 10L;

		log.debug("UpdateForm Request : {}", updateStudyId);
		if (request.getMethod().equals("GET")) {

			// GET request: 회원정보 수정 form 요청

			StudyGroup study = manager.findStudyById(updateStudyId);// 수정하려는 강의 정보 검색
			log.debug("UpdateForm Request : {}", study);

//    		if (MemberSessionUtils.isLoginMember(teacherId, session)) { 
			if (study.getLeaderId().equals(leaderId)) {
				// 현재 로그인한 사용자가 해당 강의의 강사인 경우 -> 수정 가능
				// 강의 일정 리스트 검색 
				List<Schedule> scheduleList = manager.findScheduleById(updateStudyId);
				request.setAttribute("scheduleList", scheduleList);
				request.setAttribute("scheduleCount", scheduleList.size()); // 길이를 추가

				request.setAttribute("study", study);
				return "/study/updateForm.jsp"; // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송
			}
		}
		
		// POST요청
		StudyGroup updateStudy = new StudyGroup(Long.parseLong(request.getParameter("studyId")),
				request.getParameter("name"), request.getParameter("img"), request.getParameter("description"),
				Long.parseLong(request.getParameter("capacity")), request.getParameter("category"), null, leaderId);

		log.debug("Update Study : {}", updateStudy);
		manager.updateStudy(updateStudy);

		// 강의 일정 리스트도 updateLecutreId이용해서 update
		try {
			 List<Integer> originalIds = manager.findScheduleIdsByStudyId(updateStudy.getStudyGroupId()); 
				log.debug("originalIds : {}", originalIds);

			int scheduleCount = Integer.parseInt(request.getParameter("scheduleCount"));// 처음에 value를 안정해줌. jsp에서 오류계속																						// 났었음.
			// 일정의 개수
			log.debug("scheduleCount : {}", scheduleCount);
			
			   // 이번 요청에서 유지된 일정 ID를 저장할 리스트
		    List<Integer> updatedIds = new ArrayList<>();
	

			for (int i = 0; i < scheduleCount; i++) { // 각 일정 항목의 값들을 받아오기 String
				
				String dayOfWeek = request.getParameter("schedule[" + i + "][day]");
				log.debug("dayOfWeek : {}", dayOfWeek);

				LocalTime startTime = LocalTime.parse(request.getParameter("schedule[" + i + "][startTime]"));
				LocalTime endTime = LocalTime.parse(request.getParameter("schedule[" + i + "][endTime]"));
				log.debug("startTime : {} endTime:{}", startTime, endTime);

				Schedule schedule = new Schedule(dayOfWeek, startTime, endTime, null, 0L,
						"regular", null);
				schedule.setStudyGroupId(updateStudy.getStudyGroupId());
				log.debug("Schedule{} : {}", i, schedule);

			    String scheduleIdStr = request.getParameter("schedule[" + i + "][scheduleId]");
			    int scheduleId = scheduleIdStr.equals("") ? 0 : Integer.parseInt(scheduleIdStr);
			    log.debug("scheduleId : {}", scheduleId);
			    
				if(scheduleId > 0) {//있던 일정이면 추가
					schedule.setScheduleId(scheduleId);
					manager.updateSchedule(schedule);
				}else {//없던 일정이면 생성
					scheduleId = manager.createSchedule(schedule);
					log.debug("Create Schedule : {}", scheduleId);
				}

		        // 처리된 일정 ID를 업데이트된 목록에 추가
		        updatedIds.add(scheduleId);

			}
			
			//있었는데 없어진 일정이면 삭제
		    // originalIds에서 updatedIds에 포함되지 않은 ID의 스케줄 삭제
		    for (int originalId : originalIds) {
		        if (!updatedIds.contains(originalId)) {
		            manager.deleteScheduleById(originalId);
		            log.debug("Deleted Schedule ID : {}", originalId);
		        }
		    }
			log.debug("updatedIds : {}", updatedIds);

			return "redirect:/main/main";
		} catch (Exception e) { // 예외 발생 시 입력 form으로 forwarding
			request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			System.out.print(e);

			request.setAttribute("updateStudy", updateStudy);
			return "redirect:/member/login/form";
		}
	}
}
