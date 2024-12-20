package controller.mypage;

import java.io.File;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.Controller;
import model.domain.member.Member;
import model.domain.member.Student;
import model.domain.member.Teacher;
import model.dao.member.MemberDAO;
import model.dao.member.StudentDAO;
import model.dao.member.TeacherDAO;
import controller.member.MemberSessionUtils;

public class EditMyInfoController implements Controller {
    private static final String UPLOAD_DIR = "images";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String memberId = (String) request.getSession().getAttribute("id");
        System.out.println("Session memberId: " + memberId); // 확인용 로그
        if (memberId == null) {
            return "redirect:/member/login/form";
        }

        String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Part filePart = request.getPart("profileImg");
        String fileName = extractFileName(filePart);
        String newFileName = null;
        String dbFilePath = null;

        // 파일이 업로드된 경우에만 새로운 파일 이름을 생성하고 저장
        if (filePart != null && fileName != null && !fileName.isEmpty()) {
            newFileName = System.currentTimeMillis() + "_" + fileName;
            String filePath = uploadPath + File.separator + newFileName;
            filePart.write(filePath); // 파일 저장
            dbFilePath = "/images/" + newFileName; // DB에 저장할 경로 설정
        }

        try {
            MemberDAO memberDAO = new MemberDAO();
            StudentDAO studentDAO = new StudentDAO();
            TeacherDAO teacherDAO = new TeacherDAO();

            // 사용자 정보 조회
            Member member = memberDAO.findMember(memberId);

            if (member != null) {
                // 업로드된 이미지가 있을 경우에만 이미지 경로를 업데이트
                if (dbFilePath != null) {
                    member.setImg(dbFilePath);
                }

                // 수정된 사용자 정보를 폼 데이터에서 가져오기
                String newPwd = request.getParameter("password");
                String newEmail = request.getParameter("email");
                String newPhone = request.getParameter("phone");

                // 학생 정보 업데이트
                if (studentDAO.existingStudent(memberId)) {
                    Student student = studentDAO.findStudent(memberId);

                    // 수정된 폼 데이터만 반영
                    if (newPwd != null && !newPwd.isEmpty()) {
                        student.setPwd(newPwd);
                        member.setPwd(newPwd);
                    }
                    if (newEmail != null && !newEmail.isEmpty()) {
                        student.setEmail(newEmail);
                        member.setEmail(newEmail);
                    }
                    if (newPhone != null && !newPhone.isEmpty()) {
                        student.setPhone(newPhone);
                        member.setPhone(newPhone);
                    }

                    // 학생 정보 업데이트
                    studentDAO.update(student);
                    memberDAO.update(member);

                } else if (teacherDAO.existingTeacher(memberId)) {
                    Teacher teacher = teacherDAO.findTeacher(memberId);

                    if (newPwd != null && !newPwd.isEmpty()) {
                        teacher.setPwd(newPwd);
                        member.setPwd(newPwd);
                    }
                    if (newEmail != null && !newEmail.isEmpty()) {
                        teacher.setEmail(newEmail);
                        member.setEmail(newEmail);
                    }
                    if (newPhone != null && !newPhone.isEmpty()) {
                        teacher.setPhone(newPhone);
                        member.setPhone(newPhone);
                    }

                    // 교사 정보 업데이트
                    teacherDAO.update(teacher);
                    memberDAO.update(member);
                }

                return "redirect:/mypage/myInfo"; // 내 정보 페이지로 이동
            } else {
                request.setAttribute("error", "사용자 정보를 찾을 수 없습니다.");
                return "/main/main.jsp"; // 에러 발생 시 메인 페이지로 이동
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "내 정보를 불러오는 도중 오류가 발생했습니다.");
            return "/main/main.jsp"; // 에러 발생 시 메인 페이지로 이동
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
