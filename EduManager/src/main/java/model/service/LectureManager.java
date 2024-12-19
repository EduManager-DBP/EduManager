package model.service;

import java.sql.SQLException;
import java.time.LocalDate;

import model.dao.lecture.LectureAssignmentDao;
import model.dao.lecture.LectureDao;
import model.dao.lecture.LectureLikeDao;
import model.dao.lecture.LectureReviewDao;
import model.dao.lecture.LectureNoticeDao;
import model.dao.lecture.LectureScheduleDao;
import model.domain.Schedule;
import model.domain.Notice;
import model.domain.Assignment;
import model.domain.calendar.CalendarDTO;
import model.domain.lecture.Lecture;
import model.domain.lecture.LectureEnrollment;
import model.domain.lecture.LectureReview;

import java.util.ArrayList;
import java.util.List;

public class LectureManager {
	private static LectureManager instance = new LectureManager();
	private LectureDao lectureDao;
	private LectureScheduleDao scheduleDao;
	private LectureNoticeDao noticeDao;
	private LectureAssignmentDao assignmentDao;
	private LectureLikeDao lectureLikeDao;
	private LectureReviewDao lectureReviewDao;


	private LectureManager() {
		lectureDao = new LectureDao();
		scheduleDao = new LectureScheduleDao();
		noticeDao = new LectureNoticeDao();
		assignmentDao = new LectureAssignmentDao();
		lectureLikeDao = new LectureLikeDao();
		lectureReviewDao = new LectureReviewDao();

	}

	public static LectureManager getInstance() {
		return instance;
	}

	/*
	 * public List<Lecture> findLectureList() throws SQLException{ return
	 * lectureDao.getAllLectures(); }
	 */
	// 특정 연도와 월의 데이터를 캘린더에 띄우기
	public List<Schedule> getScheduleCalendarList(int year, int month) {
		// DTO List 생성
//    	List<Schedule> calendarEntries = new ArrayList<>();

		// DAO 호출
		List<Schedule> schedules = scheduleDao.findSchedulesByDate(year, month);

		// 데이터 통합
//        calendarEntries.addAll(schedules);
//        calendarEntries.addAll(assignments);
//        calendarEntries.addAll(notices);

		return schedules;
	}
	public List<Notice> getNoticeCalendarList(int year, int month) {
		// DTO List 생성
//    	List<Schedule> calendarEntries = new ArrayList<>();

		// DAO 호출
		List<Notice> notices = noticeDao.findNoticesByDate(year, month);

		// 데이터 통합
//        calendarEntries.addAll(schedules);
//        calendarEntries.addAll(assignments);
//        calendarEntries.addAll(notices);

		return notices;
	}
	public List<Assignment> getAssignmentCalendarList(int year, int month) {
		// DTO List 생성
//    	List<Schedule> calendarEntries = new ArrayList<>();

		// DAO 호출
		List<Assignment> assignments = assignmentDao.findAssignmentsByDate(year, month);

		// 데이터 통합
//        calendarEntries.addAll(schedules);
//        calendarEntries.addAll(assignments);
//        calendarEntries.addAll(notices);

		return assignments;
	}

	public Lecture findLectureById(long lectureId) throws SQLException {
		return lectureDao.findLectureById(lectureId);
	}

	public Lecture createLecture(Lecture lecture) throws SQLException {
		return lectureDao.createLecture(lecture);
	}

	public int updateLecture(Lecture lecture) throws SQLException {// , LectureNotFoundException {
		return lectureDao.updateLecture(lecture);
	}

	public Lecture getLectureById(long lectureId) throws SQLException {
		return lectureDao.getLectureById(lectureId);
	}

	public List<Lecture> getLecturesExcludingStudent(String stuId) throws SQLException {
		return lectureDao.getLecturesExcludingStudent(stuId);
	}

	public List<Lecture> MyLectureList(String stuId) throws SQLException {
		return lectureDao.getMyLectureList(stuId);
	}

	 public List<Lecture> getMyLectureListByTeacher(String teacherId) {
	     return lectureDao.getMyLectureListByTeacher(teacherId);
	 }
	 
	public boolean isLikedByUser(String memberId, long lectureId) throws SQLException {
		return lectureLikeDao.isLikedByUser(memberId, lectureId);
	}

	public void toggleLectureLike(String memberId, long lectureId) throws SQLException {
		boolean isLiked = isLikedByUser(memberId, lectureId);
		if (isLiked) {
			// 좋아요가 있다면 삭제
			lectureLikeDao.removeLike(memberId, lectureId);
		} else {
			// 좋아요가 없다면 추가
			lectureLikeDao.addLike(memberId, lectureId);
		}
	}

	public List<Lecture> LectureLikeList(String stuId) throws SQLException {
		return lectureLikeDao.getLikedLectures(stuId);
	}
	
	  //현재 수강중인 강의인지 확인
    public boolean isEnrolledInLecture(String memberId, long lectureId) throws SQLException {
        return lectureReviewDao.isEnrolledInLecture(memberId, lectureId);
    }
    
    //강의 후기 작성
    public LectureReview createLectureReview(LectureReview lectureReview) throws SQLException {
        return lectureReviewDao.insertReview(lectureReview);       
    }
   
    //강의 후기 가져오기
    public List<LectureReview> getReviewsByLectureId(Long lectureId) throws SQLException {
        return lectureReviewDao.getReviewsByLectureId(lectureId);
    }

	// 정기 일정
	public int createSchedule(Schedule schedule) throws SQLException {
		return scheduleDao.createSchedule(schedule);
	}

	public List<Schedule> findScheduleById(long lectureId) throws SQLException {
		return scheduleDao.findSchedulesBylectureId(lectureId);
	}

	public void updateSchedule(Schedule schedule) throws SQLException {
		scheduleDao.updateSchedule(schedule);
	}

	public List<Integer> findScheduleIdsBylectureId(long lectureId) throws SQLException {
		return scheduleDao.findScheduleIdsBylectureId(lectureId);
	}

	public void deleteScheduleById(int scheduleId) {
		scheduleDao.deleteScheduleById(scheduleId);
	}
	
	//수강 신청
	
	public LectureEnrollment createLectureEnrollment(String memberId, long lectureId) throws SQLException {
	    return lectureDao.createLectureEnrollment(memberId, lectureId);
	}

	 public boolean isLectureConflict(String memberId, long lectureId) throws SQLException {
	     return lectureDao.isLectureConflict(memberId,lectureId);
	 }
	 
	 public boolean isEnrollmentExists(String memberId, long lectureId) throws SQLException {
	     return lectureDao.isEnrollmentExists(memberId, lectureId);
	 }
	 
	    //스터디 과제 목록 조회(특정 날짜)
	    public List<Assignment> findAssignmentsByLectureIdAndDueDate(int lectureId, LocalDate dueDate) {
	    	return assignmentDao.findAssignmentsByLectureIdAndDueDate(lectureId, dueDate);
	    }
	    //스터디 공지 목록 조회(특정 날짜)
	    public List<Notice> findNoticesByLectureIdAndDate(int lectureId, LocalDate createdAt){
	    	return noticeDao.findNoticesByLectureIdAndDate(lectureId, createdAt);
	    }
	    //스터디 일정 목록 조회
	    public List<Schedule> findSchedulesByFilters(long lectureId, LocalDate startDate, String type, String dayOfWeek) {
	    	return scheduleDao.findSchedulesByFilters(lectureId, startDate, type, dayOfWeek);
	    }

	    //스터디 공지 추가
	    public void createNotice(Notice notice) {
	    	noticeDao.createNotice(notice.getLectureId(), notice.getTitle(), notice.getDescription(), notice.getCreateat());
	    }
	    public void createAssignment(Assignment ass) {
	    	assignmentDao.createAssignment(ass.getLectureId(), ass.getTitle(), ass.getDescription(), ass.getDueDate(), "");
	    }
	    //스터디 멤버 조회
	    public List<String> findLectureMembers(int lectureId) throws SQLException {
	    	return lectureDao.findLectureMembers(lectureId);
	    }
	        
}