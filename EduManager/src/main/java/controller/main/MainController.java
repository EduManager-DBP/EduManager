package controller.main;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.member.Member;
import model.service.MemberManager;

public class MainController implements Controller {
    // private static final int countPerPage = 100; // 한 화면에 출력할 사용자 수

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // login form 요청으로 redirect
        }

        /*
         * String currentPageStr = request.getParameter("currentPage"); int currentPage
         * = 1; if (currentPageStr != null && !currentPageStr.equals("")) { currentPage
         * = Integer.parseInt(currentPageStr); }
         */

        // 사용자 리스트 화면으로 이동(forwarding)
        return "/main/main.jsp";
    }
}
