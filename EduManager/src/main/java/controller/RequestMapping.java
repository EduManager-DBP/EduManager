package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.main.MainController;
import controller.member.DeleteMemberController;
import controller.member.ListMemberController;
import controller.member.LoginController;
import controller.member.LogoutController;
import controller.member.RegisterMemberController;
import controller.member.UpdateMemberController;

//import controller.user.*;
//import controller.comm.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    // 각 요청 URI에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        // 각 URI에 대응되는 controller 객체를 생성 및 저장
        // 로그인/로그아웃 요청
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/member/login/form", new ForwardController("/member/loginForm.jsp"));
        mappings.put("/member/login", new LoginController());
        mappings.put("/member/logout", new LogoutController());

        // 메인 화면
        mappings.put("/main/main", new MainController());

        // 회원가입 요청
        mappings.put("/member/register", new RegisterMemberController());

        // 사용자 수정
        mappings.put("/member/update", new UpdateMemberController());

        // 사용자 삭제
        mappings.put("/member/delete", new DeleteMemberController());

        logger.info("Mappings initialized: {}", mappings.keySet());
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {
        // 주어진 URI에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}