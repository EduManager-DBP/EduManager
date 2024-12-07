package controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.lecture.CreateLectureController;
import controller.lecture.UpdateLectureController;
import controller.main.MainController;
import controller.member.DeleteMemberController;
import controller.member.LoginController;
import controller.member.LogoutController;
import controller.member.RegisterMemberController;
import controller.member.RegisterStudent1Controller;
import controller.member.RegisterStudent2Controller;
import controller.member.RegisterStudent3Controller;
import controller.member.RegisterStudentController;
import controller.member.RegisterTeacherController;
import controller.member.UpdateMemberController;
import controller.mypage.DeleteAccountController;
import controller.mypage.ViewMyInfoController;
import controller.study.CreateStudyController;
import controller.study.UpdateStudyController;

//import controller.user.*;
//import controller.comm.*;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	// 각 요청 URI에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<>();

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
		mappings.put("/member/register/form", new RegisterMemberController());
		mappings.put("/teacher/register", new RegisterTeacherController());
		mappings.put("/student/register1", new RegisterStudent1Controller());
		mappings.put("/student/register2", new RegisterStudent2Controller());
		mappings.put("/student/register3", new RegisterStudent3Controller());
		mappings.put("/student/register", new RegisterStudentController());

		// 마이페이지 내 정보 보기
		mappings.put("/mypage/myInfo", new ViewMyInfoController());

		// 마이페이지 탈퇴하기
		mappings.put("/mypage/deleteConfirm", new ForwardController("/mypage/deleteConfirm.jsp"));
		mappings.put("/mypage/deleteAccount", new DeleteAccountController());

		// 사용자 수정
		mappings.put("/member/update", new UpdateMemberController());
		mappings.put("/member/delete", new DeleteMemberController());

		// study
		mappings.put("/study/details", new ForwardController("/study/study_details.jsp"));

		// 강의 등록 : get->page 띄우기 post:등록 요청
		mappings.put("/lecture/create", new CreateLectureController());

		// 강의 수정: get->page 띄우기 post:등록 요청
		mappings.put("/lecture/update", new UpdateLectureController());
		
		//스터디 등록
		mappings.put("/study/create", new CreateStudyController());

		//스터디 수정
		mappings.put("/study/update", new UpdateStudyController());

		mappings.put("/registration", new ForwardController("/registration/registration.jsp"));
		mappings.put("/lecture/over-view", new ForwardController("/lecture/lecture_overview.jsp"));
		mappings.put("/study/over-view", new ForwardController("/study/study_overview.jsp"));
		mappings.put("/study/requests", new ForwardController("/study/study_request.jsp"));
		mappings.put("/student-mypage", new ForwardController("/mypage/student_mypage.jsp"));
		mappings.put("/study/list", new ForwardController("/study/my_study_list.jsp"));

		logger.info("Mappings initialized: {}", mappings.keySet());
		logger.info("Initialized Request Mapping!");

		mappings.put("/editMyInfo", new ForwardController("/mypage/editMyInfo.jsp"));
	}

	public Controller findController(String uri) {
		// 주어진 URI에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}

}