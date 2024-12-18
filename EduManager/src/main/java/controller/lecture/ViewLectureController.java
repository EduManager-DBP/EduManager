package controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.domain.lecture.Lecture;
import model.domain.lecture.LectureReview;
import model.service.LectureManager;


public class ViewLectureController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!MemberSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form"; // 로그인하지 않았다면 로그인 폼으로 리다이렉트
        }

        Long lectureId = Long.parseLong(request.getParameter("lectureId"));
        System.out.println("그룹 ID: "+ lectureId );
        String stuId = MemberSessionUtils.getLoginMemberId(request.getSession());

        // LectureManager를 통해 강의 정보 조회
        LectureManager lectureManager = LectureManager.getInstance();
        Lecture lecture = lectureManager.findLectureById(lectureId);
        
        List<LectureReview> lectureReviewList = lectureManager.getReviewsByLectureId(lectureId);
      
        
        boolean isLiked = lectureManager.isLikedByUser(stuId, lectureId); // 인스턴스를 통해 호출
        System.out.println("좋아요 여부: "+ isLiked );
        request.setAttribute("isLiked", isLiked);
        
        boolean isInclude = lectureManager.isEnrolledInLecture(stuId, lectureId); // 인스턴스를 통해 호출
        System.out.println("수강 여부: "+ isInclude );
        request.setAttribute("isInclude", isInclude);
        
        
       
        
        // 강의 상세 정보 출력 (디버깅용)
        System.out.println("강의 ID: " + lecture.getLectureId() +
                           ", 강의 이름: " + lecture.getName() +
                           ", 카테고리: " + lecture.getCategory() +
                           ", 강의실: " + lecture.getLectureRoom() +
                           ", 강사 이름: " + lecture.getTeacherName() +
                           ", 강사 번호: " + lecture.getPhone());
        
        for (LectureReview review : lectureReviewList) {
            System.out.println("리뷰 내용: " + review.getMemberName());
            System.out.println("리뷰 내용: " + review.getReviewText());
        }

        // 로그인한 사용자 ID를 request에 저장
        request.setAttribute("userId", MemberSessionUtils.getLoginMemberId(request.getSession()));
        request.setAttribute("lectureId",  lectureId);
        request.setAttribute("lectureName",  lecture.getName());
        request.setAttribute("teacherName", lecture.getTeacherName());
        request.setAttribute("teacherPhone", lecture.getPhone());
        request.setAttribute("lectureroom", lecture.getLectureRoom());
        request.setAttribute("description", lecture.getDescription());
        request.setAttribute("lectureroom", lecture.getLectureRoom());
        request.setAttribute("reviewList", lectureReviewList);
        
        
        // 강의 상세 페이지로 이동
        return "/lecture/lecture_overview.jsp";
    }
}
        
        
