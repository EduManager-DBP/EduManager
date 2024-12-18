package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class RegisterStudent2Controller implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		// 입력받은 데이터 세션에 저장
		session.setAttribute("age", request.getParameter("age"));

		log.debug("age: ", request.getParameter("age"));

		return "redirect:/student/register3";
	}
}
