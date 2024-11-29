package controller.member;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// 세션에서 모든 데이터 가져오기
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String pwd = (String) session.getAttribute("pwd");
		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String phone = (String) session.getAttribute("phone");
		String ageRange = (String) session.getAttribute("age");

		// interest 데이터를 배열로 가져오기
		String[] interestArray = ((String) session.getAttribute("interest")).split(",");
		List<String> interestCategory = Arrays.asList(interestArray);

		// 학생 객체 생성
		Student student = new Student(id, pwd, name, email, phone, ageRange, interestCategory);
		Member member = new Member(id, pwd, name, email, phone);

		try {
			smanager.create(student);
			manager.create(member); // member DB에 생성

			// 세션 정리
			session.invalidate(); // 세션 전체 무효화

			response.getWriter().write("Student registration successful!");
			log.debug("Create User : {}", student);

			return "redirect:/main/main"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (ExistingMemberException e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("student", student);
			return "/member/studentRegisterForm.jsp";
		}
	}
}
