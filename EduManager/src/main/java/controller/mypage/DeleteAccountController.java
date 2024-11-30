package controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dao.member.MemberDAO;
import model.dao.member.StudentDAO;
import model.dao.member.TeacherDAO;
import controller.member.MemberSessionUtils;


public class DeleteAccountController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("id"); // 세션에서 사용자 ID 가져오기

        if (memberId == null) {
            return "redirect:/member/login/form"; // 로그인 상태가 아니면 로그인 페이지로 이동
        }

        MemberDAO memberDAO = new MemberDAO();
        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();

        try {
            // 공통 Member 데이터 삭제
            int memberDeleted = memberDAO.remove(memberId);
            if (memberDeleted > 0) {
                // 해당 ID를 가진 STUDENT 데이터 삭제
                if (studentDAO.existingStudent(memberId)) {
                    studentDAO.remove(memberId);
                }
                // 해당 ID를 가진 TEACHER 데이터 삭제
                else if (teacherDAO.existingTeacher(memberId)) {
                    teacherDAO.remove(memberId);
                }
            }

            // 세션 무효화
            session.invalidate();

            return "redirect:/"; // 메인 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "계정 삭제 중 오류가 발생했습니다.");
            return "/error.jsp"; // 에러 페이지로 이동
        }
    }
}