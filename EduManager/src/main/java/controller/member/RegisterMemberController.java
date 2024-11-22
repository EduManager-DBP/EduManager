package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.domain.member.Member;
import model.service.ExistingMemberException;
import model.service.MemberManager;

public class RegisterMemberController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        MemberManager manager = MemberManager.getInstance();

        if (request.getMethod().equals("GET")) {
            // GET request: 회원정보 등록 form 요청
            log.debug("RegisterForm Request");
//
//            List<Community> commList = manager.findCommunityList(); // 커뮤니티 리스트 검색
//            request.setAttribute("commList", commList);

            return "/member/registerForm.jsp"; // 검색한 커뮤니티 리스트를 registerForm으로 전송
        }

        // POST request (회원정보가 parameter로 전송됨)
        Member member = new Member(request.getParameter("id"), request.getParameter("pwd"),
                request.getParameter("name"), request.getParameter("email"), request.getParameter("phone"));

        log.debug("Create Member : {}", member);

        try {
            manager.create(member);
            return "redirect:/member/main"; // 성공 시 사용자 리스트 화면으로 redirect

        } catch (ExistingMemberException e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("member", member);
            return "/member/registerForm.jsp";
        }
    }
}
