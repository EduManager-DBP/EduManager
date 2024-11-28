package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.lecture.Lecture;
import model.service.LectureManager;

public class CreateLectureController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//teacherId는 세션에 저장했다가 가져와야 할 수도
		if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
		String teacherId = MemberSessionUtils.getLoginMemberId(request.getSession());
		System.out.print("내 아이디 : 선생일 때:"+ teacherId);
		
		Lecture lecture = new Lecture(
			    request.getParameter("name"),
			    request.getParameter("img"),
			    request.getParameter("category"),
			    Long.parseLong(request.getParameter("capacity")), // String -> long 변환
			    Integer.parseInt(request.getParameter("level")),
			    request.getParameter("description"),
			    teacherId, // String -> long 변환
			    Integer.parseInt(request.getParameter("lectureRoom"))// String -> Integer 변환
			);

    		try {
    			LectureManager manager = LectureManager.getInstance();
    			lecture = manager.createLecture(lecture);
    			
/*    	    	log.debug("Create Lecture : {}", lecture);
    	        return "redirect:/lecture/list";	// 성공 시 커뮤니티 리스트 화면으로 redirect
*/    	        return "redirect:/main/main";
    		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
                request.setAttribute("creationFailed", true);
    			request.setAttribute("exception", e);
    			request.setAttribute("lecture", lecture);
    			return "/lecture/creationForm.jsp";
    		}
	}
}
