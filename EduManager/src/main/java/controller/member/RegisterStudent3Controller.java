package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class RegisterStudent3Controller implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		// 관심 분야(categories) 배열 가져오기
		String[] selectedCategories = request.getParameterValues("categories");

		// 선택된 카테고리를 세션에 저장 (콤마로 합치거나 리스트로 저장 가능)
		if (selectedCategories != null) {
			session.setAttribute("interest", String.join(",", selectedCategories));
		} else {
			session.setAttribute("interest", "");
		}

		// 최종 등록 페이지로 리다이렉트
		return "redirect:/student/register";
	}
}
