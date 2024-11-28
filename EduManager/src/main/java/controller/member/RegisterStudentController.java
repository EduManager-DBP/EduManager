package controller.member;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.domain.member.Member;
import model.domain.member.Student;
import model.service.ExistingMemberException;
import model.service.MemberManager;
import model.service.StudentManager;

public class RegisterStudentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterStudentController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		StudentManager smanager = StudentManager.getInstance();
		MemberManager manager = MemberManager.getInstance();

		// POST request (회원정보가 parameter로 전송됨)
		Student student = new Student(request.getParameter("id"), request.getParameter("pwd"),
				request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"),
				request.getParameter("ageRange"), Arrays.asList(request.getParameterValues("interestCategory")));

		Member member = new Member(request.getParameter("id"), request.getParameter("pwd"),
				request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"));

		log.debug("Create User : {}", student);

		try {
			smanager.create(student);
			manager.create(member); // member DB에 생성

			return "redirect:/main/main"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (ExistingMemberException e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("student", student);
			return "/member/studentRegisterForm.jsp";
		}
	}
}
